package com.opelooo.scrcpyGUI;

//<editor-fold defaultstate="collapsed" desc=" imports ">
import java.io.*;
import java.nio.file.Paths;
import java.util.*;
import javax.swing.*;
import java.util.regex.*;
import java.util.stream.Stream;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
//</editor-fold>

/**
 *
 * @author opelooo
 */
public class GUI_functions {

    private static String adb = "adb";
    private static String scrcpy = "scrcpy";

    /**
     * Method to check if there is adb and scrcpy in folder where .jar at.
     * Execute FileInputStream and catch error if there is no adb/scrcpy exe
     * file.
     *
     * @param errorHandler interface PopupHandler
     * @return {@code List<String> output}
     * @author opelooo
     */
    public static int checkAdb_Scrcpy_InFolder(PopupHandler errorHandler) {
        // check adb and scrcpy in environment variable
        if (checkAdb_Scrcpy_InEnvironment(errorHandler) == 1) {
            return 1;
        }

        // Check for adb and scrcpy executables in the folder
        String[] programs = {"adb.exe", "scrcpy.exe"};
        StringBuilder error = new StringBuilder();

        for (String program : programs) {
            File programFile = Paths.get(program).toFile();
            if (!programFile.exists()) {
                error.append("\n").append(program).append(" not found in folder.");
            }
        }

        // If error occurred, show the error and return -1
        if (error.length() > 0) {
            errorHandler.showError("Programs not found in folder, cannot run program: " + error);
            return -1;
        }

        GUI_functions.adb = "adb.exe";
        GUI_functions.scrcpy = "scrcpy.exe";
        return 1;
    }

    /**
     * Method to check if there is adb and scrcpy in environment variable.
     *
     * @param errorHandler interface PopupHandler
     * @return {@code List<String> output}
     * @author opelooo
     */
    private static int checkAdb_Scrcpy_InEnvironment(PopupHandler errorHandler) {
        StringBuilder error = new StringBuilder();

        // Check adb and scrcpy in the environment
        if (!checkProgramInEnvironment(adb, error) || !checkProgramInEnvironment(scrcpy, error)) {
            errorHandler.showError("Cannot find adb or scrcpy in environment!\n" + error);
            return -1;
        }

        return 1;
    }

    /**
     * Helper method to check if a program is available in the environment.
     * Execute {@code adb --version} and {@code scrcpy --version} command using ProcessBuilder.
     *
     * @param errorHandler interface PopupHandler
     * @return {@code List<String> output}
     * @author opelooo
     */ 
    private static boolean checkProgramInEnvironment(String program, StringBuilder error) {
        try {
            ProcessBuilder pb = new ProcessBuilder(program, "--version"); // Run the version command to check
            Process process = pb.start();
            int exitCode = process.waitFor(); // Wait for the process to finish and get the exit code

            if (exitCode != 0) {
                error.append(program).append(" returned non-zero exit code: ").append(exitCode).append("\n");
                return false;
            }

        } catch (IOException | InterruptedException e) {
            error.append("Error checking ").append(program).append(": ").append(e.getMessage()).append("\n");
            return false;
        }
        return true;
    }

    /**
     * Method to list devices connected to the computer, this method execute
     * {@code adb devices} command using ProcessBuilder.
     *
     * @param errorHandler
     * @return {@code List<String> output}
     * @author opelooo
     */
    public static List<String> adb_devices(PopupHandler errorHandler) {
        List<String> output = new ArrayList<>();
        try {
            // Create a process to execute 'adb devices'
            ProcessBuilder pb = new ProcessBuilder(adb, "devices");
            Process process = pb.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                // Skip the first line that contains 'List of devices attached'
                if (line.contains("List of devices attached") || line.trim().isEmpty()) {
                    continue;
                }
                output.add(line.replace("device", "").trim());  // Add device to output list
            }

            // Wait for the process to complete
            process.waitFor();
        } catch (IOException | InterruptedException | NullPointerException e) {
            errorHandler.showError("Exception occurred: " + e.getMessage());
        }
        return output;
    }

    /**
     * Method to customize run scrcpy, this method execute
     * {@code scrcpy -s device_code -m 1024 -b 2M} command using ProcessBuilder.
     *
     * @param errorHandler
     * @param device_code device ID from adb devices list
     * @param maxSize maximum size of mirroring panel
     * @param bitRate bit rate transfer for mirroring
     * @param videoOn toggle mirror the video
     * @param screenOn toggle phone screen on or off
     * @param stayAwake toggle option to stay awake mode
     *
     * @author opelooo
     */
    public static void run_scrcpy(PopupHandler errorHandler,
            String device_code, String maxSize, String bitRate,
            boolean videoOn, boolean screenOn, boolean stayAwake) {
        JDialog dialog = errorHandler.progressBarDialog();
        new Thread(() -> {
            try {
                // creating list of process
                List<String> list = new ArrayList<>(Arrays.asList(
                        scrcpy, "-s", device_code, String.format("-m %s", maxSize)
                ));

                Stream.of(
                        videoOn ? null : "--no-video",
                        screenOn ? null : "--turn-screen-off",
                        stayAwake ? "--stay-awake" : null,
                        !bitRate.isEmpty() ? String.format("-b %s", bitRate) : null
                ).filter(Objects::nonNull).forEach(list::add);

                // Create a process
                ProcessBuilder pb = new ProcessBuilder(list);
                pb.start();

                TimeUnit.MILLISECONDS.sleep(1500);
                SwingUtilities.invokeLater(() -> {
                    dialog.dispose();  // Close the dialog
                });

            } catch (IOException | NullPointerException | InterruptedException e) {
                SwingUtilities.invokeLater(() -> {
                    dialog.dispose();  // Close the dialog
                    errorHandler.showError("Exception occurred: " + e.getMessage());
                });
            }
        }).start();  // Start the new thread
    }

    /**
     * Method to get device info product manufaturer, this method execute
     * {@code adb -s device_code shell getprop ro.product.manufacturer} command
     * using ProcessBuilder.
     *
     * @param errorHandler
     * @param device_code device ID from adb devices list
     * @return {@code String output}
     * @author opelooo
     */
    public static String adb_device_info(PopupHandler errorHandler, String device_code) {
        String output = new String();
        try {
            // Create a process
            ProcessBuilder pb = new ProcessBuilder(
                            adb, "-s", device_code, "shell",
                            "getprop", "ro.product.manufacturer"
                    );
            Process process = pb.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                // Skip the first line that contains 'List of devices attached'
                if (line.trim().isEmpty()) {
                    continue;
                }
                output = line.trim();  // Add device to output list
            }

            // Wait for the process to complete
            process.waitFor();
        } catch (IOException | InterruptedException | NullPointerException e) {
            errorHandler.showError("Exception occurred: " + e.getMessage());
        }
        return output;
    }

    /**
     * Method to get device info IP Address, this method execute
     * {@code adb -s device_code shell ip route} command using ProcessBuilder.
     * After that, the output filtered using regex.
     *
     * @param errorHandler
     * @param device_code device ID from adb devices list
     * @return {@code String device_ip_addr}
     * @author opelooo
     */
    public static String adb_get_device_ip(PopupHandler errorHandler, String device_code) {
        String device_ip_addr = new String();
        try {
            // Create a process to execute 'adb devices'
            ProcessBuilder pb = new ProcessBuilder(
                            adb, "-s", device_code, "shell",
                            "ip", "route"
                    );
            Process process = pb.start();

            String regex = "src (\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b)";

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                // Compile the pattern and create a matcher
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(line.trim());

                // If an IP address is found, assign it to device_ip_addr
                if (line.contains("wlan") && matcher.find()) {
                    device_ip_addr = matcher.group(1);
                }
            }

            // Wait for the process to complete
            process.waitFor();
        } catch (IOException | InterruptedException | NullPointerException e) {
            errorHandler.showError("Exception occurred: " + e.getMessage());
        }
        return device_ip_addr;
    }

    public static void adb_connect_tcpip(PopupHandler errorHandler, String device_code) {
        JDialog dialog = errorHandler.progressBarDialog();
        String deviceIP = adb_get_device_ip(errorHandler, device_code);

        new Thread(() -> {
            try {
                List<String> adbTcpIpMode = new ArrayList<>(Arrays.asList(
                        adb, "-s", device_code, "tcpip", "5555"
                ));
                List<String> adbConnectDevice = new ArrayList<>(Arrays.asList(
                        adb, "connect", String.format("%s:5555", deviceIP)
                ));
                List<String> scrcpyTcpIp = new ArrayList<>(Arrays.asList(
                        scrcpy, String.format("--tcpip=%s:5555", deviceIP)
                ));

                // Create a process
                ProcessBuilder pbAdbTcpIpMode = new ProcessBuilder(adbTcpIpMode);
                pbAdbTcpIpMode.start();

                ProcessBuilder pbAdbConnectDevice = new ProcessBuilder(adbConnectDevice);
                pbAdbConnectDevice.start();

                ProcessBuilder pbScrcpyTcpIp = new ProcessBuilder(scrcpyTcpIp);
                pbScrcpyTcpIp.start();

                TimeUnit.MILLISECONDS.sleep(1500);
                SwingUtilities.invokeLater(() -> {
                    dialog.dispose();  // Close the dialog
                });
            } catch (IOException | InterruptedException | NullPointerException e) {
                SwingUtilities.invokeLater(() -> {
                    errorHandler.showError("Exception occurred: " + e.getMessage());
                    dialog.dispose();  // Close the dialog
                });
            }
        }).start();
    }

}

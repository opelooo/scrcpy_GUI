/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author opelooo
 */
public class Scrcpy_GUI {

    /**
     * Method to list devices connected to the computer, this method execute
     * {@code adb devices} command using ProcessBuilder.
     *
     * @return {@code List<String> output}
     * @author opelooo
     */
    public static List<String> adb_devices() {
        List<String> output = new ArrayList<>();
        try {
            // Create a process to execute 'adb devices'
            ProcessBuilder pb = new ProcessBuilder("adb", "devices");
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
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();  // Handle exceptions properly
        }

        return output;
    }

    /**
     * Method to run scrcpy, this method execute
     * {@code scrcpy -s device_code -m 1024 -b 2M} command using ProcessBuilder.
     *
     * @param device_code device ID from adb devices list
     *
     * @author opelooo
     */
    public static void run_scrcpy(String device_code) {
        new Thread(() -> {
            try {
                // Create a process to execute 'scrcpy'
                ProcessBuilder pb
                        = new ProcessBuilder(
                                "scrcpy", "-s", device_code, "-m 1024", "-b 2M"
                        );

                pb.start();
                // Optionally, monitor the process if needed
            } catch (IOException e) {
                e.printStackTrace();  // Handle exceptions properly
            }
        }).start();  // Start the new thread
    }

    /**
     * Method to customize run scrcpy, this method execute
     * {@code scrcpy -s device_code -m 1024 -b 2M} command using ProcessBuilder.
     *
     * @param device_code device ID from adb devices list
     * @param maxSize maximum size of mirroring panel
     * @param bitRate bit rate transfer for mirroring
     * @param videoOn toggle mirror the video
     * @param screenOn toggle phone screen on or off
     * @param stayAwake toggle option to stay awake mode
     *
     * @author opelooo
     */
    public static void custom_run_scrcpy(
            String device_code, String maxSize, String bitRate,
            boolean videoOn, boolean screenOn, boolean stayAwake) {
        new Thread(() -> {
            try {
                // creating list of process
                List<String> list = new ArrayList<>();
                list.add("scrcpy");
                list.add("-s");
                list.add(device_code);
                list.add(String.format("-m %s", maxSize));
                list.add(String.format("-b %s", bitRate));

                if (!videoOn) {
                    list.add("--no-video");
                }
                if (!screenOn) {
                    list.add("--turn-screen-off");
                }
                if (stayAwake) {
                    list.add("--stay-awake");
                }
                
                // Create a process
                ProcessBuilder pb = new ProcessBuilder(list);

                pb.start();
                // Optionally, monitor the process if needed
            } catch (IOException e) {
                e.printStackTrace();  // Handle exceptions properly
            }
        }).start();  // Start the new thread
    }

    /**
     * Method to get device info product manufaturer, this method execute
     * {@code adb -s device_code shell getprop ro.product.manufacturer} command
     * using ProcessBuilder.
     *
     * @param device_code device ID from adb devices list
     * @return {@code String output}
     * @author opelooo
     */
    public static String adb_device_info(String device_code) {
        String output = new String();
        try {
            // Create a process
            ProcessBuilder pb
                    = new ProcessBuilder(
                            "adb", "-s", device_code, "shell",
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
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();  // Handle exceptions properly
        }

        return output;
    }
    
    /**
     * Method to get device info IP Address, this method execute
     * {@code adb -s device_code shell ip route} command
     * using ProcessBuilder. After that, the output filtered using regex.
     *
     * @param device_code device ID from adb devices list
     * @return {@code String device_ip_addr}
     * @author opelooo
     */
    public static String adb_get_device_ip(String device_code) {
        String device_ip_addr = new String();
        try {
            // Create a process to execute 'adb devices'
            ProcessBuilder pb
                    = new ProcessBuilder(
                            "adb", "-s", device_code, "shell",
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
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();  // Handle exceptions properly
        }

        return device_ip_addr;
    }

    public static void adb_connect_tcpip(String device_code) {
        
    }

}

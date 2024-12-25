/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.io.*;
import java.util.*;

/**
 *
 * @author opelooo
 */
public class Scrcpy_GUI {

    /**
     * Method to list devices connected to the computer,
     * this method execute {@code adb devices} command using ProcessBuilder.
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
     * Method to run scrcpy,
     * this method execute {@code scrcpy -s device_code -m 1024 -b 2M} command using ProcessBuilder.
     * 
     * @param device_code device ID from adb devices list
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
     * Method to get device info product manufaturer,
     * this method execute 
     * {@code adb -s device_code shell getprop ro.product.manufacturer} command using ProcessBuilder.
     * 
     * @param device_code device ID from adb devices list
     * @return {@code String output} 
     * @author opelooo
     */
    public static String adb_device_info(String device_code) {
        String output = new String();
        try {
            // Create a process to execute 'adb devices'
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

    public static void adb_connect_tcpip() {

    }

}

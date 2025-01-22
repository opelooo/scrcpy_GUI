/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author opelooo
 */
public class test {
    private final String curr_os  = getOperatingSystem();

    public static String getOperatingSystem() {
        String os = System.getProperty("os.name");
        // System.out.println("Using System Property: " + os);
        return os;
    }
    
    public static void main(String[] args) {
        System.out.println(getOperatingSystem());
    }
}

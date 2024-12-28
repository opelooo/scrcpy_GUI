package com.opelooo.scrcpyGUI;

import javax.swing.JDialog;

/**
 *
 * @author Administrator
 */
public interface PopupHandler {
    
    /**
     * Method to show popup message containing error happening
     *
     * @param errorMessage String containing error message
     */
    void showError(String errorMessage);
    
    /**
     * Method to show popup message containing device info
     *
     * @param message String containing device info message
     */
    void showDeviceInfo(String message);
    
    /**
     * Method to create new JDialog for progress bar
     *
     * @return JDialog creating new JDialog
     */
    JDialog progressBarDialog();
}

package com.opelooo.scrcpyGUI;

import javax.swing.JDialog;

/**
 *
 * @author opelooo
 */
public interface PopupHandler {
    
    /**
     * Method to show popup message containing error happening
     *
     * @param errorMessage String containing error message
     */
    void showError(String errorMessage);
    
    /**
     * Method to show popup message containing error happening
     *
     * @param infoMessage String containing information message
     * @param typeOfInfo contain title showing type of information
     */
    void showInfo(String infoMessage, String typeOfInfo);
    
    /**
     * Method to create new JDialog for progress bar
     *
     * @return JDialog creating new JDialog
     */
    JDialog progressBarDialog();
}

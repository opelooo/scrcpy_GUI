package com.opelooo.scrcpyGUI;

import javax.swing.JDialog;

/**
 *
 * @author Administrator
 */
public interface PopupHandler {

    void showError(String errorMessage);
    void showDeviceInfo(String message);
    JDialog progressBarDialog();
}

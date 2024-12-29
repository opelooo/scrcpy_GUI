package com.opelooo.scrcpyGUI;

//<editor-fold defaultstate="collapsed" desc=" imports ">
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
//</editor-fold>

/**
 *
 * @author opelooo
 */
public class scrcpy_main_panel extends javax.swing.JFrame implements PopupHandler {

    private final DefaultListModel<String> listModel_JD;  // Declare the list model
    private JPopupMenu popupMenu;  // The popup menu

    /**
     * Creates new form scrcpy_main_panel
     */
    public scrcpy_main_panel() {
        initComponents();
        setIcon("/resources/icon.png");

        listModel_JD = new DefaultListModel<>();  // Initialize the list model
        list_devices.setModel(listModel_JD);     // Set the list model to JList
        if (GUI_functions.checkAdb_Scrcpy_InFolder(this) == 1) {
            updateDeviceList();
        }
        poupMenuDeviceInfo();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        deviceCodeList = new javax.swing.JScrollPane();
        list_devices = new javax.swing.JList<>();
        optionMenuPanel = new javax.swing.JPanel();
        currDeviceCode = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        videoBitRate = new javax.swing.JTextField();
        bitRateSlider = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        maxSize = new javax.swing.JTextField();
        toggleVideoButton = new javax.swing.JToggleButton();
        toggleScreenButton = new javax.swing.JToggleButton();
        toggleStayAwake = new javax.swing.JToggleButton();
        recordVideoButton = new javax.swing.JToggleButton();
        recordAudioButton = new javax.swing.JToggleButton();
        audioFormats = new javax.swing.JComboBox<>();
        videoFormats = new javax.swing.JComboBox<>();
        buttonMenuPanel = new javax.swing.JPanel();
        refreshButton = new javax.swing.JButton();
        selectButton = new javax.swing.JButton();
        runCustomButton = new javax.swing.JButton();
        tcpipButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Minimal GUI Scrcpy");
        setIconImages(null);
        setName("MainFrame"); // NOI18N
        setResizable(false);

        list_devices.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        deviceCodeList.setViewportView(list_devices);

        currDeviceCode.setBackground(new java.awt.Color(204, 204, 204));
        currDeviceCode.setText("No Device Selected");

        jLabel1.setText("video bit rate:");

        videoBitRate.setText("2M");

        bitRateSlider.setMajorTickSpacing(5);
        bitRateSlider.setMaximum(50);
        bitRateSlider.setMinimum(1);
        bitRateSlider.setMinorTickSpacing(2);
        bitRateSlider.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bitRateSlider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                bitRateSliderMouseDragged(evt);
            }
        });

        jLabel2.setText("max mirroring size:");

        maxSize.setText("1024");

        toggleVideoButton.setSelected(true);
        toggleVideoButton.setText("Video On");

        toggleScreenButton.setSelected(true);
        toggleScreenButton.setText("Turn Screen On");

        toggleStayAwake.setText("Stay Awake");

        recordVideoButton.setText("Record Video On");

        recordAudioButton.setText("Record Audio On");

        audioFormats.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "m4a", "wav", "flac", "opus", "aac", "mka" }));

        videoFormats.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "mp4", "mkv" }));

        javax.swing.GroupLayout optionMenuPanelLayout = new javax.swing.GroupLayout(optionMenuPanel);
        optionMenuPanel.setLayout(optionMenuPanelLayout);
        optionMenuPanelLayout.setHorizontalGroup(
            optionMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionMenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(optionMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(optionMenuPanelLayout.createSequentialGroup()
                        .addComponent(recordAudioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(audioFormats, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(optionMenuPanelLayout.createSequentialGroup()
                        .addComponent(recordVideoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(videoFormats, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(optionMenuPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(optionMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(videoBitRate, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bitRateSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(toggleVideoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, optionMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(currDeviceCode)
                        .addGroup(optionMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(toggleScreenButton, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(toggleStayAwake, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(optionMenuPanelLayout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(maxSize, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        optionMenuPanelLayout.setVerticalGroup(
            optionMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionMenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(currDeviceCode)
                .addGap(17, 17, 17)
                .addGroup(optionMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(optionMenuPanelLayout.createSequentialGroup()
                        .addComponent(bitRateSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(videoBitRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(optionMenuPanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(optionMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maxSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toggleVideoButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(toggleScreenButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(toggleStayAwake)
                .addGap(12, 12, 12)
                .addGroup(optionMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recordVideoButton)
                    .addComponent(videoFormats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(optionMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recordAudioButton)
                    .addComponent(audioFormats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        selectButton.setText("Info");
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });

        runCustomButton.setText("Run");
        runCustomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runCustomButtonButtonActionPerformed(evt);
            }
        });

        tcpipButton.setText("TCP/IP");
        tcpipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcpipButtonButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonMenuPanelLayout = new javax.swing.GroupLayout(buttonMenuPanel);
        buttonMenuPanel.setLayout(buttonMenuPanelLayout);
        buttonMenuPanelLayout.setHorizontalGroup(
            buttonMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonMenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(refreshButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(selectButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(runCustomButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tcpipButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        buttonMenuPanelLayout.setVerticalGroup(
            buttonMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonMenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(refreshButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(runCustomButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tcpipButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(deviceCodeList, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonMenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(optionMenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optionMenuPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonMenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deviceCodeList))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tcpipButtonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcpipButtonButtonActionPerformed
        // TODO add your handling code here:
        String selectedDevice = list_devices.getSelectedValue();
        GUI_functions.adb_connect_tcpip(this, selectedDevice);
    }//GEN-LAST:event_tcpipButtonButtonActionPerformed

    private void runCustomButtonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runCustomButtonButtonActionPerformed
        // TODO add your handling code here:
        String selectedDevice = list_devices.getSelectedValue();

        GUI_functions.run_scrcpy(this,
                selectedDevice, maxSize.getText(), videoBitRate.getText(),
                toggleVideoButton.isSelected(), toggleScreenButton.isSelected(),
                toggleStayAwake.isSelected()
        );
    }//GEN-LAST:event_runCustomButtonButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
        updateDeviceList();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
        // TODO add your handling code here:
        String selectedDevice = list_devices.getSelectedValue();
        showDeviceInfo("Device Info for: " + selectedDevice
                + "\nDevice Manufacturer: " + GUI_functions.adb_device_info(this, selectedDevice));
    }//GEN-LAST:event_selectButtonActionPerformed

    private void bitRateSliderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bitRateSliderMouseDragged
        // TODO add your handling code here:
        videoBitRate.setText(String.format("%dM", bitRateSlider.getValue()));
    }//GEN-LAST:event_bitRateSliderMouseDragged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" look and feel ">
        try {
            // Set the FlatLaf Dark theme look and feel
            javax.swing.UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(scrcpy_main_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        // Get the screen size as a java dimension
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            javax.swing.JFrame mainFrame = new scrcpy_main_panel();
            // Calculate the frame location
            int x1 = (screenSize.width - mainFrame.getWidth()) / 2;
            int y1 = (screenSize.height - mainFrame.getHeight()) / 2;
            // Set the location of the frame
            mainFrame.setLocation(x1, y1);
            mainFrame.setVisible(true);
        });
    }

    //<editor-fold defaultstate="collapsed" desc=" Variables declaration - do not modify ">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> audioFormats;
    private javax.swing.JSlider bitRateSlider;
    private javax.swing.JPanel buttonMenuPanel;
    private javax.swing.JLabel currDeviceCode;
    private javax.swing.JScrollPane deviceCodeList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> list_devices;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField maxSize;
    private javax.swing.JPanel optionMenuPanel;
    private javax.swing.JToggleButton recordAudioButton;
    private javax.swing.JToggleButton recordVideoButton;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton runCustomButton;
    private javax.swing.JButton selectButton;
    private javax.swing.JButton tcpipButton;
    private javax.swing.JToggleButton toggleScreenButton;
    private javax.swing.JToggleButton toggleStayAwake;
    private javax.swing.JToggleButton toggleVideoButton;
    private javax.swing.JTextField videoBitRate;
    private javax.swing.JComboBox<String> videoFormats;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>

    /**
     * Method to update the JList with the adb devices
     */
    private void updateDeviceList() {
        // Clear the current list
        listModel_JD.clear();

        // Fetch the list of devices
        List<String> devices = GUI_functions.adb_devices(this);

        // Add the devices to the JList model
        for (String device : devices) {
            listModel_JD.addElement(device);  // Add each device to the list model
        }
        currDeviceCode.setText("No Device Selected");
    }

    /**
     * Method to show popup menu and right click menu
     */
    private void poupMenuDeviceInfo() {
        // Create a JPopupMenu and add a menu item
        popupMenu = new JPopupMenu();
        JMenuItem infoMenuItem = new JMenuItem("Show Device Info");
        JMenuItem ipInfo = new JMenuItem("Show Device IP");
        popupMenu.add(infoMenuItem);
        popupMenu.add(ipInfo);

        // Add MouseListener to show the popup menu on right-click
        list_devices.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                String selectedDevice = list_devices.getSelectedValue();
                showPopupMenu(e);
                currDeviceCode.setText(selectedDevice);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                showPopupMenu(e);
            }

            private void showPopupMenu(MouseEvent e) {
                if (!e.isPopupTrigger()) {
                    return;
                }
                int index = list_devices.locationToIndex(e.getPoint());  // Get index of the clicked item
                if (index != -1) {
                    list_devices.setSelectedIndex(index);  // Select the item
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        // Reuse a common action handler for both menu items
        ActionListener menuActionListener = e -> {
            String selectedDevice = list_devices.getSelectedValue();
            if (selectedDevice == null) {
                return;
            }
            if (e.getSource() == infoMenuItem) {
                showDeviceInfo("Device Info for: " + selectedDevice
                        + "\nDevice Manufacturer: " + GUI_functions.adb_device_info(this, selectedDevice));
            } else if (e.getSource() == ipInfo) {
                showDeviceInfo("Device Info for: " + selectedDevice
                        + "\nDevice IP Address: " + GUI_functions.adb_get_device_ip(this, selectedDevice));
            }
        };

        // Add action listeners to both menu items
        infoMenuItem.addActionListener(menuActionListener);
        ipInfo.addActionListener(menuActionListener);
    }

    /**
     * Method to set icon for GUI .jar and the main frame
     */
    private void setIcon(String iconURL) {
        try {
            URL resource = this.getClass().getResource(iconURL);
            BufferedImage image;
            image = ImageIO.read(resource);
            this.setIconImage(image);
        } catch (IOException ex) {
            showError(ex.getMessage());
        }
    }

    @Override
    public void showDeviceInfo(String message) {
        if (message.contains("null")) {
            return;
        }
        JOptionPane.showMessageDialog(this, message, "Device Info", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void showError(String errorMessage) {
        errorMessage = (errorMessage.contains("null")) ? "Please select device" : errorMessage;
        JOptionPane.showMessageDialog(this, errorMessage, "Error", JOptionPane.WARNING_MESSAGE);
    }

    @Override
    public JDialog progressBarDialog() {
        // Create a JOptionPane with an indeterminate progress bar
        JProgressBar progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);  // Set to indeterminate as we don't know the exact progress

        // Create a JOptionPane to hold the progress bar
        JOptionPane optionPane = new JOptionPane(progressBar,
                JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION
        );

        // Create a JDialog for the JOptionPane (this will be used as a modal dialog)
        JDialog dialog = optionPane.createDialog(this, "Running scrcpy");
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setModal(false);  // False so didnt hold the background progress
        dialog.setVisible(true);  // Show the dialog with the progress bar

        return dialog;
    }

    @Override
    public void showInfo(String infoMessage) {
        JOptionPane.showMessageDialog(this, infoMessage, "Info", JOptionPane.INFORMATION_MESSAGE);
    }
}

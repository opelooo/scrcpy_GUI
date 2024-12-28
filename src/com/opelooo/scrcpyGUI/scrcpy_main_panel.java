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

        updateDeviceList();
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

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_devices = new javax.swing.JList<>();
        selectButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        runCustomButton = new javax.swing.JButton();
        tcpipButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        currDeviceCode = new javax.swing.JLabel();
        videoBitRate = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        maxSize = new javax.swing.JTextField();
        toggleVideoButton = new javax.swing.JToggleButton();
        toggleScreenButton = new javax.swing.JToggleButton();
        recordVideoButton = new javax.swing.JToggleButton();
        videoFormats = new javax.swing.JComboBox<>();
        recordAudioButton = new javax.swing.JToggleButton();
        audioFormats = new javax.swing.JComboBox<>();
        toggleStayAwake = new javax.swing.JToggleButton();

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
        jScrollPane1.setViewportView(list_devices);

        selectButton.setText("Info");
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(refreshButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(selectButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(runCustomButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tcpipButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(refreshButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(runCustomButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tcpipButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("List Devices", jPanel2);

        currDeviceCode.setBackground(new java.awt.Color(204, 204, 204));
        currDeviceCode.setText("No Device Selected");

        videoBitRate.setText("2M");

        jLabel1.setText("video bit rate:");

        jLabel2.setText("max mirroring size:");

        maxSize.setText("1024");

        toggleVideoButton.setSelected(true);
        toggleVideoButton.setText("Video On");

        toggleScreenButton.setSelected(true);
        toggleScreenButton.setText("Turn Screen On");

        recordVideoButton.setText("Record Video On");

        videoFormats.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "mp4", "mkv" }));

        recordAudioButton.setText("Record Audio On");

        audioFormats.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "m4a", "wav", "flac", "opus", "aac", "mka" }));

        toggleStayAwake.setText("Stay Awake");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(currDeviceCode)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(videoBitRate, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                .addComponent(maxSize))))
                    .addComponent(toggleVideoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(toggleScreenButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(recordAudioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(recordVideoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(videoFormats, 0, 74, Short.MAX_VALUE)
                            .addComponent(audioFormats, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(toggleStayAwake, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(539, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(currDeviceCode)
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(videoBitRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maxSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(toggleVideoButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(toggleScreenButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(toggleStayAwake)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recordVideoButton)
                    .addComponent(videoFormats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recordAudioButton)
                    .addComponent(audioFormats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(93, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Scrcpy Option", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
        // TODO add your handling code here:
        String selectedDevice = list_devices.getSelectedValue();
        showDeviceInfo("Device Info for: " + selectedDevice
                + "\nDevice Manufacturer: " + GUI_functions.adb_device_info(this, selectedDevice));
    }//GEN-LAST:event_selectButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
        updateDeviceList();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void runCustomButtonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runCustomButtonButtonActionPerformed
        // TODO add your handling code here:
        String selectedDevice = list_devices.getSelectedValue();

        GUI_functions.run_scrcpy(this,
                selectedDevice, maxSize.getText(), videoBitRate.getText(),
                toggleVideoButton.isSelected(), toggleScreenButton.isSelected(),
                toggleStayAwake.isSelected()
        );

    }//GEN-LAST:event_runCustomButtonButtonActionPerformed

    private void tcpipButtonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcpipButtonButtonActionPerformed
        // TODO add your handling code here:
        String selectedDevice = list_devices.getSelectedValue();
        GUI_functions.adb_connect_tcpip(this, selectedDevice);
    }//GEN-LAST:event_tcpipButtonButtonActionPerformed

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
    private javax.swing.JLabel currDeviceCode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JList<String> list_devices;
    private javax.swing.JTextField maxSize;
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
}

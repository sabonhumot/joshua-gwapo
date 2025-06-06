/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patient;

import careq.logIn;
import config.connectDB;
import config.reports;
import config.session;
import gfx.RoundedPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Administrator
 */
public class patientDiagnosis extends javax.swing.JFrame {

    Color mainColor = new Color(37, 171, 241);
    Color hoverColor = new Color(31, 128, 179);

    Color logoutColor = new Color(100, 188, 234);
    Color hoverlogoutColor = new Color(250, 249, 246);

    public patientDiagnosis() {
        initComponents();
        displayData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainbg = new javax.swing.JPanel();
        dboard = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        dboardBG = new RoundedPanel(15);
        scroll = new javax.swing.JScrollPane();
        diagnosisTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new RoundedPanel(5);
        dashboardPanel = new RoundedPanel(50);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        logoutPanel = new RoundedPanel(25);
        jLabel7 = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        bookAppointment = new RoundedPanel(50);
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        profilePanel = new RoundedPanel(50);
        jLabel16 = new javax.swing.JLabel();
        profile = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        diagnosisPanel = new RoundedPanel(50);
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        mainbg.setBackground(new java.awt.Color(245, 245, 245));
        mainbg.setMinimumSize(new java.awt.Dimension(1017, 620));
        mainbg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(250, 249, 246));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("Patient Dashboard");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 300, -1));

        dboard.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 70));

        dboardBG.setBackground(new java.awt.Color(250, 249, 246));
        dboardBG.setLayout(null);

        diagnosisTable.getTableHeader().setOpaque(false);
        diagnosisTable.setBackground(new java.awt.Color(250, 249, 246));
        diagnosisTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        diagnosisTable.setDragEnabled(true);
        diagnosisTable.setOpaque(false);
        diagnosisTable.setRowHeight(35);
        diagnosisTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        diagnosisTable.setShowHorizontalLines(false);
        diagnosisTable.setShowVerticalLines(false);
        scroll.setViewportView(diagnosisTable);

        dboardBG.add(scroll);
        scroll.setBounds(20, 70, 820, 500);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/print.png"))); // NOI18N
        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        dboardBG.add(jButton1);
        jButton1.setBounds(20, 20, 110, 40);

        dboard.add(dboardBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 860, 590));

        mainbg.add(dboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 920, 700));

        jPanel1.setBackground(new java.awt.Color(37, 171, 241));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dashboardPanel.setBackground(new java.awt.Color(37, 171, 241));
        dashboardPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dashboardPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboardPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dashboardPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dashboardPanelMouseExited(evt);
            }
        });
        dashboardPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/dashboard_filled.png"))); // NOI18N
        dashboardPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 40, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(250, 249, 246));
        jLabel2.setText("Dashboard");
        dashboardPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 110, 30));

        jPanel1.add(dashboardPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 190, 50));

        logoutPanel.setBackground(new java.awt.Color(100, 188, 234));
        logoutPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutPanelMouseExited(evt);
            }
        });
        logoutPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/log-out.png"))); // NOI18N
        logoutPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 30, 50));

        logout.setBackground(new java.awt.Color(73, 138, 172));
        logout.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        logout.setForeground(new java.awt.Color(73, 138, 172));
        logout.setText("Logout");
        logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutPanel.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 30));

        jPanel1.add(logoutPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 170, 70));

        bookAppointment.setBackground(new java.awt.Color(37, 171, 241));
        bookAppointment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bookAppointment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookAppointmentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bookAppointmentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bookAppointmentMouseExited(evt);
            }
        });
        bookAppointment.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/appointment-filled.png"))); // NOI18N
        bookAppointment.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 40, 50));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(250, 249, 246));
        jLabel4.setText("Appointments");
        bookAppointment.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 110, 30));

        jPanel1.add(bookAppointment, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 190, 50));

        profilePanel.setBackground(new java.awt.Color(37, 171, 241));
        profilePanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        profilePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profilePanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profilePanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                profilePanelMouseExited(evt);
            }
        });
        profilePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/profile-white.png"))); // NOI18N
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel16MouseEntered(evt);
            }
        });
        profilePanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 50));

        profile.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        profile.setForeground(new java.awt.Color(250, 249, 246));
        profile.setText("Profile");
        profilePanel.add(profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 100, 50));

        jPanel1.add(profilePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 190, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        diagnosisPanel.setBackground(new java.awt.Color(37, 171, 241));
        diagnosisPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        diagnosisPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                diagnosisPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                diagnosisPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                diagnosisPanelMouseExited(evt);
            }
        });
        diagnosisPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/diagnosis.png"))); // NOI18N
        diagnosisPanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 40, 50));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(250, 249, 246));
        jLabel19.setText("Diagnosis");
        diagnosisPanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 110, 30));

        jPanel1.add(diagnosisPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 190, 50));

        mainbg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 700));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainbg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1102, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainbg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void displayData() {
        try {

            session sess = session.getInstance();

            connectDB con = new connectDB();
            ResultSet rs = con.getData(
                    "SELECT d.diagnosis_id, d.appointment_id, CONCAT(u.u_fname, ' ', u.u_lname) AS doctor_name, "
                    + "d.diagnosis_date, d.diagnosis_time "
                    + "FROM diagnosis d "
                    + "JOIN user u ON d.doctor = u.u_id "
                    + "WHERE d.patient_id = '" + sess.getU_id() + "'"
            );

            String[] column = {"Diagnosis ID", "Appointment ID", "Doctor Name", "Diagnosis Date", "Diagnosis Time"};

            DefaultTableModel editableModel = (DefaultTableModel) DbUtils.resultSetToTableModel(rs);
            rs.close();

            DefaultTableModel model = new DefaultTableModel(editableModel.getDataVector(), new Vector<>(Arrays.asList(column))) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; // Disable editing for all cells
                }
            };

            diagnosisTable.setModel(model);

            // Header Renderer
            DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer() {
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    JLabel label = new JLabel(value.toString());
                    label.setFont(new Font("OpenSans", Font.BOLD, 12));
                    label.setPreferredSize(new Dimension(label.getWidth(), 30));
                    label.setOpaque(true);
                    label.setBackground(new Color(250, 249, 246));
                    label.setForeground(Color.BLACK);
                    label.setHorizontalAlignment(SwingConstants.LEFT);
                    label.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
                    return label;
                }
            };

            // Apply custom header renderer
            for (int i = 0; i < diagnosisTable.getColumnModel().getColumnCount(); i++) {
                diagnosisTable.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
            }

            // Cell Renderer
            DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    JLabel label = new JLabel(value != null ? value.toString() : "");
                    label.setFont(new Font("OpenSans", Font.PLAIN, 12));
                    label.setOpaque(true);
                    if (row % 2 == 0) {
                        label.setBackground(new Color(245, 245, 245));
                    } else {
                        label.setBackground(Color.WHITE);
                    }
                    label.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
                    label.setHorizontalAlignment(SwingConstants.LEFT);

                    if (isSelected) {
                        label.setBackground(new Color(220, 240, 255));
                        label.setForeground(Color.BLACK);
                    }

                    return label;
                }
            };

            // Apply renderer to all columns
            for (int i = 0; i < diagnosisTable.getColumnModel().getColumnCount(); i++) {
                diagnosisTable.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
            }

            // Status Column Renderer
            class StatusRenderer extends DefaultTableCellRenderer {

                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    JLabel label = new JLabel(value.toString());
                    label.setOpaque(true);
                    label.setHorizontalAlignment(SwingConstants.CENTER);
                    label.setFont(new Font("Open Sans", Font.PLAIN, 12));

                    switch (value.toString()) {
                        case "Accepted":
                            label.setBackground(new Color(144, 238, 144)); // Light Green
                            label.setForeground(Color.BLACK);
                            break;
                        case "Pending":
                            label.setBackground(new Color(255, 223, 128)); // Light Orange
                            label.setForeground(new Color(102, 51, 0));
                            break;
                        default:
                            label.setBackground(Color.WHITE);
                            label.setForeground(Color.BLACK);
                            break;
                    }

                    if (isSelected) {
                        label.setBackground(new Color(220, 240, 255));
                    }

                    return label;
                }
            }

            // Apply custom renderer to "Account Status" column (index 6)
//            appointmentsTable.getColumnModel().getColumn(5).setCellRenderer(new StatusRenderer());
        } catch (SQLException ex) {
            System.out.println("Errors: " + ex.getMessage());
        }
    }

    private void dashboardPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardPanelMouseClicked

    }//GEN-LAST:event_dashboardPanelMouseClicked

    private void dashboardPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardPanelMouseEntered

        dashboardPanel.setBackground(hoverColor);
    }//GEN-LAST:event_dashboardPanelMouseEntered

    private void dashboardPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardPanelMouseExited

        dashboardPanel.setBackground(mainColor);
    }//GEN-LAST:event_dashboardPanelMouseExited

    private void logoutPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutPanelMouseClicked

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to log out?", "Logout", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            session userSession = session.getInstance();

            userSession.setU_id(null);
            userSession.setFirstName(null);
            userSession.setLastName(null);
            userSession.setEmail(null);
            userSession.setUsername(null);
            userSession.setAcc_type(null);
            userSession.setAcc_status(null);

            logIn lg = new logIn();
            lg.setVisible(true);
            this.dispose();

        }
    }//GEN-LAST:event_logoutPanelMouseClicked

    private void logoutPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutPanelMouseEntered
        logoutPanel.setBackground(hoverlogoutColor);
    }//GEN-LAST:event_logoutPanelMouseEntered

    private void logoutPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutPanelMouseExited
        logoutPanel.setBackground(logoutColor);
    }//GEN-LAST:event_logoutPanelMouseExited

    private void bookAppointmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookAppointmentMouseClicked

        patientAppointments pApp = new patientAppointments();
        pApp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bookAppointmentMouseClicked

    private void bookAppointmentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookAppointmentMouseEntered

        bookAppointment.setBackground(hoverColor);
    }//GEN-LAST:event_bookAppointmentMouseEntered

    private void bookAppointmentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookAppointmentMouseExited
        bookAppointment.setBackground(mainColor);
    }//GEN-LAST:event_bookAppointmentMouseExited

    private void jLabel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseEntered

    private void profilePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilePanelMouseClicked

        patientProfileMenu ppm = new patientProfileMenu();
        ppm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_profilePanelMouseClicked

    private void profilePanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilePanelMouseEntered

        profilePanel.setBackground(hoverColor);
    }//GEN-LAST:event_profilePanelMouseEntered

    private void profilePanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilePanelMouseExited

        profilePanel.setBackground(mainColor);
    }//GEN-LAST:event_profilePanelMouseExited

    private void diagnosisPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diagnosisPanelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_diagnosisPanelMouseClicked

    private void diagnosisPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diagnosisPanelMouseEntered

        diagnosisPanel.setBackground(hoverColor);

    }//GEN-LAST:event_diagnosisPanelMouseEntered

    private void diagnosisPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diagnosisPanelMouseExited

        diagnosisPanel.setBackground(mainColor);
    }//GEN-LAST:event_diagnosisPanelMouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int selectedRow = diagnosisTable.getSelectedRow();
        session sess = session.getInstance();

        try {

            if (selectedRow == -1) {

                JOptionPane.showMessageDialog(this, "Please select a row to print.");
                return;

            }

            String patientId = sess.getU_id();

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/careq", "root", "");

            Integer patientIdInt = Integer.valueOf(patientId);
            
            
            reports.showDiagnosisReport(conn, patientId);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(patientDiagnosis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(patientDiagnosis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(patientDiagnosis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(patientDiagnosis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new patientDiagnosis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bookAppointment;
    private javax.swing.JPanel dashboardPanel;
    private javax.swing.JPanel dboard;
    private javax.swing.JPanel dboardBG;
    private javax.swing.JPanel diagnosisPanel;
    private javax.swing.JTable diagnosisTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel logout;
    private javax.swing.JPanel logoutPanel;
    private javax.swing.JPanel mainbg;
    private javax.swing.JLabel profile;
    private javax.swing.JPanel profilePanel;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}

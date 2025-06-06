/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package careq;

import config.connectDB;
import config.otp;
import config.session;
import gfx.GradientPanel;
import gfx.RoundGradientButton;
import gfx.RoundedPanel;
import gfx.RoundedTextField;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class forgotPassword2 extends javax.swing.JFrame {

    session sess = session.getInstance();

    public forgotPassword2() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new GradientPanel(new Color(250,249, 246), new Color(227, 249, 246), 1);
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new RoundGradientButton("Sign Up", new Color(131, 164, 212), new Color(182, 251, 255), 35);
        jLabel8 = new javax.swing.JLabel();
        eM = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        otpInput = new RoundedTextField(35);
        otpErrorLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2 = new RoundedPanel(20);
        jPanel2.setBackground(new java.awt.Color(250, 249, 246));
        jPanel2.setForeground(new java.awt.Color(50, 49, 204));
        jPanel2.setMinimumSize(new java.awt.Dimension(326, 344));
        jPanel2.setPreferredSize(new java.awt.Dimension(460, 480));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 26)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Forgot Password");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 230, 40));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jButton2.setForeground(new java.awt.Color(250, 249, 246));
        jButton2.setText("Next");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 150, 50));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 30, 30));

        eM.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        eM.setText("email");
        jPanel2.add(eM, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 300, 20));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 204, 204));
        jLabel14.setText("Get OTP");
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 150, 20));

        otpInput.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        otpInput.setOpaque(false);
        otpInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                otpInputFocusLost(evt);
            }
        });
        otpInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otpInputActionPerformed(evt);
            }
        });
        jPanel2.add(otpInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 230, 40));
        jPanel2.add(otpErrorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 270, 20));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Verification code has been sent via email to");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 300, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 399, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void updateEmail() {

        String maskedEmail = maskEmail(sess.getEmail());
        
        eM.setText("" + maskedEmail);
     
    }

    public String maskEmail(String email) {
        int atIndex = email.indexOf("@");
        if (atIndex <= 1) {
            return email; // too short to mask
        }

        String localPart = email.substring(0, atIndex);
        String domainPart = email.substring(atIndex);

        StringBuilder stars = new StringBuilder();
        for (int i = 0; i < localPart.length() - 2; i++) {
            stars.append("*");
        }

        return localPart.charAt(0) + stars.toString() + localPart.charAt(localPart.length() - 1) + domainPart;
    }


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        connectDB con = new connectDB();

        try {

            ResultSet rs = con.getData("SELECT otp_code, otp_duration FROM otps WHERE u_id = '" + sess.getU_id() + "' ORDER BY otp_duration DESC LIMIT 1");

            if (rs.next()) {

                String storedOTP = rs.getString("otp_code");
                Timestamp expiration = rs.getTimestamp("otp_duration");

                if (otpInput.getText().equals(storedOTP)) {

                    Instant currentTime = Instant.now();
                    Instant expirationTime = expiration.toInstant();

                    if (currentTime.isBefore(expirationTime)) {
                        forgotPassword3 fp3 = new forgotPassword3();

                        fp3.setVisible(true);
                        this.dispose();
                    } else {
                        otpInput.setForeground(Color.RED);
                        otpErrorLabel.setText("OTP has expired. Please request a new one.");
                        otpErrorLabel.setForeground(Color.RED);

                    }

                } else {
                    otpInput.setForeground(Color.RED);
                    otpErrorLabel.setText("Invalid OTP. Please try again");
                    otpErrorLabel.setForeground(Color.RED);
                    JOptionPane.showMessageDialog(this, "Submit error. Please fill all required field.", "Warning", JOptionPane.WARNING_MESSAGE);
                    System.out.println("" + storedOTP);
                }

            }

        } catch (SQLException e) {
            System.out.println("" + e);
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked

        this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void otpInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_otpInputFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_otpInputFocusLost

    private void otpInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otpInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_otpInputActionPerformed

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked

        jLabel14.setForeground(Color.GRAY);
        jLabel14.setText("OTP sent to email");
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        String generatedOTP = generateOTP(6);
        Timestamp expirationTime = new Timestamp(System.currentTimeMillis() + 5 * 60 * 1000);

        connectDB con = new connectDB();
//        session sess = session.getInstance();

        con.insertData("INSERT INTO otps (u_id, otp_code, otp_duration)"
                + "VALUES ('" + sess.getU_id() + "', '" + generatedOTP + "', '" + expirationTime + "')");

        otp.sendOTP(sess.getEmail(), generatedOTP);


    }//GEN-LAST:event_jLabel14MouseClicked

    public String generateOTP(int lenght) {

        Random random = new Random();
        String numbers = "0123456789";
        StringBuilder user_otp = new StringBuilder();

        for (int i = 0; i < lenght; i++) {
            user_otp.append(numbers.charAt(random.nextInt(numbers.length())));
        }
        return user_otp.toString();
    }

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
            java.util.logging.Logger.getLogger(forgotPassword2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(forgotPassword2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(forgotPassword2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(forgotPassword2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new forgotPassword2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel eM;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel otpErrorLabel;
    private javax.swing.JTextField otpInput;
    // End of variables declaration//GEN-END:variables
}

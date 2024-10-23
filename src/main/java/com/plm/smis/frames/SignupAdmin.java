
package com.plm.smis.frames;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.plm.smis.frames.*;
import com.plm.smis.database.Database;

public class SignupAdmin extends javax.swing.JFrame {

    Database db = new Database();
    
    public SignupAdmin() {
        initComponents();
        setIcon();
        setSize(850,550);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jP_rightP = new javax.swing.JPanel();
        jL_Title = new javax.swing.JLabel();
        jL_username = new javax.swing.JLabel();
        jTF_username = new javax.swing.JTextField();
        jL_adminID = new javax.swing.JLabel();
        jTF_adminID = new javax.swing.JTextField();
        jL_password = new javax.swing.JLabel();
        jPF_password = new javax.swing.JPasswordField();
        jL_password1 = new javax.swing.JLabel();
        jPF_password1 = new javax.swing.JPasswordField();
        jB_Signup = new javax.swing.JButton();
        jB_Login = new javax.swing.JButton();
        jB_studentPortal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Management Information System");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jP_rightP.setBackground(new java.awt.Color(221, 59, 65));
        jP_rightP.setPreferredSize(new java.awt.Dimension(400, 550));

        javax.swing.GroupLayout jP_rightPLayout = new javax.swing.GroupLayout(jP_rightP);
        jP_rightP.setLayout(jP_rightPLayout);
        jP_rightPLayout.setHorizontalGroup(
            jP_rightPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jP_rightPLayout.setVerticalGroup(
            jP_rightPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        getContentPane().add(jP_rightP, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, -1, -1));

        jL_Title.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jL_Title.setText("Sign up");
        getContentPane().add(jL_Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

        jL_username.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jL_username.setText("Username");
        getContentPane().add(jL_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 70, 20));
        getContentPane().add(jTF_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 180, -1));

        jL_adminID.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jL_adminID.setText("Admin ID");
        getContentPane().add(jL_adminID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 70, 20));
        getContentPane().add(jTF_adminID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 180, -1));

        jL_password.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jL_password.setText("Password");
        getContentPane().add(jL_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, -1, 20));
        getContentPane().add(jPF_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 180, -1));

        jL_password1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jL_password1.setText("Confirm password");
        getContentPane().add(jL_password1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 180, 20));
        getContentPane().add(jPF_password1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 180, -1));

        jB_Signup.setBackground(new java.awt.Color(221, 59, 65));
        jB_Signup.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jB_Signup.setForeground(new java.awt.Color(255, 255, 255));
        jB_Signup.setText("SIGN UP");
        jB_Signup.setBorderPainted(false);
        jB_Signup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jB_Signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_SignupActionPerformed(evt);
            }
        });
        getContentPane().add(jB_Signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 180, 40));

        jB_Login.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jB_Login.setForeground(new java.awt.Color(221, 59, 65));
        jB_Login.setText("Log in");
        jB_Login.setBorderPainted(false);
        jB_Login.setContentAreaFilled(false);
        jB_Login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jB_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_LoginActionPerformed(evt);
            }
        });
        getContentPane().add(jB_Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 80, -1));

        jB_studentPortal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jB_studentPortal.setForeground(new java.awt.Color(239, 147, 48));
        jB_studentPortal.setText("Switch to Student Portal");
        jB_studentPortal.setBorderPainted(false);
        jB_studentPortal.setContentAreaFilled(false);
        jB_studentPortal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jB_studentPortal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_studentPortalActionPerformed(evt);
            }
        });
        getContentPane().add(jB_studentPortal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, 190, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jB_SignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_SignupActionPerformed
        String admin_username;
        int admin_id;
        char[] adminpass = jPF_password.getPassword();
        char[] adminpass1 = jPF_password1.getPassword();
        
        try {
            admin_username = jTF_username.getText();
            admin_id = Integer.valueOf(jTF_adminID.getText());
            String admin_pass = new String(adminpass);
            String admin_pass1 = new String(adminpass1);
            
            if (db.verifyAdmin(admin_id)){
                if (admin_pass.equals(admin_pass1)){
                    db.registerAdmin(admin_username, admin_id, admin_pass);
                    JOptionPane.showMessageDialog(null, "Account successfully registered. Proceeding back to Login.", "NOTICE" ,JOptionPane.PLAIN_MESSAGE);
                    dispose();
                    LoginAdmin LA = new LoginAdmin();
                    LA.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Password did not match.", "NOTICE" ,JOptionPane.PLAIN_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Please fill all the fields", "NOTICE" ,JOptionPane.PLAIN_MESSAGE);
            }
            
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Please input a valid Student ID", "NOTICE" ,JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_jB_SignupActionPerformed

    private void jB_studentPortalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_studentPortalActionPerformed
        dispose();
        LoginStudent LS = new LoginStudent();
        LS.setVisible(true);
    }//GEN-LAST:event_jB_studentPortalActionPerformed

    private void jB_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_LoginActionPerformed
        dispose();
        LoginAdmin LA = new LoginAdmin();
        LA.setVisible(true);
    }//GEN-LAST:event_jB_LoginActionPerformed

    public void setIcon(){
        URL imgurl = getClass().getClassLoader().getResource("assets\\PLM_logo.png");
        ImageIcon icon = new ImageIcon(imgurl);
        setIconImage(icon.getImage()); 
    }
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
            java.util.logging.Logger.getLogger(SignupAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignupAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignupAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignupAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignupAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_Login;
    private javax.swing.JButton jB_Signup;
    private javax.swing.JButton jB_studentPortal;
    private javax.swing.JLabel jL_Title;
    private javax.swing.JLabel jL_adminID;
    private javax.swing.JLabel jL_password;
    private javax.swing.JLabel jL_password1;
    private javax.swing.JLabel jL_username;
    private javax.swing.JPasswordField jPF_password;
    private javax.swing.JPasswordField jPF_password1;
    private javax.swing.JPanel jP_rightP;
    private javax.swing.JTextField jTF_adminID;
    private javax.swing.JTextField jTF_username;
    // End of variables declaration//GEN-END:variables
}

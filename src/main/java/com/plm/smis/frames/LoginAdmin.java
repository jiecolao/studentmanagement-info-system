/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.plm.smis.frames;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.plm.smis.frames.*;
import com.plm.smis.database.*;
import com.plm.smis.model.UserAdmin;


/**
 *
 * @author Victus
 */
public class LoginAdmin extends javax.swing.JFrame {

    Database db = new Database();
    UserAdmin user;
    
    DashboardAdmin DA;
    int ctr = 0;
    public LoginAdmin() {
        initComponents();
        setIcon();
        setSize(850,550);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jP_rightP = new javax.swing.JPanel();
        jL_Title = new javax.swing.JLabel();
        jL_adminID = new javax.swing.JLabel();
        jTF_adminID = new javax.swing.JTextField();
        jL_password = new javax.swing.JLabel();
        JPF_password = new javax.swing.JPasswordField();
        jB_Login = new javax.swing.JButton();
        jB_signup = new javax.swing.JButton();
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
        jL_Title.setText("Log In");
        getContentPane().add(jL_Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, -1, -1));

        jL_adminID.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jL_adminID.setText("Admin ID");
        getContentPane().add(jL_adminID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, -1, 20));
        getContentPane().add(jTF_adminID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 180, -1));

        jL_password.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jL_password.setText("Password");
        getContentPane().add(jL_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 70, 20));

        JPF_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPF_passwordActionPerformed(evt);
            }
        });
        getContentPane().add(JPF_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 180, -1));

        jB_Login.setBackground(new java.awt.Color(221, 59, 65));
        jB_Login.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jB_Login.setForeground(new java.awt.Color(255, 255, 255));
        jB_Login.setText("LOG IN");
        jB_Login.setBorderPainted(false);
        jB_Login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jB_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_LoginActionPerformed(evt);
            }
        });
        getContentPane().add(jB_Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 180, 40));

        jB_signup.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jB_signup.setForeground(new java.awt.Color(221, 59, 65));
        jB_signup.setText("Sign up");
        jB_signup.setBorderPainted(false);
        jB_signup.setContentAreaFilled(false);
        jB_signup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jB_signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_signupActionPerformed(evt);
            }
        });
        getContentPane().add(jB_signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 80, -1));

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

    private void jB_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_LoginActionPerformed
        char[] password = JPF_password.getPassword();
        System.out.println(password);
        
        int admin_id;
        String admin_pass;
        System.out.println(ctr);
        if (ctr > 3){
            JOptionPane.showMessageDialog(null, "Please contact the IT support to assist you in logging in.", "NOTICE" ,JOptionPane.PLAIN_MESSAGE);
        } else {
            try {
                admin_id = Integer.valueOf(jTF_adminID.getText());
                admin_pass = new String(password); // jTF_studPass.getText();
                System.out.println(admin_id);
                if (db.checkAdmin(admin_id, admin_pass) == true){
                    dispose();
                    DA = new DashboardAdmin(admin_id);
                    DA.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Admin ID or Password", "NOTICE" ,JOptionPane.PLAIN_MESSAGE);
                    ctr++;
                }
            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Invalid Admin ID", "NOTICE" ,JOptionPane.PLAIN_MESSAGE);
                ctr++;
            }
        }

    }//GEN-LAST:event_jB_LoginActionPerformed

    private void jB_studentPortalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_studentPortalActionPerformed
        dispose();
        LoginStudent LS = new LoginStudent();
        LS.setVisible(true);
    }//GEN-LAST:event_jB_studentPortalActionPerformed

    private void jB_signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_signupActionPerformed
        dispose();
        SignupAdmin SA = new SignupAdmin();
        SA.setVisible(true);
    }//GEN-LAST:event_jB_signupActionPerformed

    private void JPF_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JPF_passwordActionPerformed
        
    }//GEN-LAST:event_JPF_passwordActionPerformed

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
            java.util.logging.Logger.getLogger(LoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField JPF_password;
    private javax.swing.JButton jB_Login;
    private javax.swing.JButton jB_signup;
    private javax.swing.JButton jB_studentPortal;
    private javax.swing.JLabel jL_Title;
    private javax.swing.JLabel jL_adminID;
    private javax.swing.JLabel jL_password;
    private javax.swing.JPanel jP_rightP;
    private javax.swing.JTextField jTF_adminID;
    // End of variables declaration//GEN-END:variables
}


package com.plm.smis.frames;

import java.net.URL;
import javax.swing.ImageIcon;

import com.plm.smis.frames.*;
import com.plm.smis.database.Database;
import com.plm.smis.model.UserAdmin;
import com.plm.smis.model.UserStudent;
import javax.swing.JOptionPane;

public class LoginStudent extends javax.swing.JFrame {

    Database db = new Database();
    UserStudent user;
    
    DashboardStudent DS;
    int ctr = 0;
    public LoginStudent() {
        initComponents();
        setIcon();
        setSize(850,550);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jP_rightP = new javax.swing.JPanel();
        jL_Title = new javax.swing.JLabel();
        jL_studID = new javax.swing.JLabel();
        jTF_studID = new javax.swing.JTextField();
        jL_password = new javax.swing.JLabel();
        jPF_password = new javax.swing.JPasswordField();
        jB_Login = new javax.swing.JButton();
        jB_signup = new javax.swing.JButton();
        jB_adminPortal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Management Information System");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jP_rightP.setBackground(new java.awt.Color(239, 177, 52));
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

        getContentPane().add(jP_rightP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, -1, -1));

        jL_Title.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jL_Title.setText("Log In");
        getContentPane().add(jL_Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, -1, -1));

        jL_studID.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jL_studID.setText("Student ID");
        getContentPane().add(jL_studID, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, -1, 20));
        getContentPane().add(jTF_studID, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 180, -1));

        jL_password.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jL_password.setText("Password");
        getContentPane().add(jL_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 230, 70, 20));

        jPF_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPF_passwordActionPerformed(evt);
            }
        });
        getContentPane().add(jPF_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, 180, -1));

        jB_Login.setBackground(new java.awt.Color(239, 177, 52));
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
        getContentPane().add(jB_Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 310, 180, 40));

        jB_signup.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jB_signup.setForeground(new java.awt.Color(239, 177, 52));
        jB_signup.setText("Sign up");
        jB_signup.setBorderPainted(false);
        jB_signup.setContentAreaFilled(false);
        jB_signup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jB_signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_signupActionPerformed(evt);
            }
        });
        getContentPane().add(jB_signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 360, 80, -1));

        jB_adminPortal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jB_adminPortal.setForeground(new java.awt.Color(221, 59, 65));
        jB_adminPortal.setText("Switch to Admin Portal");
        jB_adminPortal.setBorderPainted(false);
        jB_adminPortal.setContentAreaFilled(false);
        jB_adminPortal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jB_adminPortal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_adminPortalActionPerformed(evt);
            }
        });
        getContentPane().add(jB_adminPortal, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 470, 190, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jB_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_LoginActionPerformed
        char[] password = jPF_password.getPassword();
        System.out.println(password);
        
        int stud_id;
        String stud_pass;
        System.out.println(ctr);
        if (ctr > 3){
            JOptionPane.showMessageDialog(null, "Please contact the IT support to assist you in logging in.", "NOTICE" ,JOptionPane.PLAIN_MESSAGE);
        } else {
            try {
                stud_id = Integer.valueOf(jTF_studID.getText());
                stud_pass = new String(password); // jTF_studPass.getText();
                System.out.println(stud_id);
                if (db.checkStudent(stud_id, stud_pass) == true){
                    dispose();
                    DS = new DashboardStudent(stud_id);
                    DS.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Student ID or Password", "NOTICE" ,JOptionPane.PLAIN_MESSAGE);
                    ctr++;
                }
            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Invalid Student ID", "NOTICE" ,JOptionPane.PLAIN_MESSAGE);
                ctr++;
            }
        }
    }//GEN-LAST:event_jB_LoginActionPerformed

    private void jB_adminPortalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_adminPortalActionPerformed
        dispose();
        LoginAdmin LA = new LoginAdmin();
        LA.setVisible(true);
    }//GEN-LAST:event_jB_adminPortalActionPerformed

    private void jB_signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_signupActionPerformed
        dispose();
        SignupStudent SS = new SignupStudent();
        SS.setVisible(true);
    }//GEN-LAST:event_jB_signupActionPerformed

    private void jPF_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPF_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPF_passwordActionPerformed

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
            java.util.logging.Logger.getLogger(LoginStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_Login;
    private javax.swing.JButton jB_adminPortal;
    private javax.swing.JButton jB_signup;
    private javax.swing.JLabel jL_Title;
    private javax.swing.JLabel jL_password;
    private javax.swing.JLabel jL_studID;
    private javax.swing.JPasswordField jPF_password;
    private javax.swing.JPanel jP_rightP;
    private javax.swing.JTextField jTF_studID;
    // End of variables declaration//GEN-END:variables
}

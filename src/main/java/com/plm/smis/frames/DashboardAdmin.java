
package com.plm.smis.frames;

import java.net.URL;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import com.plm.smis.frames.*;
import com.plm.smis.database.Database;
import com.plm.smis.model.UserAdmin;

public class DashboardAdmin extends javax.swing.JFrame {
    
    private Timer timer;
    int userID; // = user.getID()
    
    Database db = new Database();
    
    // NOT SELECTED
    Color p_color = Color.decode("#DD3B41");
    Color txt_nonselect = Color.decode("#FFFFFF");
    
    // SELECTED
    Color btn_select = Color.decode("#E5E5E5");
    Color txt_select = Color.decode("#353535");
    
    public DashboardAdmin(int admin_id) {
        userID = admin_id;
        initComponents();
        jL_user.setText(db.getAdminUser(userID));
        jP_Profile.setVisible(false);
        jP_ClassAttendance.setVisible(false);
        jP_Grade.setVisible(false);
        jP_StudentInfo.setVisible(false);
        setIcon();
        startClock();
        setDate();
        setSize(1200, 700);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jP_leftBar = new javax.swing.JPanel();
        jB_Profile = new javax.swing.JButton();
        jB_ClassAttd = new javax.swing.JButton();
        jB_Grade = new javax.swing.JButton();
        jB_StudInfo = new javax.swing.JButton();
        jL_welcome = new javax.swing.JLabel();
        jL_user = new javax.swing.JLabel();
        jP_topBar = new javax.swing.JPanel();
        jL_Date = new javax.swing.JLabel();
        jL_Time = new javax.swing.JLabel();
        jB_Logout = new javax.swing.JButton();
        jP_Grade = new javax.swing.JPanel();
        jL_subjcode_G = new javax.swing.JLabel();
        jCB_subjcode_G = new javax.swing.JComboBox<>();
        jL_yrlvl_G = new javax.swing.JLabel();
        jCB_yrlvl_G = new javax.swing.JComboBox<>();
        jL_blk_G = new javax.swing.JLabel();
        jCB_blk_G = new javax.swing.JComboBox<>();
        jL_ID_G = new javax.swing.JLabel();
        jTF_ID_G = new javax.swing.JTextField();
        jL_grade_G = new javax.swing.JLabel();
        jCB_grade_G = new javax.swing.JComboBox<>();
        jB_update_G = new javax.swing.JButton();
        jB_encode_G = new javax.swing.JButton();
        jB_search_G = new javax.swing.JButton();
        jB_delete_G = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jT_grades_G = new javax.swing.JTable();
        jP_ClassAttendance = new javax.swing.JPanel();
        jL_subjcode_CA = new javax.swing.JLabel();
        jCB_subjcode_CA = new javax.swing.JComboBox<>();
        jL_blk_CA = new javax.swing.JLabel();
        jCB_blk_CA = new javax.swing.JComboBox<>();
        jL_ID_CA = new javax.swing.JLabel();
        jTF_ID_CA = new javax.swing.JTextField();
        jL_status_CA = new javax.swing.JLabel();
        jCB_status_CA = new javax.swing.JComboBox<>();
        jB_search_CA = new javax.swing.JButton();
        jB_add_CA = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jT_attendance_CA = new javax.swing.JTable();
        jL_yrlvl_CA = new javax.swing.JLabel();
        jCB_yrlvl_CA = new javax.swing.JComboBox<>();
        jP_StudentInfo = new javax.swing.JPanel();
        jB_EnterID_SI = new javax.swing.JButton();
        jL_EnterID_SI = new javax.swing.JLabel();
        jTF_EnterID_SI = new javax.swing.JTextField();
        jL_studID_SI = new javax.swing.JLabel();
        jTF_studID_SI = new javax.swing.JTextField();
        jL_username_SI = new javax.swing.JLabel();
        jTF_username_SI = new javax.swing.JTextField();
        jL_fullN_SI = new javax.swing.JLabel();
        jTF_fullN_SI = new javax.swing.JTextField();
        jL_email_SI = new javax.swing.JLabel();
        jTF_email_SI = new javax.swing.JTextField();
        jL_contact_SI = new javax.swing.JLabel();
        jTF_contact_SI = new javax.swing.JTextField();
        jL_birth_SI = new javax.swing.JLabel();
        jTF_birth_SI = new javax.swing.JTextField();
        jL_college_SI = new javax.swing.JLabel();
        jTF_college_SI = new javax.swing.JTextField();
        jL_crs_SI = new javax.swing.JLabel();
        jTF_crs_SI = new javax.swing.JTextField();
        jL_type_SI = new javax.swing.JLabel();
        jTF_type_SI = new javax.swing.JTextField();
        jL_status_SI = new javax.swing.JLabel();
        jTF_status_SI = new javax.swing.JTextField();
        jL_yrlvl_SI = new javax.swing.JLabel();
        jTF_yrlvl_SI = new javax.swing.JTextField();
        jL_blk_SI = new javax.swing.JLabel();
        jTF_blk_SI = new javax.swing.JTextField();
        jP_Profile = new javax.swing.JPanel();
        jL_adminID_P = new javax.swing.JLabel();
        jTF_adminID_P = new javax.swing.JTextField();
        jL_username_P = new javax.swing.JLabel();
        jTF_username_P = new javax.swing.JTextField();
        jL_fullN_P = new javax.swing.JLabel();
        jTF_fullN_P = new javax.swing.JTextField();
        jL_email_P = new javax.swing.JLabel();
        jTF_email_P = new javax.swing.JTextField();
        jL_contact_P = new javax.swing.JLabel();
        jTF_contact_P = new javax.swing.JTextField();
        jL_birth_P = new javax.swing.JLabel();
        jTF_birth_P = new javax.swing.JTextField();
        jL_college_P = new javax.swing.JLabel();
        jTF_college_P = new javax.swing.JTextField();
        jL_dept_P = new javax.swing.JLabel();
        jTF_dept_P = new javax.swing.JTextField();
        jL_bldg_P = new javax.swing.JLabel();
        jTF_bldg_P = new javax.swing.JTextField();
        jB_enter_P = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Management Information System");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jP_leftBar.setBackground(new java.awt.Color(221, 59, 65));
        jP_leftBar.setPreferredSize(new java.awt.Dimension(200, 700));
        jP_leftBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jB_Profile.setBackground(new java.awt.Color(221, 59, 65));
        jB_Profile.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jB_Profile.setForeground(new java.awt.Color(255, 255, 255));
        jB_Profile.setText("Profile");
        jB_Profile.setBorder(null);
        buttonGroup1.add(jB_Profile);
        jB_Profile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jB_Profile.setFocusPainted(false);
        jB_Profile.setPreferredSize(new java.awt.Dimension(200, 50));
        jB_Profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_ProfileActionPerformed(evt);
            }
        });
        jP_leftBar.add(jB_Profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, -1, -1));

        jB_ClassAttd.setBackground(new java.awt.Color(221, 59, 65));
        jB_ClassAttd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jB_ClassAttd.setForeground(new java.awt.Color(255, 255, 255));
        jB_ClassAttd.setText("Class Attendance");
        jB_ClassAttd.setBorder(null);
        jB_ClassAttd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jB_ClassAttd.setFocusPainted(false);
        jB_ClassAttd.setPreferredSize(new java.awt.Dimension(200, 50));
        jB_ClassAttd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_ClassAttdActionPerformed(evt);
            }
        });
        jP_leftBar.add(jB_ClassAttd, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, -1, -1));

        jB_Grade.setBackground(new java.awt.Color(221, 59, 65));
        jB_Grade.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jB_Grade.setForeground(new java.awt.Color(255, 255, 255));
        jB_Grade.setText("Grade");
        jB_Grade.setBorder(null);
        jB_Grade.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jB_Grade.setFocusPainted(false);
        jB_Grade.setPreferredSize(new java.awt.Dimension(200, 50));
        jB_Grade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_GradeActionPerformed(evt);
            }
        });
        jP_leftBar.add(jB_Grade, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, -1, -1));

        jB_StudInfo.setBackground(new java.awt.Color(221, 59, 65));
        jB_StudInfo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jB_StudInfo.setForeground(new java.awt.Color(255, 255, 255));
        jB_StudInfo.setText("Student Info");
        jB_StudInfo.setBorder(null);
        jB_StudInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jB_StudInfo.setFocusPainted(false);
        jB_StudInfo.setPreferredSize(new java.awt.Dimension(200, 50));
        jB_StudInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_StudInfoActionPerformed(evt);
            }
        });
        jP_leftBar.add(jB_StudInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, -1, -1));

        jL_welcome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jL_welcome.setForeground(new java.awt.Color(255, 255, 255));
        jL_welcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jL_welcome.setText("Welcome,");
        jP_leftBar.add(jL_welcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 80, -1));

        jL_user.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jL_user.setForeground(new java.awt.Color(255, 255, 255));
        jL_user.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jL_user.setText("User");
        jP_leftBar.add(jL_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 80, -1));

        getContentPane().add(jP_leftBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jP_topBar.setBackground(new java.awt.Color(222, 225, 229));
        jP_topBar.setPreferredSize(new java.awt.Dimension(1000, 50));
        jP_topBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL_Date.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jL_Date.setForeground(new java.awt.Color(51, 51, 51));
        jL_Date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jL_Date.setText("January 1, 2024 ");
        jP_topBar.add(jL_Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, -1));

        jL_Time.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jL_Time.setForeground(new java.awt.Color(51, 51, 51));
        jL_Time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jL_Time.setText("12:00:00");
        jP_topBar.add(jL_Time, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 120, -1));

        jB_Logout.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jB_Logout.setForeground(new java.awt.Color(255, 51, 51));
        jB_Logout.setText("LOG OUT");
        jB_Logout.setBorderPainted(false);
        jB_Logout.setContentAreaFilled(false);
        jB_Logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jB_Logout.setFocusPainted(false);
        jB_Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_LogoutActionPerformed(evt);
            }
        });
        jP_topBar.add(jB_Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 10, -1, 30));

        getContentPane().add(jP_topBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, -1, -1));

        jP_Grade.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL_subjcode_G.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jL_subjcode_G.setText("Subject Code:");
        jP_Grade.add(jL_subjcode_G, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, -1, 30));

        jCB_subjcode_G.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jP_Grade.add(jCB_subjcode_G, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 200, -1));

        jL_yrlvl_G.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jL_yrlvl_G.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jL_yrlvl_G.setText("Year:");
        jP_Grade.add(jL_yrlvl_G, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 50, 30));

        jCB_yrlvl_G.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCB_yrlvl_G.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2" }));
        jP_Grade.add(jCB_yrlvl_G, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 80, 30));

        jL_blk_G.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jL_blk_G.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jL_blk_G.setText("Block:");
        jP_Grade.add(jL_blk_G, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 40, 50, 30));

        jCB_blk_G.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCB_blk_G.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2" }));
        jP_Grade.add(jCB_blk_G, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 40, 80, 30));

        jL_ID_G.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jL_ID_G.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jL_ID_G.setText("Student ID:");
        jP_Grade.add(jL_ID_G, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 110, 30));

        jTF_ID_G.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jP_Grade.add(jTF_ID_G, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 200, -1));

        jL_grade_G.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jL_grade_G.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jL_grade_G.setText("Grade:");
        jP_Grade.add(jL_grade_G, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 110, 30));

        jCB_grade_G.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCB_grade_G.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1.00", "1.25", "1.50", "1.75", "2.00", "2.25", "2.50", "2.75", "3.00", "5.00" }));
        jCB_grade_G.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_grade_GActionPerformed(evt);
            }
        });
        jP_Grade.add(jCB_grade_G, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, 200, 30));

        jB_update_G.setBackground(new java.awt.Color(221, 59, 65));
        jB_update_G.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jB_update_G.setForeground(new java.awt.Color(255, 255, 255));
        jB_update_G.setText("UPDATE");
        jB_update_G.setBorderPainted(false);
        jB_update_G.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jB_update_G.setFocusPainted(false);
        jB_update_G.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_update_GActionPerformed(evt);
            }
        });
        jP_Grade.add(jB_update_G, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 180, 120, -1));

        jB_encode_G.setBackground(new java.awt.Color(221, 59, 65));
        jB_encode_G.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jB_encode_G.setForeground(new java.awt.Color(255, 255, 255));
        jB_encode_G.setText("ENCODE");
        jB_encode_G.setBorderPainted(false);
        jB_encode_G.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jB_encode_G.setFocusPainted(false);
        jB_encode_G.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_encode_GActionPerformed(evt);
            }
        });
        jP_Grade.add(jB_encode_G, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 180, 120, -1));

        jB_search_G.setBackground(new java.awt.Color(221, 59, 65));
        jB_search_G.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jB_search_G.setForeground(new java.awt.Color(255, 255, 255));
        jB_search_G.setText("SEARCH");
        jB_search_G.setBorderPainted(false);
        jB_search_G.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jB_search_G.setFocusPainted(false);
        jB_search_G.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_search_GActionPerformed(evt);
            }
        });
        jP_Grade.add(jB_search_G, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 180, 120, -1));

        jB_delete_G.setBackground(new java.awt.Color(221, 59, 65));
        jB_delete_G.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jB_delete_G.setForeground(new java.awt.Color(255, 255, 255));
        jB_delete_G.setText("DELETE");
        jB_delete_G.setBorderPainted(false);
        jB_delete_G.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jB_delete_G.setFocusPainted(false);
        jB_delete_G.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_delete_GActionPerformed(evt);
            }
        });
        jP_Grade.add(jB_delete_G, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 120, -1));

        jT_grades_G.setBackground(new java.awt.Color(204, 204, 204));
        jT_grades_G.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Subject Code", "Year", "Block", "Student ID", "Grade"
            }
        ));
        jT_grades_G.setEnabled(false);
        jT_grades_G.setShowGrid(false);
        jScrollPane2.setViewportView(jT_grades_G);

        jP_Grade.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 900, 330));

        getContentPane().add(jP_Grade, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 1000, 650));

        jP_ClassAttendance.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL_subjcode_CA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jL_subjcode_CA.setText("Subject Code:");
        jP_ClassAttendance.add(jL_subjcode_CA, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, 30));

        jCB_subjcode_CA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCB_subjcode_CA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_subjcode_CAActionPerformed(evt);
            }
        });
        jP_ClassAttendance.add(jCB_subjcode_CA, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 180, -1));

        jL_blk_CA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jL_blk_CA.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jL_blk_CA.setText("Block:");
        jP_ClassAttendance.add(jL_blk_CA, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, 60, 30));

        jCB_blk_CA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCB_blk_CA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2" }));
        jCB_blk_CA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_blk_CAActionPerformed(evt);
            }
        });
        jP_ClassAttendance.add(jCB_blk_CA, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 70, 100, 30));

        jL_ID_CA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jL_ID_CA.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jL_ID_CA.setText("Student ID:");
        jP_ClassAttendance.add(jL_ID_CA, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 110, 30));

        jTF_ID_CA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTF_ID_CA.setEnabled(false);
        jP_ClassAttendance.add(jTF_ID_CA, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 200, -1));

        jL_status_CA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jL_status_CA.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jL_status_CA.setText("STATUS:");
        jP_ClassAttendance.add(jL_status_CA, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 110, 30));

        jCB_status_CA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCB_status_CA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PRESENT", "ABSENT", "EXCUSED" }));
        jCB_status_CA.setEnabled(false);
        jP_ClassAttendance.add(jCB_status_CA, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, 200, 30));

        jB_search_CA.setBackground(new java.awt.Color(221, 59, 65));
        jB_search_CA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jB_search_CA.setForeground(new java.awt.Color(255, 255, 255));
        jB_search_CA.setText("SEARCH");
        jB_search_CA.setBorderPainted(false);
        jB_search_CA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jB_search_CA.setFocusPainted(false);
        jB_search_CA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_search_CAActionPerformed(evt);
            }
        });
        jP_ClassAttendance.add(jB_search_CA, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 70, 100, 30));

        jB_add_CA.setBackground(new java.awt.Color(221, 59, 65));
        jB_add_CA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jB_add_CA.setForeground(new java.awt.Color(255, 255, 255));
        jB_add_CA.setText("ADD");
        jB_add_CA.setBorderPainted(false);
        jB_add_CA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jB_add_CA.setFocusPainted(false);
        jB_add_CA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_add_CAActionPerformed(evt);
            }
        });
        jP_ClassAttendance.add(jB_add_CA, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 140, 100, -1));

        jT_attendance_CA.setBackground(new java.awt.Color(204, 204, 204));
        jT_attendance_CA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Subject Code", "Year", "Block", "Student ID", "Time", "Status"
            }
        ));
        jT_attendance_CA.setEnabled(false);
        jT_attendance_CA.setShowGrid(false);
        jScrollPane1.setViewportView(jT_attendance_CA);

        jP_ClassAttendance.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 900, 330));

        jL_yrlvl_CA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jL_yrlvl_CA.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jL_yrlvl_CA.setText("Year:");
        jP_ClassAttendance.add(jL_yrlvl_CA, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 60, 30));

        jCB_yrlvl_CA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCB_yrlvl_CA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2" }));
        jCB_yrlvl_CA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_yrlvl_CAActionPerformed(evt);
            }
        });
        jP_ClassAttendance.add(jCB_yrlvl_CA, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 100, 30));

        getContentPane().add(jP_ClassAttendance, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 1000, 650));

        jP_StudentInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jB_EnterID_SI.setBackground(new java.awt.Color(221, 59, 65));
        jB_EnterID_SI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jB_EnterID_SI.setForeground(new java.awt.Color(255, 255, 255));
        jB_EnterID_SI.setText("Search");
        jB_EnterID_SI.setBorderPainted(false);
        jB_EnterID_SI.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jB_EnterID_SI.setFocusPainted(false);
        jB_EnterID_SI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_EnterID_SIActionPerformed(evt);
            }
        });
        jP_StudentInfo.add(jB_EnterID_SI, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 50, 110, -1));

        jL_EnterID_SI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jL_EnterID_SI.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jL_EnterID_SI.setText("Enter Student ID:");
        jP_StudentInfo.add(jL_EnterID_SI, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, -1, 30));

        jTF_EnterID_SI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTF_EnterID_SI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_EnterID_SIActionPerformed(evt);
            }
        });
        jP_StudentInfo.add(jTF_EnterID_SI, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 220, 30));

        jL_studID_SI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jL_studID_SI.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jL_studID_SI.setText("Student ID:");
        jP_StudentInfo.add(jL_studID_SI, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, -1, 30));

        jTF_studID_SI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTF_studID_SI.setEnabled(false);
        jTF_studID_SI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_studID_SIActionPerformed(evt);
            }
        });
        jP_StudentInfo.add(jTF_studID_SI, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 220, 30));

        jL_username_SI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jL_username_SI.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jL_username_SI.setText("Username:");
        jP_StudentInfo.add(jL_username_SI, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, -1, 30));

        jTF_username_SI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTF_username_SI.setEnabled(false);
        jTF_username_SI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_username_SIActionPerformed(evt);
            }
        });
        jP_StudentInfo.add(jTF_username_SI, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 220, -1));

        jL_fullN_SI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jL_fullN_SI.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jL_fullN_SI.setText("Full name:");
        jP_StudentInfo.add(jL_fullN_SI, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, -1, 30));

        jTF_fullN_SI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTF_fullN_SI.setEnabled(false);
        jTF_fullN_SI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_fullN_SIActionPerformed(evt);
            }
        });
        jP_StudentInfo.add(jTF_fullN_SI, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 220, -1));

        jL_email_SI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jL_email_SI.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jL_email_SI.setText("PLM Email:");
        jP_StudentInfo.add(jL_email_SI, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, 90, 30));

        jTF_email_SI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTF_email_SI.setEnabled(false);
        jTF_email_SI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_email_SIActionPerformed(evt);
            }
        });
        jP_StudentInfo.add(jTF_email_SI, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, 220, 30));

        jL_contact_SI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jL_contact_SI.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jL_contact_SI.setText("Contact:");
        jP_StudentInfo.add(jL_contact_SI, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, 90, 30));

        jTF_contact_SI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTF_contact_SI.setEnabled(false);
        jTF_contact_SI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_contact_SIActionPerformed(evt);
            }
        });
        jP_StudentInfo.add(jTF_contact_SI, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 440, 220, 30));

        jL_birth_SI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jL_birth_SI.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jL_birth_SI.setText("Birth:");
        jP_StudentInfo.add(jL_birth_SI, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 510, 90, 30));

        jTF_birth_SI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTF_birth_SI.setEnabled(false);
        jTF_birth_SI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_birth_SIActionPerformed(evt);
            }
        });
        jP_StudentInfo.add(jTF_birth_SI, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 510, 220, 30));

        jL_college_SI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jL_college_SI.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jL_college_SI.setText("College:");
        jP_StudentInfo.add(jL_college_SI, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 90, 30));

        jTF_college_SI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTF_college_SI.setEnabled(false);
        jTF_college_SI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_college_SIActionPerformed(evt);
            }
        });
        jP_StudentInfo.add(jTF_college_SI, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 160, 220, 30));

        jL_crs_SI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jL_crs_SI.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jL_crs_SI.setText("Course:");
        jP_StudentInfo.add(jL_crs_SI, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, 90, 30));

        jTF_crs_SI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTF_crs_SI.setEnabled(false);
        jTF_crs_SI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_crs_SIActionPerformed(evt);
            }
        });
        jP_StudentInfo.add(jTF_crs_SI, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 230, 220, 30));

        jL_type_SI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jL_type_SI.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jL_type_SI.setText("Student type:");
        jP_StudentInfo.add(jL_type_SI, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 300, 110, 30));

        jTF_type_SI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTF_type_SI.setEnabled(false);
        jTF_type_SI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_type_SIActionPerformed(evt);
            }
        });
        jP_StudentInfo.add(jTF_type_SI, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 300, 220, 30));

        jL_status_SI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jL_status_SI.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jL_status_SI.setText("Status:");
        jP_StudentInfo.add(jL_status_SI, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 370, 110, 30));

        jTF_status_SI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTF_status_SI.setEnabled(false);
        jTF_status_SI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_status_SIActionPerformed(evt);
            }
        });
        jP_StudentInfo.add(jTF_status_SI, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 370, 220, 30));

        jL_yrlvl_SI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jL_yrlvl_SI.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jL_yrlvl_SI.setText("Year level:");
        jP_StudentInfo.add(jL_yrlvl_SI, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 440, 110, 30));

        jTF_yrlvl_SI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTF_yrlvl_SI.setEnabled(false);
        jTF_yrlvl_SI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_yrlvl_SIActionPerformed(evt);
            }
        });
        jP_StudentInfo.add(jTF_yrlvl_SI, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 440, 220, 30));

        jL_blk_SI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jL_blk_SI.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jL_blk_SI.setText("Block:");
        jP_StudentInfo.add(jL_blk_SI, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 510, 110, 30));

        jTF_blk_SI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTF_blk_SI.setEnabled(false);
        jTF_blk_SI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_blk_SIActionPerformed(evt);
            }
        });
        jP_StudentInfo.add(jTF_blk_SI, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 510, 220, 30));

        getContentPane().add(jP_StudentInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 1000, 650));

        jP_Profile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL_adminID_P.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jL_adminID_P.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jL_adminID_P.setText("Admin ID: ");
        jP_Profile.add(jL_adminID_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, -1, 30));

        jTF_adminID_P.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTF_adminID_P.setText("Sample");
        jTF_adminID_P.setEnabled(false);
        jTF_adminID_P.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_adminID_PActionPerformed(evt);
            }
        });
        jP_Profile.add(jTF_adminID_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 220, 30));

        jL_username_P.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jL_username_P.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jL_username_P.setText("Username:");
        jP_Profile.add(jL_username_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, -1, 30));

        jTF_username_P.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTF_username_P.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_username_PActionPerformed(evt);
            }
        });
        jP_Profile.add(jTF_username_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 220, -1));

        jL_fullN_P.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jL_fullN_P.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jL_fullN_P.setText("Full name:");
        jP_Profile.add(jL_fullN_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, -1, 30));

        jTF_fullN_P.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTF_fullN_P.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_fullN_PActionPerformed(evt);
            }
        });
        jP_Profile.add(jTF_fullN_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 220, -1));

        jL_email_P.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jL_email_P.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jL_email_P.setText("Email:");
        jP_Profile.add(jL_email_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 90, 30));

        jTF_email_P.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTF_email_P.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_email_PActionPerformed(evt);
            }
        });
        jP_Profile.add(jTF_email_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 220, 30));

        jL_contact_P.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jL_contact_P.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jL_contact_P.setText("Contact:");
        jP_Profile.add(jL_contact_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 90, 30));

        jTF_contact_P.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTF_contact_P.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_contact_PActionPerformed(evt);
            }
        });
        jP_Profile.add(jTF_contact_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 220, 30));

        jL_birth_P.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jL_birth_P.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jL_birth_P.setText("Birthdate:");
        jP_Profile.add(jL_birth_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 90, 30));

        jTF_birth_P.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTF_birth_P.setText("MM-DD-YYYY");
        jTF_birth_P.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_birth_PActionPerformed(evt);
            }
        });
        jP_Profile.add(jTF_birth_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, 220, 30));

        jL_college_P.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jL_college_P.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jL_college_P.setText("College:");
        jP_Profile.add(jL_college_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, 90, 30));

        jTF_college_P.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTF_college_P.setEnabled(false);
        jTF_college_P.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_college_PActionPerformed(evt);
            }
        });
        jP_Profile.add(jTF_college_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 150, 220, 30));

        jL_dept_P.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jL_dept_P.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jL_dept_P.setText("Department:");
        jP_Profile.add(jL_dept_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 110, 30));

        jTF_dept_P.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTF_dept_P.setEnabled(false);
        jTF_dept_P.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_dept_PActionPerformed(evt);
            }
        });
        jP_Profile.add(jTF_dept_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 220, 220, 30));

        jL_bldg_P.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jL_bldg_P.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jL_bldg_P.setText("Building:");
        jP_Profile.add(jL_bldg_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 290, 110, 30));

        jTF_bldg_P.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTF_bldg_P.setEnabled(false);
        jTF_bldg_P.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_bldg_PActionPerformed(evt);
            }
        });
        jP_Profile.add(jTF_bldg_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 290, 220, 30));

        jB_enter_P.setBackground(new java.awt.Color(221, 59, 65));
        jB_enter_P.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jB_enter_P.setForeground(new java.awt.Color(255, 255, 255));
        jB_enter_P.setText("Update");
        jB_enter_P.setBorderPainted(false);
        jB_enter_P.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jB_enter_P.setFocusPainted(false);
        jB_enter_P.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_enter_PActionPerformed(evt);
            }
        });
        jP_Profile.add(jB_enter_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 530, 110, -1));

        getContentPane().add(jP_Profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 1000, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jB_ProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_ProfileActionPerformed
        //  ===== customization =====
        jB_Profile.setBackground(btn_select);
        jB_Profile.setForeground(txt_select);
        jB_ClassAttd.setBackground(p_color);
        jB_ClassAttd.setForeground(txt_nonselect);
        jB_Grade.setBackground(p_color);
        jB_Grade.setForeground(txt_nonselect);
        jB_StudInfo.setBackground(p_color);
        jB_StudInfo.setForeground(txt_nonselect);
        
        jP_Profile.setVisible(true);
        jP_ClassAttendance.setVisible(false);
        jP_Grade.setVisible(false);
        jP_StudentInfo.setVisible(false);
        
        // ===== Display profile values =====
        jTF_adminID_P.setText(String.valueOf(userID));
        jTF_username_P.setText(db.getProfileData(userID, "admin_username"));
        jTF_fullN_P.setText(db.getProfileData(userID, "admin_name"));
        jTF_email_P.setText(db.getProfileData(userID, "admin_email"));
        jTF_contact_P.setText(db.getProfileData(userID, "admin_contact"));
        jTF_birth_P.setText(db.getProfileData(userID, "admin_birth"));
        jTF_college_P.setText(db.getProfileData(userID, "admin_college"));
        jTF_dept_P.setText(db.getProfileData(userID, "admin_dept"));
        jTF_bldg_P.setText(db.getProfileData(userID, "admin_bldg"));
    }//GEN-LAST:event_jB_ProfileActionPerformed

    private void jB_ClassAttdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_ClassAttdActionPerformed
        if (verifyPass()){
            //  ===== customization =====
            jB_Profile.setBackground(p_color);
            jB_Profile.setForeground(txt_nonselect);
            jB_ClassAttd.setBackground(btn_select);
            jB_ClassAttd.setForeground(txt_select);
            jB_Grade.setBackground(p_color);
            jB_Grade.setForeground(txt_nonselect);
            jB_StudInfo.setBackground(p_color);
            jB_StudInfo.setForeground(txt_nonselect);

            jP_Profile.setVisible(false);
            jP_ClassAttendance.setVisible(true);
            jP_Grade.setVisible(false);
            jP_StudentInfo.setVisible(false);

            // Set values
            jCB_subjcode_CA.removeAllItems();
            db.getSubjList(userID, jCB_subjcode_CA);            
        } else {
            JOptionPane.showMessageDialog(null, "Verification UNSUCCESSFUL. Please try again.", "WARNING" ,JOptionPane.PLAIN_MESSAGE);
        }


        // fetching yrlvl and blk from database (unsuccessful)
//        jCB_yrlvl_CA.removeAllItems();
//        jCB_blk_CA.removeAllItems();
//        String subjC = String.valueOf(jCB_subjcode_CA.getSelectedItem());
//        db.getSection(subjC, jCB_yrlvl_CA, jCB_blk_CA);
    }//GEN-LAST:event_jB_ClassAttdActionPerformed

    private void jB_GradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_GradeActionPerformed
        if (verifyPass()){
            // ===== customization =====
            jB_Profile.setBackground(p_color);
            jB_Profile.setForeground(txt_nonselect);
            jB_ClassAttd.setBackground(p_color);
            jB_ClassAttd.setForeground(txt_nonselect);
            jB_Grade.setBackground(btn_select);
            jB_Grade.setForeground(txt_select);
            jB_StudInfo.setBackground(p_color);
            jB_StudInfo.setForeground(txt_nonselect);

            jP_Profile.setVisible(false);
            jP_ClassAttendance.setVisible(false);
            jP_Grade.setVisible(true);
            jP_StudentInfo.setVisible(false);

            jCB_subjcode_G.removeAllItems();
            db.getSubjList(userID, jCB_subjcode_G);
        } else {
            JOptionPane.showMessageDialog(null, "Verification UNSUCCESSFUL. Please try again.", "WARNING" ,JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_jB_GradeActionPerformed

    private void jB_StudInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_StudInfoActionPerformed
        jB_Profile.setBackground(p_color);
        jB_Profile.setForeground(txt_nonselect);
        jB_ClassAttd.setBackground(p_color);
        jB_ClassAttd.setForeground(txt_nonselect);
        jB_Grade.setBackground(p_color);
        jB_Grade.setForeground(txt_nonselect);
        jB_StudInfo.setBackground(btn_select);
        jB_StudInfo.setForeground(txt_select);
        
        jP_Profile.setVisible(false);
        jP_ClassAttendance.setVisible(false);
        jP_Grade.setVisible(false);
        jP_StudentInfo.setVisible(true);
    }//GEN-LAST:event_jB_StudInfoActionPerformed

    private void jB_LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_LogoutActionPerformed
        int choice = JOptionPane.showConfirmDialog(null, "Do you want to logout?", 
                                                   "Confirmation", JOptionPane.YES_NO_OPTION); 
        
        // Check the user's choice and display a corresponding message 
        if (choice == JOptionPane.YES_OPTION) { 
            dispose();
            LoginAdmin LA = new LoginAdmin();
            LA.setVisible(true);
        }
    }//GEN-LAST:event_jB_LogoutActionPerformed

    private void jTF_adminID_PActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_adminID_PActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_adminID_PActionPerformed

    private void jTF_username_PActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_username_PActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_username_PActionPerformed

    private void jTF_fullN_PActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_fullN_PActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_fullN_PActionPerformed

    private void jTF_email_PActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_email_PActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_email_PActionPerformed

    private void jTF_contact_PActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_contact_PActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_contact_PActionPerformed

    private void jTF_birth_PActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_birth_PActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_birth_PActionPerformed

    private void jTF_college_PActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_college_PActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_college_PActionPerformed

    private void jTF_dept_PActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_dept_PActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_dept_PActionPerformed

    private void jTF_bldg_PActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_bldg_PActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_bldg_PActionPerformed

    private void jB_enter_PActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_enter_PActionPerformed
        if (isValidDateFormat(jTF_birth_P.getText())){
            db.updateProfileData(userID, jTF_username_P.getText(), jTF_fullN_P.getText(), jTF_email_P.getText(), jTF_contact_P.getText(), jTF_birth_P.getText());
            JOptionPane.showMessageDialog(null, "Information SUCCESSFULLY updated.", "NOTICE" ,JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Update UNSUCCESSFUL. Please follow MM-DD-YYYY for birthdate.", "WARNING" ,JOptionPane.PLAIN_MESSAGE);
        }

    }//GEN-LAST:event_jB_enter_PActionPerformed

    private void jTF_studID_SIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_studID_SIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_studID_SIActionPerformed

    private void jTF_username_SIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_username_SIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_username_SIActionPerformed

    private void jTF_fullN_SIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_fullN_SIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_fullN_SIActionPerformed

    private void jTF_email_SIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_email_SIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_email_SIActionPerformed

    private void jTF_contact_SIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_contact_SIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_contact_SIActionPerformed

    private void jTF_birth_SIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_birth_SIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_birth_SIActionPerformed

    private void jTF_college_SIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_college_SIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_college_SIActionPerformed

    private void jTF_crs_SIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_crs_SIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_crs_SIActionPerformed

    private void jTF_type_SIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_type_SIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_type_SIActionPerformed

    private void jTF_status_SIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_status_SIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_status_SIActionPerformed

    private void jTF_yrlvl_SIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_yrlvl_SIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_yrlvl_SIActionPerformed

    private void jTF_blk_SIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_blk_SIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_blk_SIActionPerformed

    private void jB_EnterID_SIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_EnterID_SIActionPerformed
        try {
            int studid = Integer.valueOf(jTF_EnterID_SI.getText());

            if (db.showStudInfo(studid, 
                    jTF_studID_SI, 
                    jTF_username_SI, 
                    jTF_fullN_SI, 
                    jTF_email_SI, 
                    jTF_contact_SI, 
                    jTF_birth_SI, 
                    jTF_college_SI, 
                    jTF_crs_SI, 
                    jTF_type_SI, 
                    jTF_status_SI, 
                    jTF_yrlvl_SI,
                    jTF_blk_SI)) {
                System.out.println("FOUND");
            } else {
                JOptionPane.showMessageDialog(null, "No record found for " + studid, "NOTICE" ,JOptionPane.PLAIN_MESSAGE);
            }
        } catch (java.lang.NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Enter a valid Student ID.", "NOTICE" ,JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_jB_EnterID_SIActionPerformed

    private void jTF_EnterID_SIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_EnterID_SIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_EnterID_SIActionPerformed

    private void jB_add_CAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_add_CAActionPerformed
        try {
            String subjC = String.valueOf(jCB_subjcode_CA.getSelectedItem());
            int yrlvl = Integer.parseInt(String.valueOf(jCB_yrlvl_CA.getSelectedItem()));
            int blk = Integer.valueOf(String.valueOf(jCB_blk_CA.getSelectedItem()));
            int studid = Integer.valueOf(jTF_ID_CA.getText());
            String status = String.valueOf(jCB_status_CA.getSelectedItem());
            db.insertAttdData(subjC, yrlvl, blk, studid, status);
            
            // ===== display results =====
            db.getAttdData(subjC, yrlvl, blk, jT_attendance_CA);
            
        } catch (java.lang.NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Please fill in all the input fields.", "NOTICE" ,JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_jB_add_CAActionPerformed

    private void jB_encode_GActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_encode_GActionPerformed
        try {
            String subjcode = String.valueOf(jCB_subjcode_G.getSelectedItem());
            int yrlvl = Integer.valueOf(String.valueOf(jCB_yrlvl_G.getSelectedItem()));
            int blk = Integer.valueOf(String.valueOf(jCB_blk_G.getSelectedItem()));
            int stud_id = Integer.valueOf(jTF_ID_G.getText());
            Double grade = Double.parseDouble(String.valueOf(jCB_grade_G.getSelectedItem()));

            db.encodeGrade(subjcode, yrlvl, blk, stud_id, grade);

            // ===== Reflect results in table =====
            String subjC = String.valueOf(jCB_subjcode_G.getSelectedItem());
            db.getGradeData(subjC, yrlvl, blk, jT_grades_G);
        } catch (java.lang.NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Please fill in all the input fields.", "NOTICE" ,JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_jB_encode_GActionPerformed

    private void jB_update_GActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_update_GActionPerformed
        try {
            String subjcode = String.valueOf(jCB_subjcode_G.getSelectedItem());
            int yrlvl = Integer.valueOf(String.valueOf(jCB_yrlvl_G.getSelectedItem()));
            int blk = Integer.valueOf(String.valueOf(jCB_blk_G.getSelectedItem()));
            int stud_id = Integer.valueOf(jTF_ID_G.getText());
            Double grade = Double.parseDouble(String.valueOf(jCB_grade_G.getSelectedItem()));            
            if (db.verifyStudentOne(stud_id)){
                db.updateGrade(subjcode, yrlvl, blk, stud_id, grade);

                // ===== Reflect results in table =====
                String subjC = String.valueOf(jCB_subjcode_G.getSelectedItem());
                db.getGradeData(subjC, yrlvl, blk, jT_grades_G);            
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a valid Student ID.", "NOTICE" ,JOptionPane.PLAIN_MESSAGE);
            }            
            

        } catch (java.lang.NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Please fill in all the input fields.", "NOTICE" ,JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_jB_update_GActionPerformed

    private void jCB_subjcode_CAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_subjcode_CAActionPerformed

    }//GEN-LAST:event_jCB_subjcode_CAActionPerformed

    private void jB_search_CAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_search_CAActionPerformed

        // ===== customization =====
        jTF_ID_CA.setEnabled(true);
        jCB_status_CA.setEnabled(true);

        // ===== Reflect results in table =====
        String subjC = String.valueOf(jCB_subjcode_CA.getSelectedItem());
        int yrlvl = Integer.parseInt(String.valueOf(jCB_yrlvl_CA.getSelectedItem()));
        int blk = Integer.parseInt(String.valueOf(jCB_blk_CA.getSelectedItem()));
        db.getAttdData(subjC, yrlvl, blk, jT_attendance_CA);
    }//GEN-LAST:event_jB_search_CAActionPerformed

    private void jCB_blk_CAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_blk_CAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCB_blk_CAActionPerformed

    private void jB_search_GActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_search_GActionPerformed
        // ===== Reflect results in table =====
        String subjC = String.valueOf(jCB_subjcode_G.getSelectedItem());
        int yrlvl = Integer.parseInt(String.valueOf(jCB_yrlvl_G.getSelectedItem()));
        int blk = Integer.parseInt(String.valueOf(jCB_blk_G.getSelectedItem()));
        db.getGradeData(subjC, yrlvl, blk, jT_grades_G);
    }//GEN-LAST:event_jB_search_GActionPerformed

    private void jB_delete_GActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_delete_GActionPerformed
        try {
            int studid = Integer.parseInt(jTF_ID_G.getText());
            if (db.verifyStudentOne(studid)){
                int choice = JOptionPane.showConfirmDialog(null, "Confirm deletion of grade for " + studid + "?", 
                                                           "Confirmation", JOptionPane.YES_NO_OPTION); 

                if (choice == JOptionPane.YES_OPTION) { 
                    db.deleteGrade(Integer.valueOf(studid));
                }

                // ===== Reflect results in table =====
                String subjC = String.valueOf(jCB_subjcode_G.getSelectedItem());
                int yrlvl = Integer.parseInt(String.valueOf(jCB_yrlvl_G.getSelectedItem()));
                int blk = Integer.parseInt(String.valueOf(jCB_blk_G.getSelectedItem()));
                db.getGradeData(subjC, yrlvl, blk, jT_grades_G);                
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a valid Student ID.", "NOTICE" ,JOptionPane.PLAIN_MESSAGE);
            }

        } catch (java.lang.NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Please fill in all the input fields.", "NOTICE" ,JOptionPane.PLAIN_MESSAGE);
        }        
    }//GEN-LAST:event_jB_delete_GActionPerformed

    private void jCB_yrlvl_CAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_yrlvl_CAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCB_yrlvl_CAActionPerformed

    private void jCB_grade_GActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_grade_GActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCB_grade_GActionPerformed

    public void setIcon(){
        URL imgurl = getClass().getClassLoader().getResource("assets\\PLM_logo.png");
        ImageIcon icon = new ImageIcon(imgurl);
        setIconImage(icon.getImage()); 
    }
    
    private void setDate(){
        LocalDateTime curDate = LocalDateTime.now();
        int getYear = curDate.getYear();
        int getDay = curDate.getDayOfMonth();
        
        int getMonth = curDate.getMonthValue();
        String monthString;
        switch (getMonth){
            case 1:
                monthString = "January";
                break;
            case 2:
                monthString = "February";
                break;
            case 3:
                monthString = "March";
                break;
            case 4:
                monthString = "April";
                break;
            case 5:
                monthString = "May";
                break;
            case 6:
                monthString = "June";
                break;
            case 7:
                monthString = "July";
                break;
            case 8:
                monthString = "August";
                break;
            case 9:
                monthString = "September";
                break;
            case 10:
                monthString = "October";
                break;
            case 11:
                monthString = "November";
                break;
            case 12:
                monthString = "December";
                break;
            default:
                monthString = "null";
        }
        
        String dateToday = monthString + " " + getDay + ", " + getYear;
        jL_Date.setText(dateToday);
    }
    
    private void startClock() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String currentTime = sdf.format(new Date());
                jL_Time.setText(currentTime);
            }
        });
        timer.start();
    }
    
    public boolean isValidDateFormat(String date) {
        return date.matches("^(0[1-9]|1[0-2])-([0-2][0-9]|3[01])-[0-9]{4}$");
    }
    
    public boolean verifyPass(){
        boolean isTrue = false; 
        String pass = JOptionPane.showInputDialog("Enter password:");
        if (db.checkAdmin(userID, pass)){
            isTrue = true;
        }
        return isTrue;
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
            java.util.logging.Logger.getLogger(DashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardAdmin(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jB_ClassAttd;
    private javax.swing.JButton jB_EnterID_SI;
    private javax.swing.JButton jB_Grade;
    private javax.swing.JButton jB_Logout;
    private javax.swing.JButton jB_Profile;
    private javax.swing.JButton jB_StudInfo;
    private javax.swing.JButton jB_add_CA;
    private javax.swing.JButton jB_delete_G;
    private javax.swing.JButton jB_encode_G;
    private javax.swing.JButton jB_enter_P;
    private javax.swing.JButton jB_search_CA;
    private javax.swing.JButton jB_search_G;
    private javax.swing.JButton jB_update_G;
    private javax.swing.JComboBox<String> jCB_blk_CA;
    private javax.swing.JComboBox<String> jCB_blk_G;
    private javax.swing.JComboBox<String> jCB_grade_G;
    private javax.swing.JComboBox<String> jCB_status_CA;
    private javax.swing.JComboBox<String> jCB_subjcode_CA;
    private javax.swing.JComboBox<String> jCB_subjcode_G;
    private javax.swing.JComboBox<String> jCB_yrlvl_CA;
    private javax.swing.JComboBox<String> jCB_yrlvl_G;
    private javax.swing.JLabel jL_Date;
    private javax.swing.JLabel jL_EnterID_SI;
    private javax.swing.JLabel jL_ID_CA;
    private javax.swing.JLabel jL_ID_G;
    private javax.swing.JLabel jL_Time;
    private javax.swing.JLabel jL_adminID_P;
    private javax.swing.JLabel jL_birth_P;
    private javax.swing.JLabel jL_birth_SI;
    private javax.swing.JLabel jL_bldg_P;
    private javax.swing.JLabel jL_blk_CA;
    private javax.swing.JLabel jL_blk_G;
    private javax.swing.JLabel jL_blk_SI;
    private javax.swing.JLabel jL_college_P;
    private javax.swing.JLabel jL_college_SI;
    private javax.swing.JLabel jL_contact_P;
    private javax.swing.JLabel jL_contact_SI;
    private javax.swing.JLabel jL_crs_SI;
    private javax.swing.JLabel jL_dept_P;
    private javax.swing.JLabel jL_email_P;
    private javax.swing.JLabel jL_email_SI;
    private javax.swing.JLabel jL_fullN_P;
    private javax.swing.JLabel jL_fullN_SI;
    private javax.swing.JLabel jL_grade_G;
    private javax.swing.JLabel jL_status_CA;
    private javax.swing.JLabel jL_status_SI;
    private javax.swing.JLabel jL_studID_SI;
    private javax.swing.JLabel jL_subjcode_CA;
    private javax.swing.JLabel jL_subjcode_G;
    private javax.swing.JLabel jL_type_SI;
    private javax.swing.JLabel jL_user;
    private javax.swing.JLabel jL_username_P;
    private javax.swing.JLabel jL_username_SI;
    private javax.swing.JLabel jL_welcome;
    private javax.swing.JLabel jL_yrlvl_CA;
    private javax.swing.JLabel jL_yrlvl_G;
    private javax.swing.JLabel jL_yrlvl_SI;
    private javax.swing.JPanel jP_ClassAttendance;
    private javax.swing.JPanel jP_Grade;
    private javax.swing.JPanel jP_Profile;
    private javax.swing.JPanel jP_StudentInfo;
    private javax.swing.JPanel jP_leftBar;
    private javax.swing.JPanel jP_topBar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTF_EnterID_SI;
    private javax.swing.JTextField jTF_ID_CA;
    private javax.swing.JTextField jTF_ID_G;
    private javax.swing.JTextField jTF_adminID_P;
    private javax.swing.JTextField jTF_birth_P;
    private javax.swing.JTextField jTF_birth_SI;
    private javax.swing.JTextField jTF_bldg_P;
    private javax.swing.JTextField jTF_blk_SI;
    private javax.swing.JTextField jTF_college_P;
    private javax.swing.JTextField jTF_college_SI;
    private javax.swing.JTextField jTF_contact_P;
    private javax.swing.JTextField jTF_contact_SI;
    private javax.swing.JTextField jTF_crs_SI;
    private javax.swing.JTextField jTF_dept_P;
    private javax.swing.JTextField jTF_email_P;
    private javax.swing.JTextField jTF_email_SI;
    private javax.swing.JTextField jTF_fullN_P;
    private javax.swing.JTextField jTF_fullN_SI;
    private javax.swing.JTextField jTF_status_SI;
    private javax.swing.JTextField jTF_studID_SI;
    private javax.swing.JTextField jTF_type_SI;
    private javax.swing.JTextField jTF_username_P;
    private javax.swing.JTextField jTF_username_SI;
    private javax.swing.JTextField jTF_yrlvl_SI;
    private javax.swing.JTable jT_attendance_CA;
    private javax.swing.JTable jT_grades_G;
    // End of variables declaration//GEN-END:variables
}

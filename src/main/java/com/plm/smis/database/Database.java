
package com.plm.smis.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
        
public class Database {
    // CHANGE NIYO YUNG INFORMATION DITO PARA MATRY NYO RIN SAINYO
    private static final String username = "root";
    private static final String pass = "SqlSakalam765";
    private static final String dataConnect = "jdbc:mysql://localhost:3306/";
    private static final String db_name = "smissdb";
    
    private Connection sqlConn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    
    // CREATION OF DATABASE
    public void createDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConnect, username, pass);
            
            // CREATE DATABASE
            String sqlcmd = "CREATE DATABASE IF NOT EXISTS " + db_name;
            pst = sqlConn.prepareStatement(sqlcmd);
            pst.executeUpdate();
            
            // SET DATABASE
            sqlConn.setCatalog(db_name);
            
            // CREATE TABLES
            // users [ADMIN]
            sqlcmd = "CREATE TABLE IF NOT EXISTS adminusers (" +
                    "admin_id INT PRIMARY KEY, " +
                    "admin_pass VARCHAR(50)); ";
            pst = sqlConn.prepareStatement(sqlcmd);
            pst.executeUpdate();
            
            // users [STUDENT]
            sqlcmd = "CREATE TABLE IF NOT EXISTS studentusers (" +
                    "stud_id INT PRIMARY KEY, " +
                    "stud_pass VARCHAR(50), " + 
                    "CONSTRAINT chk_studid CHECK (stud_id > 200000000)); ";
            pst = sqlConn.prepareStatement(sqlcmd);
            pst.executeUpdate();
            
            // info [ADMIN]
            sqlcmd = "CREATE TABLE IF NOT EXISTS admininfo (" +
                    "admin_id INT, " +
                    "admin_username VARCHAR(50), " +
                    "admin_name VARCHAR(100), " +
                    "admin_email VARCHAR(50), " +
                    "admin_contact VARCHAR(50), " +
                    "admin_birth VARCHAR(10), " +
                    "admin_college VARCHAR(10), " +
                    "admin_dept VARCHAR(10), " +
                    "admin_bldg VARCHAR(5), " +
                    "FOREIGN KEY(admin_id) REFERENCES adminusers(admin_id), " +
                    "CONSTRAINT chk_admin_birth CHECK (admin_birth REGEXP '^(0[1-9]|1[0-2])-([0-2][0-9]|3[01])-[0-9]{4}$'));";
            pst = sqlConn.prepareStatement(sqlcmd);
            pst.executeUpdate();
            
            // blocklist
            sqlcmd = "CREATE TABLE IF NOT EXISTS blocklist(" +
                    "yrlvl INT, " +
                    "blk INT, " +
                    "PRIMARY KEY(yrlvl, blk));";
            pst = sqlConn.prepareStatement(sqlcmd);
            pst.executeUpdate();
            
            // info [STUDENT]
            sqlcmd = "CREATE TABLE IF NOT EXISTS studentinfo (" +
                    "stud_id INT, " +
                    "stud_username VARCHAR(50), " +
                    "stud_name VARCHAR(100), " + 
                    "stud_email VARCHAR(50), " +
                    "stud_contact VARCHAR(50), " +
                    "stud_birth VARCHAR(10), " +
                    "stud_college VARCHAR(10), " +
                    "stud_crs VARCHAR(100), " +
                    "stud_type VARCHAR(5), " +
                    "stud_status VARCHAR(20), " +
                    "yrlvl INT, " +
                    "blk INT, " +
                    "FOREIGN KEY(stud_id) REFERENCES studentusers(stud_id), " +
                    "FOREIGN KEY(yrlvl, blk) REFERENCES blocklist(yrlvl, blk), " +
                    "CONSTRAINT chk_stud_birth CHECK (stud_birth REGEXP '^(0[1-9]|1[0-2])-([0-2][0-9]|3[01])-[0-9]{4}$'));";
            pst = sqlConn.prepareStatement(sqlcmd);
            pst.executeUpdate();
            
            // subjects [ADMIN]
            sqlcmd = "CREATE TABLE IF NOT EXISTS subject (" +
                    "admin_id INT, " +
                    "subj_code VARCHAR(20) PRIMARY KEY, " +
                    "subj_title VARCHAR(100), " +
                    "FOREIGN KEY(admin_id) REFERENCES admininfo(admin_id));";
            pst = sqlConn.prepareStatement(sqlcmd);
            pst.executeUpdate();
            
            // masterlist [ADMIN]
            sqlcmd = "CREATE TABLE IF NOT EXISTS masterlist (" +
                    "subj_code VARCHAR(20), " +
                    "yrlvl INT, " +
                    "blk INT, " +
                    "stud_id INT, " +
                    "FOREIGN KEY(subj_code) REFERENCES subject(subj_code), " +
                    "FOREIGN KEY(stud_id) REFERENCES studentinfo(stud_id), " +
                    "FOREIGN KEY(yrlvl, blk) REFERENCES studentinfo(yrlvl, blk), " +
                    "INDEX idx_masterlist_composite (subj_code, yrlvl, blk, stud_id));";
            pst = sqlConn.prepareStatement(sqlcmd);
            pst.executeUpdate();
            
            // attendance [ADMIN]
            sqlcmd = "CREATE TABLE IF NOT EXISTS attendance (" +
                    "subj_code VARCHAR(20), " +
                    "yrlvl INT, " +
                    "blk INT, " +
                    "stud_id INT, " +
                    "attd_datetime DATETIME, " +
                    "attd_status VARCHAR(20), " +
                    "FOREIGN KEY(subj_code, yrlvl, blk, stud_id) REFERENCES masterlist(subj_code, yrlvl, blk, stud_id));";
            pst = sqlConn.prepareStatement(sqlcmd);
            pst.executeUpdate();
            
            // grade [ADMIN]
            sqlcmd = "CREATE TABLE IF NOT EXISTS grade (" +
                    "subj_code VARCHAR(20), " +
                    "yrlvl INT, " +
                    "blk INT, " +
                    "stud_id INT, " +
                    "subj_grade DECIMAL(5, 2), " +
                    "FOREIGN KEY(subj_code, yrlvl, blk, stud_id) REFERENCES masterlist(subj_code, yrlvl, blk, stud_id));";
            pst = sqlConn.prepareStatement(sqlcmd);
            pst.executeUpdate();
            
            // initialize data
            sampleDB();
        } catch (SQLException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException e) { 
            e.printStackTrace();    
            throw new RuntimeException("Failed to load MySQL JDBC driver");
        } finally {                             
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (sqlConn != null) sqlConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    // Create pre-made datas (RUN ONLY ONCE)
    public void sampleDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConnect, username, pass);
            
            // SET DATABASE
            sqlConn.setCatalog(db_name);
            
            // adminusers
            String sqlcmd = "INSERT INTO adminusers VALUES (1, \"asd\"), (2, \"asd\");";
            pst = sqlConn.prepareStatement(sqlcmd);
            pst.executeUpdate();
            
            // admininfo
            sqlcmd = "INSERT INTO admininfo " +
                    "VALUES (1, \"Karen\", \"Karen Verona\", \"karen123gmail.com\", \"0959595959\", \"01-01-2000\", \"CISTM\", \"CSS\", \"GV\"), " + 
                    "(2, \"Jelai\", \"Jelai Shin\", \"shin123gmail.com\", \"0959595959\", \"01-01-2000\", \"CISTM\", \"CSS\", \"GV\");";
            pst = sqlConn.prepareStatement(sqlcmd);
            pst.executeUpdate();
            
            // studentusers
            sqlcmd = "INSERT INTO studentusers VALUES " +
                    "(200012341, \"asd\")," +   // yr 1 blk 1
                    "(200012342, \"asd\")," + 
                    "(200012343, \"asd\")," + 
                    "(200012344, \"asd\")," + 
                    "(200012345, \"asd\")," + 
                    "(202212341, \"asd\")," +   // yr 1 blk 2
                    "(202212342, \"asd\")," + 
                    "(202212343, \"asd\")," + 
                    "(202212344, \"asd\")," + 
                    "(202212345, \"asd\")," +
                    "(200054321, \"asd\")," +   // yr 2 blk 1
                    "(200054322, \"asd\")," +
                    "(200054323, \"asd\")," +
                    "(200054324, \"asd\")," +
                    "(200054325, \"asd\")," +
                    "(202254321, \"asd\")," +   // yr 2 blk 2
                    "(202254322, \"asd\")," +
                    "(202254323, \"asd\")," +
                    "(202254324, \"asd\")," +
                    "(202254325, \"asd\");";
            pst = sqlConn.prepareStatement(sqlcmd);
            pst.executeUpdate();
            
            // blocklist
            sqlcmd = "INSERT INTO blocklist VALUES (1, 1), (1, 2), (2, 1), (2, 2);";
            pst = sqlConn.prepareStatement(sqlcmd);
            pst.executeUpdate();
            
            // studentinfo
            sqlcmd = "INSERT INTO studentinfo VALUES " + 
                    // yr 1 blk 1
                    "(200012341, \"Jason\", \"Jason Smith\", \"json123gmail.com\", \"0959595959\", \"01-01-2000\", \"CISTM\", \"BSCS\", \"OLD\", \"REGULAR\", \"1\", \"1\"), " + 
                    "(200012342, \"James\", \"James Harden\", \"jhard123gmail.com\", \"0959595959\", \"01-01-2000\", \"CISTM\", \"BSCS\", \"OLD\", \"REGULAR\", \"1\", \"1\"), " + 
                    "(200012343, \"Alex\", \"Alex Dizon\", \"dizon123gmail.com\", \"0959595959\", \"01-01-2000\", \"CISTM\", \"BSCS\", \"OLD\", \"REGULAR\", \"1\", \"1\"), " + 
                    "(200012344, \"Jade\", \"Jade Francisco\", \"jade123gmail.com\", \"0959595959\", \"01-01-2000\", \"CISTM\", \"BSCS\", \"OLD\", \"REGULAR\", \"1\", \"1\"), " + 
                    "(200012345, \"Jayz\", \"Jayz De Vera\", \"jayz123gmail.com\", \"0959595959\", \"01-01-2000\", \"CISTM\", \"BSCS\", \"OLD\", \"REGULAR\", \"1\", \"1\"), " + 
                    // yr 1 blk 2
                    "(202212341, \"Shai\", \"Shai Ra\", \"shra123gmail.com\", \"0959595959\", \"01-01-2000\", \"CISTM\", \"BSCS\", \"OLD\", \"REGULAR\", \"1\", \"2\"), " + 
                    "(202212342, \"Jane\", \"Jane Net\", \"jnet123gmail.com\", \"0959595959\", \"01-01-2000\", \"CISTM\", \"BSCS\", \"OLD\", \"REGULAR\", \"1\", \"2\"), " + 
                    "(202212343, \"Kyze\", \"Kyze Zotto\", \"sotto123gmail.com\", \"0959595959\", \"01-01-2000\", \"CISTM\", \"BSCS\", \"OLD\", \"REGULAR\", \"1\", \"2\"), " + 
                    "(202212344, \"Maloi\", \"Maloi Entrata\", \"maloi123gmail.com\", \"0959595959\", \"01-01-2000\", \"CISTM\", \"BSCS\", \"OLD\", \"REGULAR\", \"1\", \"2\"), " + 
                    "(202212345, \"Bini\", \"Bini Ten\", \"bten123gmail.com\", \"0959595959\", \"01-01-2000\", \"CISTM\", \"BSCS\", \"OLD\", \"REGULAR\", \"1\", \"2\"), " +  
                    // yr 2 blk 1
                    "(200054321, \"Maria\", \"Maria Santos\", \"msantos123@gmail.com\", \"0959595959\", \"01-01-2000\", \"CISTM\", \"BSCS\", \"OLD\", \"REGULAR\", \"2\", \"1\"), " + 
                    "(200054322, \"Juan\", \"Juan Dela Cruz\", \"jdelacruz123@gmail.com\", \"0959595959\", \"01-01-2000\", \"CISTM\", \"BSCS\", \"OLD\", \"REGULAR\", \"2\", \"1\"), " +
                    "(200054323, \"Ana\", \"Ana Reyes\", \"areyes123@gmail.com\", \"0959595959\", \"01-01-2000\", \"CISTM\", \"BSCS\", \"OLD\", \"REGULAR\", \"2\", \"1\"), " + 
                    "(200054324, \"Jose\", \"Jose Garcia\", \"jgarcia123@gmail.com\", \"0959595959\", \"01-01-2000\", \"CISTM\", \"BSCS\", \"OLD\", \"REGULAR\", \"2\", \"1\"), " + 
                    "(200054325, \"Liza\", \"Liza Mendoza\", \"lmendoza123@gmail.com\", \"0959595959\", \"01-01-2000\", \"CISTM\", \"BSCS\", \"OLD\", \"REGULAR\", \"2\", \"1\"), " + 
                    // yr 2 blk 2
                    "(202254321, \"Mark\", \"Mark Villanueva\", \"mvillanueva123@gmail.com\", \"0959595959\", \"01-01-2000\", \"CISTM\", \"BSCS\", \"OLD\", \"REGULAR\", \"2\", \"2\"), " +
                    "(202254322, \"Carla\", \"Carla Aquino\", \"caquino123@gmail.com\", \"0959595959\", \"01-01-2000\", \"CISTM\", \"BSCS\", \"OLD\", \"REGULAR\", \"2\", \"2\"), " + 
                    "(202254323, \"Miguel\", \"Miguel Ramos\", \"mramos123@gmail.com\", \"0959595959\", \"01-01-2000\", \"CISTM\", \"BSCS\", \"OLD\", \"REGULAR\", \"2\", \"2\"), " + 
                    "(202254324, \"Jasmine\", \"Jasmine Bautista\", \"jbautista123@gmail.com\", \"0959595959\", \"01-01-2000\", \"CISTM\", \"BSCS\", \"OLD\", \"REGULAR\", \"2\", \"2\"), " + 
                    "(202254325, \"Paolo\", \"Paolo Navarro\", \"pnavarro123@gmail.com\", \"0959595959\", \"01-01-2000\", \"CISTM\", \"BSCS\", \"OLD\", \"REGULAR\", \"2\", \"2\");";
            pst = sqlConn.prepareStatement(sqlcmd);
            pst.executeUpdate();
            
            // subject
            sqlcmd = "INSERT INTO subject VALUES " + 
                    "(1, \"ICC 0103\", \"Intermediate Programming (lec)\"), " + 
                    "(1, \"ICC 0103.1\", \"Intermediate Programming (lab)\"), " + 
                    "(1, \"ICC 0104\", \"Data Structures and Algorithms (lec)\"), " + 
                    "(1, \"ICC 0104.1\", \"Data Structures and Algorithms (lab)\"), " + 
                    "(2, \"CSC 0222\", \"Architecture and Organization (lec)\"), " + 
                    "(2, \"CSC 0222.1\", \"Architecture and Organization (lab)\"), " + 
                    "(2, \"ICC 0106\", \"Applications Develpment and Emerging Technologies (lec)\"), " + 
                    "(2, \"ICC 0106.1\", \"Applications Develpment and Emerging Technologies (lab)\");";
            pst = sqlConn.prepareStatement(sqlcmd);
            pst.executeUpdate();
            
            // masterlist
            sqlcmd = "INSERT INTO masterlist VALUES " + 
                    "(\"ICC 0103\", 1, 1, 200012341)," +    // yr 1 blk 1
                    "(\"ICC 0103\", 1, 1, 200012342)," +
                    "(\"ICC 0103\", 1, 1, 200012343)," +
                    "(\"ICC 0103\", 1, 1, 200012344)," +
                    "(\"ICC 0103\", 1, 1, 200012345)," +
                    "(\"ICC 0103\", 1, 2, 202212341)," +    // yr 1 blk 2
                    "(\"ICC 0103\", 1, 2, 202212342)," +
                    "(\"ICC 0103\", 1, 2, 202212343)," +
                    "(\"ICC 0103\", 1, 2, 202212344)," +
                    "(\"ICC 0103\", 1, 2, 202212345)," +
                    "(\"ICC 0103.1\", 1, 1, 200012341)," +  // yr 1 blk 1
                    "(\"ICC 0103.1\", 1, 1, 200012342)," +
                    "(\"ICC 0103.1\", 1, 1, 200012343)," +
                    "(\"ICC 0103.1\", 1, 1, 200012344)," +
                    "(\"ICC 0103.1\", 1, 1, 200012345)," +
                    "(\"ICC 0103.1\", 1, 2, 202212341)," +  // yr 1 blk 2
                    "(\"ICC 0103.1\", 1, 2, 202212342)," +
                    "(\"ICC 0103.1\", 1, 2, 202212343)," +
                    "(\"ICC 0103.1\", 1, 2, 202212344)," +
                    "(\"ICC 0103.1\", 1, 2, 202212345)," +
                    "(\"ICC 0104\", 1, 1, 200012341)," +    // yr 1 blk 1
                    "(\"ICC 0104\", 1, 1, 200012342)," +
                    "(\"ICC 0104\", 1, 1, 200012343)," +
                    "(\"ICC 0104\", 1, 1, 200012344)," +
                    "(\"ICC 0104\", 1, 1, 200012345)," +
                    "(\"ICC 0104\", 1, 2, 202212341)," +    // yr 1 blk 2
                    "(\"ICC 0104\", 1, 2, 202212342)," +
                    "(\"ICC 0104\", 1, 2, 202212343)," +
                    "(\"ICC 0104\", 1, 2, 202212344)," +
                    "(\"ICC 0104\", 1, 2, 202212345)," +
                    "(\"ICC 0104.1\", 1, 1, 200012341)," + // yr 1 blk 1
                    "(\"ICC 0104.1\", 1, 1, 200012342)," +
                    "(\"ICC 0104.1\", 1, 1, 200012343)," +
                    "(\"ICC 0104.1\", 1, 1, 200012344)," +
                    "(\"ICC 0104.1\", 1, 1, 200012345)," +
                    "(\"ICC 0104.1\", 1, 2, 202212341)," + // yr 1 blk 2
                    "(\"ICC 0104.1\", 1, 2, 202212342)," +
                    "(\"ICC 0104.1\", 1, 2, 202212343)," +
                    "(\"ICC 0104.1\", 1, 2, 202212344)," +
                    "(\"ICC 0104.1\", 1, 2, 202212345)," +
                    // =====
                    "(\"CSC 0222\", 2, 1, 200054321)," +    // yr 2 blk 1
                    "(\"CSC 0222\", 2, 1, 200054322)," +
                    "(\"CSC 0222\", 2, 1, 200054323)," +
                    "(\"CSC 0222\", 2, 1, 200054324)," +
                    "(\"CSC 0222\", 2, 1, 200054325)," +
                    "(\"CSC 0222\", 2, 2, 202254321)," +    // yr 2 blk 2
                    "(\"CSC 0222\", 2, 2, 202254322)," +    
                    "(\"CSC 0222\", 2, 2, 202254323)," +    
                    "(\"CSC 0222\", 2, 2, 202254324)," +    
                    "(\"CSC 0222\", 2, 2, 202254325)," +
                    "(\"CSC 0222.1\", 2, 1, 200054321)," +  // yr 2 blk 1
                    "(\"CSC 0222.1\", 2, 1, 200054322)," +
                    "(\"CSC 0222.1\", 2, 1, 200054323)," +
                    "(\"CSC 0222.1\", 2, 1, 200054324)," +
                    "(\"CSC 0222.1\", 2, 1, 200054325)," +
                    "(\"CSC 0222.1\", 2, 2, 202254321)," +  // yr 2 blk 2
                    "(\"CSC 0222.1\", 2, 2, 202254322)," + 
                    "(\"CSC 0222.1\", 2, 2, 202254323)," + 
                    "(\"CSC 0222.1\", 2, 2, 202254324)," + 
                    "(\"CSC 0222.1\", 2, 2, 202254325)," +
                    "(\"ICC 0106\", 2, 1, 200054321), " +   // yr 2 blk 1
                    "(\"ICC 0106\", 2, 1, 200054322), " +
                    "(\"ICC 0106\", 2, 1, 200054323), " +
                    "(\"ICC 0106\", 2, 1, 200054324), " +
                    "(\"ICC 0106\", 2, 1, 200054325), " +
                    "(\"ICC 0106\", 2, 2, 202254321), " +   // yr 2 blk 2
                    "(\"ICC 0106\", 2, 2, 202254322), " +
                    "(\"ICC 0106\", 2, 2, 202254323), " +
                    "(\"ICC 0106\", 2, 2, 202254324), " +
                    "(\"ICC 0106\", 2, 2, 202254325), " +
                    "(\"ICC 0106.1\", 2, 1, 200054321)," + // yr 2 blk 1
                    "(\"ICC 0106.1\", 2, 1, 200054322)," +
                    "(\"ICC 0106.1\", 2, 1, 200054323)," +
                    "(\"ICC 0106.1\", 2, 1, 200054324)," +
                    "(\"ICC 0106.1\", 2, 1, 200054325)," +
                    "(\"ICC 0106.1\", 2, 2, 202254321)," +  // yr 2 blk 2
                    "(\"ICC 0106.1\", 2, 2, 202254322)," + 
                    "(\"ICC 0106.1\", 2, 2, 202254323)," + 
                    "(\"ICC 0106.1\", 2, 2, 202254324)," + 
                    "(\"ICC 0106.1\", 2, 2, 202254325);";
            pst = sqlConn.prepareStatement(sqlcmd);
            pst.executeUpdate();
            
            // attendance
//            sqlcmd = "INSERT INTO attendance VALUES " + 
//                    "(\"ICC 0103\", 1, 1, 202212345, NOW()-1, \"PRESENT\")," + 
//            pst = sqlConn.prepareStatement(sqlcmd);
//            pst.executeUpdate();     
            
            // for attendance & grade, manually input them 
            
        } catch (SQLException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException e) { 
            e.printStackTrace();    
            throw new RuntimeException("Failed to load MySQL JDBC driver");
        } finally {                             
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (sqlConn != null) sqlConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    // ===== STARTUP METHODS =====
    
    // LOGIN [ADMIN]
    public boolean checkAdmin(int admin_id, String admin_pass){
        boolean isExist = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConnect + db_name, username, pass);
            String sqlcmd = "SELECT * FROM adminusers WHERE admin_id = ? AND admin_pass = ?";
            pst = sqlConn.prepareStatement(sqlcmd);
            
            pst.setInt(1, admin_id);
            pst.setString(2, admin_pass);
            
            rs = pst.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                isExist = true; 
                System.out.println("Account exists");
            } 
            
        } catch (SQLException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException e) { 
            e.printStackTrace();    
            throw new RuntimeException("Failed to load MySQL JDBC driver");
        } finally {                             
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (sqlConn != null) sqlConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isExist;
    }
    
    // SIGNUP [ADMIN]
    public boolean verifyAdmin(int admin_id){
        boolean isNotRegistered = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConnect + db_name, username, pass);
            String sqlcmd = "SELECT * FROM adminusers "
                    + "WHERE admin_id = ? ;";
            pst = sqlConn.prepareStatement(sqlcmd);
            
            pst.setInt(1, admin_id);
            
            rs = pst.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                System.out.println("Account already exists");
                JOptionPane.showMessageDialog(null, "Admin ID already exists", "NOTICE" ,JOptionPane.PLAIN_MESSAGE);
                isNotRegistered = false; 
            } else {
                System.out.println("Account UNIQUE");
                isNotRegistered = true;
            }
            
        } catch (SQLException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException e) { 
            e.printStackTrace();    
            throw new RuntimeException("Failed to load MySQL JDBC driver");
        } finally {                             
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (sqlConn != null) sqlConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isNotRegistered;
    }
    
    public void registerAdmin(String admin_username, int admin_id, String admin_pass){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConnect + db_name, username, pass);
            String sqlcmd = "INSERT INTO adminusers "
                    + "VALUES (?, ?);";
            pst = sqlConn.prepareStatement(sqlcmd);
            
            pst.setInt(1, admin_id);
            pst.setString(2, admin_pass);
            pst.executeUpdate();
            
            sqlcmd = "INSERT INTO admininfo (admin_id, admin_username) "
                    + "VALUES (?, ?);";
            pst = sqlConn.prepareStatement(sqlcmd);
            pst.setInt(1, admin_id);
            pst.setString(2, admin_username);
            pst.executeUpdate();
        } catch (SQLException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException e) { 
            e.printStackTrace();    
            throw new RuntimeException("Failed to load MySQL JDBC driver");
        } finally {                             
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (sqlConn != null) sqlConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    // LOGIN [STUDENT]
    public boolean checkStudent(int stud_id, String stud_pass){
        boolean isExist = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConnect + db_name, username, pass);
            String sqlcmd = "SELECT * FROM studentusers WHERE stud_id = ? AND stud_pass = ?";
            pst = sqlConn.prepareStatement(sqlcmd);
            
            pst.setInt(1, stud_id);
            pst.setString(2, stud_pass);
            
            rs = pst.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                isExist = true; 
                System.out.println("Account exists");
            } 
            
        } catch (SQLException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException e) { 
            e.printStackTrace();    
            throw new RuntimeException("Failed to load MySQL JDBC driver");
        } finally {                             
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (sqlConn != null) sqlConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isExist;
    }
    
    // SIGNUP [STUDENT]
    public boolean verifyStudent(int stud_id){
        boolean isNotRegistered = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConnect + db_name, username, pass);
            String sqlcmd = "SELECT * FROM studentusers "
                    + "WHERE stud_id = ? ;";
            pst = sqlConn.prepareStatement(sqlcmd);
            
            pst.setInt(1, stud_id);
            
            rs = pst.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                System.out.println("Account already exists");
                JOptionPane.showMessageDialog(null, "Student ID already exists", "NOTICE" ,JOptionPane.PLAIN_MESSAGE);
                isNotRegistered = false; 
            } else {
                System.out.println("Account UNIQUE");
                isNotRegistered = true;
            }
            
        } catch (SQLException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException e) { 
            e.printStackTrace();    
            throw new RuntimeException("Failed to load MySQL JDBC driver");
        } finally {                             
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (sqlConn != null) sqlConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isNotRegistered;
    }
    
    public boolean verifyStudentOne(int stud_id){
        boolean isNotRegistered = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConnect + db_name, username, pass);
            String sqlcmd = "SELECT * FROM studentusers "
                    + "WHERE stud_id = ? ;";
            pst = sqlConn.prepareStatement(sqlcmd);
            
            pst.setInt(1, stud_id);
            
            rs = pst.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                isNotRegistered = true; 
            } 
            
        } catch (SQLException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException e) { 
            e.printStackTrace();    
            throw new RuntimeException("Failed to load MySQL JDBC driver");
        } finally {                             
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (sqlConn != null) sqlConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isNotRegistered;
    }
    
    public boolean registerStudent(String stud_username, int stud_id, String stud_pass){
        boolean isRegistered = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConnect + db_name, username, pass);
            String sqlcmd = "INSERT INTO studentusers "
                    + "VALUES (?, ?);";
            pst = sqlConn.prepareStatement(sqlcmd);
            
            pst.setInt(1, stud_id);
            pst.setString(2, stud_pass);
            pst.executeUpdate();
            
            sqlcmd = "INSERT INTO studentinfo (stud_id, stud_username) "
                    + "VALUES (?, ?);";
            pst = sqlConn.prepareStatement(sqlcmd);
            pst.setInt(1, stud_id);
            pst.setString(2, stud_username);
            pst.executeUpdate();
            return isRegistered = true;
        } catch (SQLException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException e) { 
            e.printStackTrace();    
            throw new RuntimeException("Failed to load MySQL JDBC driver");
        } finally {                             
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (sqlConn != null) sqlConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isRegistered;
    }
    
    // ===== DASHBOARD =====
    
    // DASHBOARD [ADMIN]
    public String getAdminUser(int admin_id){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConnect + db_name, username, pass);
            String sqlcmd = "SELECT * FROM admininfo WHERE admin_id = ?;";
            pst = sqlConn.prepareStatement(sqlcmd);
            
            pst.setInt(1, admin_id);
            rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getString("admin_username");
            } 
            
        } catch (SQLException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException e) { 
            e.printStackTrace();    
            throw new RuntimeException("Failed to load MySQL JDBC driver");
        } finally {                             
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (sqlConn != null) sqlConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    
    // **Profile
    public String getProfileData(int admin_id, String data_req){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConnect + db_name, username, pass);
            String sqlcmd = "SELECT * FROM admininfo WHERE admin_id = ?;";
            pst = sqlConn.prepareStatement(sqlcmd);
            
            pst.setInt(1, admin_id);
            rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getString(data_req);
            } 
            
        } catch (SQLException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException e) { 
            e.printStackTrace();    
            throw new RuntimeException("Failed to load MySQL JDBC driver");
        } finally {                             
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (sqlConn != null) sqlConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    
    public void updateProfileData(int admin_id, String admin_username, String admin_name, String admin_email, String admin_contact, String admin_birth){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConnect + db_name, username, pass);
            String sqlcmd = "UPDATE admininfo " + 
                            "SET admin_username = ?, " +
                            "admin_name = ?, " +
                            "admin_email = ?, " +
                            "admin_contact = ?, " +
                            "admin_birth = ? " +
                            "WHERE admin_id = ?;";
            pst = sqlConn.prepareStatement(sqlcmd);
            
            pst.setString(1, admin_username);
            pst.setString(2, admin_name);
            pst.setString(3, admin_email);
            pst.setString(4, admin_contact);
            pst.setString(5, admin_birth);
            pst.setInt(6, admin_id);
            pst.executeUpdate();

        } catch (SQLException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException e) { 
            e.printStackTrace();    
            throw new RuntimeException("Failed to load MySQL JDBC driver");
        } finally {                             
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (sqlConn != null) sqlConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    // **Attendance
    public void getSubjList(int admin_id, javax.swing.JComboBox<String> jCB){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConnect + db_name, username, pass);
            String sqlcmd = "SELECT * FROM subject WHERE admin_id = ?;"; // subj_code
            pst = sqlConn.prepareStatement(sqlcmd);
            
            pst.setInt(1, admin_id);
            rs = pst.executeQuery();
            
            while (rs.next()){
                jCB.addItem(rs.getString("subj_code"));
            }
            
        } catch (SQLException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException e) { 
            e.printStackTrace();    
            throw new RuntimeException("Failed to load MySQL JDBC driver");
        } finally {                             
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (sqlConn != null) sqlConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } 
    }
    
    public void getSection(String subj_code, javax.swing.JComboBox<String> jCB_yrlvl, javax.swing.JComboBox<String> jCB_blk){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConnect + db_name, username, pass);
            String sqlcmd = "SELECT * FROM masterlist WHERE subj_code = ?;"; // subj_code
            pst = sqlConn.prepareStatement(sqlcmd);
            
            pst.setString(1, subj_code);
            rs = pst.executeQuery();
            
            while (rs.next()){
                jCB_yrlvl.addItem(rs.getString("yrlvl"));
                jCB_blk.addItem(rs.getString("blk"));
            }
            
        } catch (SQLException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException e) { 
            e.printStackTrace();    
            throw new RuntimeException("Failed to load MySQL JDBC driver");
        } finally {                             
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (sqlConn != null) sqlConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } 
    }
    
    public String getAttdData(String subj_code, int yrlvl, int blk, javax.swing.JTable table){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConnect + db_name, username, pass);
            String sqlcmd = "SELECT * FROM attendance WHERE subj_code = ? AND yrlvl = ? AND blk = ?;"; // subj_code
            pst = sqlConn.prepareStatement(sqlcmd);
            
            pst.setString(1, subj_code);
            pst.setInt(2, yrlvl);
            pst.setInt(3, blk);
            rs = pst.executeQuery();
            ResultSetMetaData stData = rs.getMetaData();
            
            int q = stData.getColumnCount();
            
            DefaultTableModel RecordTable = (DefaultTableModel) table.getModel();
            RecordTable.setRowCount(0);
            
            while (rs.next()){
                Vector columnData = new Vector();
                
                for (int i=1; i <= q; i++){
                    columnData.add(rs.getString("subj_code"));
                    columnData.add(rs.getString("yrlvl"));
                    columnData.add(rs.getString("blk"));
                    columnData.add(rs.getString("stud_id"));
                    columnData.add(rs.getString("attd_datetime"));
                    columnData.add(rs.getString("attd_status"));
                }       
                RecordTable.addRow(columnData);
            }
            
            if (rs.next()) {
//                return rs.getString(data_req); display
            } 
            
        } catch (SQLException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException e) { 
            e.printStackTrace();    
            throw new RuntimeException("Failed to load MySQL JDBC driver");
        } finally {                             
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (sqlConn != null) sqlConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    
    public void insertAttdData (String subj_code, int yrlvl, int blk, int stud_id, String attd_status){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConnect + db_name, username, pass);
            String sqlcmd = "INSERT INTO attendance VALUES( " + 
                            "?, ?, ?, ?, NOW(), ?);";
            pst = sqlConn.prepareStatement(sqlcmd);
            
            pst.setString(1, subj_code);
            pst.setInt(2, yrlvl);
            pst.setInt(3, blk);
            pst.setInt(4, stud_id);
            pst.setString(5, attd_status);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Attendance Successfully Encoded.", "NOTICE" ,JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Year and Block does not match the record for the Student ID.", "NOTICE" ,JOptionPane.PLAIN_MESSAGE);
        } catch (ClassNotFoundException e) { 
            e.printStackTrace();    
            throw new RuntimeException("Failed to load MySQL JDBC driver");
        } finally {                             
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (sqlConn != null) sqlConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    // **Grade
    public String getGradeData(String subj_code, int yrlvl, int blk, javax.swing.JTable table){ // search btn
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConnect + db_name, username, pass);
            String sqlcmd = "SELECT * FROM grade WHERE subj_code = ? AND yrlvl = ? AND blk = ?;"; // subj_code
            pst = sqlConn.prepareStatement(sqlcmd);
            
            pst.setString(1, subj_code);
            pst.setInt(2, yrlvl);
            pst.setInt(3, blk);
            rs = pst.executeQuery();
            ResultSetMetaData stData = rs.getMetaData();
            
            int q = stData.getColumnCount();
            
            DefaultTableModel RecordTable = (DefaultTableModel) table.getModel();
            RecordTable.setRowCount(0);
            
            while (rs.next()){
                Vector columnData = new Vector();
                
                for (int i=1; i <= q; i++){
                    columnData.add(rs.getString("subj_code"));
                    columnData.add(rs.getString("yrlvl"));
                    columnData.add(rs.getString("blk"));
                    columnData.add(rs.getString("stud_id"));
                    columnData.add(rs.getString("subj_grade"));
                }       
                RecordTable.addRow(columnData);
            }
            
            if (rs.next()) {
//                return rs.getString(data_req); display
            } 
            
        } catch (SQLException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException e) { 
            e.printStackTrace();    
            throw new RuntimeException("Failed to load MySQL JDBC driver");
        } finally {                             
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (sqlConn != null) sqlConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    
    public void encodeGrade(String subj_code, int yrlvl, int blk, int stud_id, double subj_grade){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConnect + db_name, username, pass);
            String sqlcmd = "INSERT INTO grade VALUES( " + 
                            "?, ?, ?, ?, ?);";
            pst = sqlConn.prepareStatement(sqlcmd);
            
            pst.setString(1, subj_code);
            pst.setInt(2, yrlvl);
            pst.setInt(3, blk);
            pst.setInt(4, stud_id);
            pst.setDouble(5, subj_grade);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Grade SUCCESSFULLY Encoded.", "NOTICE" ,JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Year and Block does not match the record for the Student ID.", "NOTICE" ,JOptionPane.PLAIN_MESSAGE);
        } catch (ClassNotFoundException e) { 
            e.printStackTrace();    
            throw new RuntimeException("Failed to load MySQL JDBC driver");
        } finally {                             
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (sqlConn != null) sqlConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void updateGrade(String subj_code, int yrlvl, int blk, int stud_id, double subj_grade){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConnect + db_name, username, pass);
            String sqlcmd = "UPDATE grade " +
                            "SET subj_code = ?, " +
                            "yrlvl = ?, " +
                            "blk = ?, " +
                            "stud_id = ?, " +
                            "subj_grade = ? " +
                            "WHERE stud_id = ?;";
            pst = sqlConn.prepareStatement(sqlcmd);
            
            pst.setString(1, subj_code);
            pst.setInt(2, yrlvl);
            pst.setInt(3, blk);
            pst.setInt(4, stud_id);
            pst.setDouble(5, subj_grade);
            pst.setInt(6, stud_id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Grade SUCCESSFULLY Updated for " + stud_id + ".", "NOTICE" ,JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Year and Block does not match the record for the Student ID.", "NOTICE" ,JOptionPane.PLAIN_MESSAGE);
        } catch (ClassNotFoundException e) { 
            e.printStackTrace();    
            throw new RuntimeException("Failed to load MySQL JDBC driver");
        } finally {                             
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (sqlConn != null) sqlConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void deleteGrade (int stud_id){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConnect + db_name, username, pass);
            String sqlcmd = "DELETE FROM grade WHERE stud_id = ?;";
            pst = sqlConn.prepareStatement(sqlcmd);
            
            pst.setInt(1, stud_id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Grade Successfully Deleted.", "NOTICE" ,JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Invalid Student ID.", "NOTICE" ,JOptionPane.PLAIN_MESSAGE);
        } catch (ClassNotFoundException e) { 
            e.printStackTrace();    
            throw new RuntimeException("Failed to load MySQL JDBC driver");
        } finally {                             
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (sqlConn != null) sqlConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    // **Student Info
    public boolean showStudInfo(int studid, 
            javax.swing.JTextField stud_id, 
            javax.swing.JTextField stud_username, 
            javax.swing.JTextField stud_name,
            javax.swing.JTextField stud_email,
            javax.swing.JTextField stud_contact,
            javax.swing.JTextField stud_birth,
            javax.swing.JTextField stud_college,
            javax.swing.JTextField stud_crs,
            javax.swing.JTextField stud_type,
            javax.swing.JTextField stud_status,
            javax.swing.JTextField stud_yrlvl,
            javax.swing.JTextField stud_blk){
        boolean isValid = false; 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConnect + db_name, username, pass);
            String sqlcmd = "SELECT * FROM studentinfo WHERE stud_id = ?;"; // subj_code
            pst = sqlConn.prepareStatement(sqlcmd);
            
            pst.setInt(1, studid);
            rs = pst.executeQuery();
            
            if (rs.next()) {
                isValid = true;
                stud_id.setText(rs.getString("stud_id"));
                stud_username.setText(rs.getString("stud_username"));
                stud_name.setText(rs.getString("stud_name"));
                stud_email.setText(rs.getString("stud_email"));
                stud_contact.setText(rs.getString("stud_contact"));
                stud_birth.setText(rs.getString("stud_birth"));
                stud_college.setText(rs.getString("stud_college"));
                stud_crs.setText(rs.getString("stud_crs"));
                stud_type.setText(rs.getString("stud_type"));
                stud_status.setText(rs.getString("stud_status"));
                stud_yrlvl.setText(rs.getString("yrlvl"));
                stud_blk.setText(rs.getString("blk"));
            } 
        } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("SIKE");
        } catch (ClassNotFoundException e) { 
            e.printStackTrace();    
            throw new RuntimeException("Failed to load MySQL JDBC driver");
        } finally {                             
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (sqlConn != null) sqlConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isValid;
    }
    
    // DASHBOARD [STUDENT]
    public void getStudUser(int stud_id, javax.swing.JLabel user){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConnect + db_name, username, pass);
            String sqlcmd = "SELECT * FROM studentinfo WHERE stud_id = ?;"; // subj_code
            pst = sqlConn.prepareStatement(sqlcmd);
            
            pst.setInt(1, stud_id);
            rs = pst.executeQuery();
            
            if (rs.next()) {
                user.setText(rs.getString("stud_username"));
            } 
            
        } catch (SQLException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException e) { 
            e.printStackTrace();    
            throw new RuntimeException("Failed to load MySQL JDBC driver");
        } finally {                             
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (sqlConn != null) sqlConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    // **Profile
    public String getStudProf(int stud_id, String data_req){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConnect + db_name, username, pass);
            String sqlcmd = "SELECT * FROM studentinfo WHERE stud_id = ?;";
            pst = sqlConn.prepareStatement(sqlcmd);
            
            pst.setInt(1, stud_id);
            rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getString(data_req);
            } 
            
        } catch (SQLException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException e) { 
            e.printStackTrace();    
            throw new RuntimeException("Failed to load MySQL JDBC driver");
        } finally {                             
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (sqlConn != null) sqlConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    
    public void updateStudProf(int stud_id, 
            String stud_username, 
            String stud_name, 
            String stud_email, 
            String stud_contact, 
            String stud_birth){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConnect + db_name, username, pass);
            String sqlcmd = "UPDATE studentinfo " + 
                            "SET stud_username = ?, " +
                            "stud_name = ?, " +
                            "stud_email = ?, " +
                            "stud_contact = ?, " +
                            "stud_birth = ? " +
                            "WHERE stud_id = ?;";
            pst = sqlConn.prepareStatement(sqlcmd);
            
            pst.setString(1, stud_username);
            pst.setString(2, stud_name);
            pst.setString(3, stud_email);
            pst.setString(4, stud_contact);
            pst.setString(5, stud_birth);
            pst.setInt(6, stud_id);
            pst.executeUpdate();

        } catch (SQLException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException e) { 
            e.printStackTrace();    
            throw new RuntimeException("Failed to load MySQL JDBC driver");
        } finally {                             
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (sqlConn != null) sqlConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    // **attendance
    public String getStudAttd(int stud_id, javax.swing.JTable table){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConnect + db_name, username, pass);
            String sqlcmd = "SELECT * FROM attendance WHERE stud_id = ?;";
            pst = sqlConn.prepareStatement(sqlcmd);
            
            pst.setInt(1, stud_id);
            rs = pst.executeQuery();
            ResultSetMetaData stData = rs.getMetaData();
            
            int q = stData.getColumnCount();
            
            DefaultTableModel RecordTable = (DefaultTableModel) table.getModel();
            RecordTable.setRowCount(0);
            
            while (rs.next()){
                Vector columnData = new Vector();
                
                for (int i=1; i <= q; i++){
                    columnData.add(rs.getString("subj_code"));
                    columnData.add(rs.getString("attd_datetime"));
                    columnData.add(rs.getString("attd_status"));
                }       
                RecordTable.addRow(columnData);
            }
            
            if (rs.next()) {
//                return rs.getString(data_req); display
            } 
            
        } catch (SQLException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException e) { 
            e.printStackTrace();    
            throw new RuntimeException("Failed to load MySQL JDBC driver");
        } finally {                             
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (sqlConn != null) sqlConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public String getStudGrade(int stud_id, javax.swing.JTable table){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConnect + db_name, username, pass);
            String sqlcmd = "SELECT * FROM grade WHERE stud_id = ?;";
            pst = sqlConn.prepareStatement(sqlcmd);
            
            pst.setInt(1, stud_id);
            rs = pst.executeQuery();
            ResultSetMetaData stData = rs.getMetaData();
            
            int q = stData.getColumnCount();
            
            DefaultTableModel RecordTable = (DefaultTableModel) table.getModel();
            RecordTable.setRowCount(0);
            
            while (rs.next()){
                Vector columnData = new Vector();
                
                for (int i=1; i <= q; i++){
                    columnData.add(rs.getString("subj_code"));
                    columnData.add(rs.getString("subj_grade"));
                }       
                RecordTable.addRow(columnData);
            }
            
            if (rs.next()) {
//                return rs.getString(data_req); display
            } 
            
        } catch (SQLException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException e) { 
            e.printStackTrace();    
            throw new RuntimeException("Failed to load MySQL JDBC driver");
        } finally {                             
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (sqlConn != null) sqlConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    
}

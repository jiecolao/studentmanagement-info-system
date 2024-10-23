package com.plm.smis;

import com.plm.smis.frames.*;
import com.plm.smis.database.Database;

public class Main {
    
    // LOGINS AND SIGNUPS
    static LoginAdmin LA = new LoginAdmin();
//    static LoginStudent LS = new LoginStudent();
//    static DashboardStudent DS = new DashboardStudent(0);
    
//    static SignupAdmin SA = new SignupAdmin();
//    static SignupStudent SS = new SignupStudent();
    
    // DATABASE
    static Database db = new Database();
    
    public static void main(String[] args) {
    /*  AFTER RUNNING THIS FILE ONCE, ICOMMENT MO YUNG db.createDB 
        PARA HINDI MAGKAERROR SA PAGGAWA NG PREMADE DATAS SA DATABASE NATIN
        
        NOTE: Wag mo kalimutan palitan yung PASSWORD sa Database.java
    */
        
//        db.createDB();
        LA.setVisible(true);
    }
}

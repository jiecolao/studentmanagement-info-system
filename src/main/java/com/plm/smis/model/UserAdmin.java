package com.plm.smis.model;

public class UserAdmin {
    int admin_id = 0;
    
    public UserAdmin(int admin_id){
        this.admin_id = admin_id;
    }
    
    // ===== METHODS PARA MAKUHA VALUES =====
    public void setID(int id){
        this.admin_id = id;
    }
    
    public int getID(){
        return admin_id;
    }
    
}

package com.plm.smis.model;

public class UserStudent {
    private final int stud_id;
    
    public UserStudent(int stud_id){
        this.stud_id = stud_id;
    }
    
    // ===== METHODS PARA MAKUHA VALUES =====
    public int getID(){
        return stud_id;
    }
    
    
}

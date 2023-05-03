package com.kgisl.vote;

public class Admin {
    protected String admin_email;
    protected String admin_password;
    public Admin(String admin_email, String admin_password) {
        this.admin_email = admin_email;
        this.admin_password = admin_password;
    }
    public String getAdmin_email() {
        return admin_email;
    }
    public void setAdmin_email(String admin_email) {
        this.admin_email = admin_email;
    }
    public String getAdmin_password() {
        return admin_password;
    }
    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    
}

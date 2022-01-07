package com.example.DCOD3;

public class sellers {

    private String fname;
    private String maill;
    private String user;
    private String pass;

    public sellers(){

    }

    public sellers(String fname, String maill, String user, String pass) {
        this.fname = fname;
        this.maill = maill;
        this.user = user;
        this.user = pass;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMaill() {
        return maill;
    }

    public void setMaill(String maill) {
        this.maill = maill;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}

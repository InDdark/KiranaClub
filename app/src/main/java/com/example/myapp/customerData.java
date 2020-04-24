package com.example.myapp;

import java.util.Date;

public class customerData {

    private String userName;
    private String address;
    private String userEmail;
   private String userPass;
   // private Date DOB;
    private  String logIN;

    public customerData() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }
/*
    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }
 */
    public String getLogIN() {
        return logIN;
    }

    public void setLogIN(String logIN) {
        this.logIN = logIN;
    }
}

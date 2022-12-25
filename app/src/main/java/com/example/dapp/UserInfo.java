package com.example.dapp;

public class UserInfo {
    private String Name;
    private String Phone_Number;
    private String Ambulance_Number;
    private String Email;
    private String Ambulance_type;
    private String Onoffduty;


    public UserInfo(){}

    public UserInfo(String name, String phone_Number, String ambulance_Number, String email, String ambulance_type, String onoffduty) {
        Name = name;
        Phone_Number = phone_Number;
        Ambulance_Number = ambulance_Number;
        Email = email;
        Ambulance_type = ambulance_type;
        Onoffduty = onoffduty;
    }

    public String getOnoffduty() {
        return Onoffduty;
    }

    public void setOnoffduty(String onoffduty) {
        Onoffduty = onoffduty;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        Phone_Number = phone_Number;
    }

    public String getAmbulance_Number() {
        return Ambulance_Number;
    }

    public void setAmbulance_Number(String ambulance_Number) {
        Ambulance_Number = ambulance_Number;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAmbulance_type() {
        return Ambulance_type;
    }

    public void setAmbulance_type(String ambulance_type) {
        Ambulance_type = ambulance_type;
    }
}

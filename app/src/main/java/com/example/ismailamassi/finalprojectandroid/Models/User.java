package com.example.ismailamassi.finalprojectandroid.Models;

import com.example.ismailamassi.finalprojectandroid.Control.SystemControl;

import java.util.Date;

public abstract class User {
    private String id;
    private String name;
    private String photoUrl;
    private int role;
    private Date dob;
    private String email;
    private String password;
    private String phoneNumber;

    public User(String id, String name, int role, Date dob, String email, String password, String phoneNumber, String photoUrl) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.dob = dob;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.photoUrl = photoUrl;
        SystemControl.allUsers.add(this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}

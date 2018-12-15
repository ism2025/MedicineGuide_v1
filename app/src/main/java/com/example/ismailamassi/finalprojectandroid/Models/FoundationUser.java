package com.example.ismailamassi.finalprojectandroid.Models;

import com.example.ismailamassi.finalprojectandroid.Control.SystemControl;
import com.example.ismailamassi.finalprojectandroid.Helper.Constants;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class FoundationUser extends User implements Serializable {


    private String location;
    private int registrationType;
    private int remainingDay;

    private ArrayList<DoctorUser> foundationDoctor;
    private Date startDate;
    private Date expiryDate;

    int id;

    /*
    private static int count = 1;
    private String yearSplit;
    private String year = Calendar.getInstance().get(Calendar.YEAR) + "";*/

    public FoundationUser(int id, String name, String email, String password, String phoneNumber, int role, String dob, String photoUrl) {
        super(id, name, email, password, phoneNumber, role, "", photoUrl);
        foundationDoctor = new ArrayList<>();
        SystemControl.allFoundationUsers.add(this);
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getRegistrationType() {
        return registrationType;
    }

    public void setRegistrationType(int registrationType) {
        this.registrationType = registrationType;
    }

    public int getRemainingDay() {
        return remainingDay;
    }

    public void setRemainingDay(int remainingDay) {
        this.remainingDay = remainingDay;
    }

    public ArrayList<DoctorUser> getFoundationDoctor() {
        return foundationDoctor;
    }

    public void setFoundationDoctor(ArrayList<DoctorUser> foundationDoctor) {
        this.foundationDoctor = foundationDoctor;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}

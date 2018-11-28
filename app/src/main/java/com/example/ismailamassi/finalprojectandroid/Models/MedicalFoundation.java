package com.example.ismailamassi.finalprojectandroid.Models;

import com.example.ismailamassi.finalprojectandroid.Control.SystemControl;

import java.util.ArrayList;
import java.util.Date;

public class MedicalFoundation extends User {


    private String location;
    private int registrationType;
    private int remainingDay;

    private ArrayList<DoctorUser> foundationDoctor;
    private Date startDate;
    private Date expiryDate;


    public MedicalFoundation(String id, String name, int role, Date dob, String email, String password, String phoneNumber, String photoUrl) {
        super(id, name, role, dob, email, password, phoneNumber, photoUrl);
        this.setLocation(location);
        foundationDoctor = new ArrayList<>();
        SystemControl.allMedicalFoundations.add(this);
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

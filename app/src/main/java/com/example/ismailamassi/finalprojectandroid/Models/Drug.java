package com.example.ismailamassi.finalprojectandroid.Models;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.ArrayList;

public class Drug implements Serializable {
    private int id;

    private DoctorUser doctor;
    private PatientUser patient;
    private Medicine medicine;
    private String dayOfWeek;

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    private String photoUrl;
    private String DrugType;
    private int drugQuantity;
    private boolean isTake;

    public Drug(int id, DoctorUser doctor, PatientUser patient, Medicine medicine, String dayOfWeek, String drugType, int drugQuantity) {
        this.setId(id);
        this.doctor = doctor;
        this.patient = patient;
        this.medicine = medicine;
        this.dayOfWeek = dayOfWeek;
        DrugType = drugType;
        this.drugQuantity = drugQuantity;
        patient.addDrug(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DoctorUser getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorUser doctor) {
        this.doctor = doctor;
    }

    public PatientUser getPatient() {
        return patient;
    }

    public void setPatient(PatientUser patient) {
        this.patient = patient;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getDrugType() {
        return DrugType;
    }

    public void setDrugType(String drugType) {
        DrugType = drugType;
    }

    public int getDrugQuantity() {
        return drugQuantity;
    }

    public void setDrugQuantity(int drugQuantity) {
        this.drugQuantity = drugQuantity;
    }

    public boolean isTake() {
        return isTake;
    }

    public void setTake(boolean take) {
        isTake = take;
    }
}

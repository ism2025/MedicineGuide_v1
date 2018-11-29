package com.example.ismailamassi.finalprojectandroid.Models;

import com.example.ismailamassi.finalprojectandroid.Control.SystemControl;

import java.util.ArrayList;
import java.util.Date;

public class DoctorUser extends User {
    private ArrayList<PatientUser> DoctorPatients;
    private float doctorRate;
    private MedicalFoundation medicalFoundation;

    public DoctorUser( String name, String email, String password, String phoneNumber, int role, Date dob, String photoUrl) {
        super(name, email, password, phoneNumber, role, dob, photoUrl);
        this.setId("");
        DoctorPatients = new ArrayList<>();
        SystemControl.allDoctors.add(this);
    }


    public ArrayList<PatientUser> getDoctorPatients() {
        return DoctorPatients;
    }

    public void setDoctorPatients(ArrayList<PatientUser> doctorPatients) {
        this.DoctorPatients = doctorPatients;
    }

    public float getDoctorRate() {
        return doctorRate;
    }

    public void setDoctorRate(float doctorRate) {
        this.doctorRate = doctorRate;
    }

    public MedicalFoundation getMedicalFoundation() {
        return medicalFoundation;
    }

    public void setMedicalFoundation(MedicalFoundation medicalFoundation) {
        this.medicalFoundation = medicalFoundation;
    }
}

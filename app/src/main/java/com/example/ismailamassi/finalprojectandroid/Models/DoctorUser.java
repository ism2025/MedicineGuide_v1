package com.example.ismailamassi.finalprojectandroid.Models;

import com.example.ismailamassi.finalprojectandroid.Control.SystemControl;
import com.example.ismailamassi.finalprojectandroid.Helper.Constants;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DoctorUser extends User implements Serializable {
    private ArrayList<PatientUser> DoctorPatients;
    private float doctorRate;
    private MedicalFoundation medicalFoundation;

    private static int count = 1;
    private String yearSplit;
    private String year = Calendar.getInstance().get(Calendar.YEAR) + "";

    public DoctorUser( String name, String email, String password, String phoneNumber, int role, Date dob, String photoUrl) {
        super(name, email, password, phoneNumber, role, dob, photoUrl);
        this.setId("");
        yearSplit = year.substring(2, 4);
        if (role == Constants.DOCTOR_ID) {
            if (count <= 99999) {
                String countWithZero = String.format(Locale.CANADA,"%04d", count);
                this.setId(Constants.DOCTOR_ID + yearSplit + countWithZero);
                count++;
            } else if (count > 99999) {
                String countWithZero = String.format(Locale.CANADA,"%05d", count);
                this.setId(Constants.DOCTOR_ID + yearSplit + countWithZero);
                count++;
            }
        }
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

package com.example.ismailamassi.finalprojectandroid.Models;

import com.example.ismailamassi.finalprojectandroid.Control.SystemControl;

import java.util.ArrayList;
import java.util.Date;

public class PatientUser extends User {
    private int pWeight;
    private ArrayList<Medicine> medicines;
    private ArrayList<Diseases> diseases;
    private ArrayList<DoctorUser> patientDoctor;

    public PatientUser( String name, String email, String password, String phoneNumber, int role, Date dob, String photoUrl) {
        super(name, email, password, phoneNumber, role, dob, photoUrl);
        this.setpWeight(pWeight);
        this.setId("");
        medicines = new ArrayList<>();
        diseases = new ArrayList<>();
        patientDoctor = new ArrayList<>();
        SystemControl.allPatients.add(this);
    }

    public int getpWeight() {
        return pWeight;
    }

    public void setpWeight(int pWeight) {
        this.pWeight = pWeight;
    }

    public ArrayList<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(ArrayList<Medicine> medicines) {
        this.medicines = medicines;
    }

    public ArrayList<Diseases> getDiseases() {
        return diseases;
    }

    public void setDiseases(ArrayList<Diseases> diseases) {
        this.diseases = diseases;
    }

    public ArrayList<DoctorUser> getPatientDoctor() {
        return patientDoctor;
    }

    public void setPatientDoctor(ArrayList<DoctorUser> patientDoctor) {
        this.patientDoctor = patientDoctor;
    }
}

package com.example.ismailamassi.finalprojectandroid.Models;

import android.widget.TextView;

import com.example.ismailamassi.finalprojectandroid.Control.SystemControl;
import com.example.ismailamassi.finalprojectandroid.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class PatientUser extends User {
    private int pWeight;
    private ArrayList<Medicine> medicines;
    private ArrayList<Diseases> diseases;
    private ArrayList<DoctorUser> patientDoctor;

    String id;
    static int count = 1;
    String year = Calendar.getInstance().get(Calendar.YEAR) + "";
    String yearSplit = year.substring(2, 4);


    public PatientUser(String name, String email, String password, String phoneNumber, int role, Date dob, String photoUrl) {
        super(name, email, password, phoneNumber, role, dob, photoUrl);
        this.setpWeight(pWeight);
        if (count < 99999) {
            String countWithZero = String.format("%04d", count);
            id = role + yearSplit + countWithZero;
            count++;
        }
        this.setId(id);
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

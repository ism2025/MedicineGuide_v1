package com.example.ismailamassi.finalprojectandroid.Models;

import android.widget.TextView;

import com.example.ismailamassi.finalprojectandroid.Control.SystemControl;
import com.example.ismailamassi.finalprojectandroid.Helper.Constants;
import com.example.ismailamassi.finalprojectandroid.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class PatientUser extends User implements Serializable {
    private int pWeight;
    private ArrayList<Drug> drugs;
    private ArrayList<Medicine> medicines;
    private ArrayList<Diseases> diseases;
    private ArrayList<DoctorUser> patientDoctor;
    String id;

    private static int count = 1;
    private String yearSplit;
    private String year = Calendar.getInstance().get(Calendar.YEAR) + "";

    public PatientUser(String name, String email, String password, String phoneNumber, int role, Date dob, String photoUrl) {
        super(name, email, password, phoneNumber, role, dob, photoUrl);
        this.setpWeight(pWeight);
        yearSplit = year.substring(2, 4);
        if (role == Constants.PATIENT_ACCOUNT) {
            if (count <= 99999) {
                String countWithZero = String.format(Locale.CANADA, "%04d", count);
                this.setId(Constants.PATIENT_ACCOUNT + yearSplit + countWithZero);
                count++;
            } else if (count > 99999) {
                String countWithZero = String.format(Locale.CANADA, "%05d", count);
                this.setId(Constants.PATIENT_ACCOUNT + yearSplit + countWithZero);
                count++;
            }
        }
        drugs = new ArrayList<>();
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

    public ArrayList<Drug> getDrugs() {
        return drugs;
    }

    public void addDrug(Drug drug) {
        this.drugs.add(drug);
    }
}

package com.example.ismailamassi.finalprojectandroid.Models;

import com.example.ismailamassi.finalprojectandroid.Control.SystemControl;
import com.example.ismailamassi.finalprojectandroid.Helper.Constants;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class StudentUser extends User implements Serializable {
    private String educationalFoundation;
    private ArrayList<Medicine> savesMedicine;

    private String year = Calendar.getInstance().get(Calendar.YEAR) + "";

    public StudentUser(int id, String name, String email, String password, String phoneNumber, int role, String dob, String photoUrl) {
        super(id, name, email, password, phoneNumber, role, dob, photoUrl);
        this.setEducationalFoundation(educationalFoundation);
        savesMedicine = new ArrayList<>();
        SystemControl.allStudents.add(this);
    }


    public ArrayList<Medicine> getSavesMedicine() {
        return savesMedicine;
    }

    public void setSavesMedicine(ArrayList<Medicine> savesMedicine) {
        this.savesMedicine = savesMedicine;
    }

    public String getEducationalFoundation() {
        return educationalFoundation;
    }

    public void setEducationalFoundation(String educationalInstitution) {
        this.educationalFoundation = educationalInstitution;
    }
}


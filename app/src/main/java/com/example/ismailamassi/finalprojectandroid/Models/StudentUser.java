package com.example.ismailamassi.finalprojectandroid.Models;

import com.example.ismailamassi.finalprojectandroid.Control.SystemControl;

import java.util.Date;

public class StudentUser extends User {
    private String educationalFoundation;

    public StudentUser(String name, String email, String password, String phoneNumber, int role, Date dob, String photoUrl) {
        super(name, email, password, phoneNumber, role, dob, photoUrl);
        this.setId("");
        this.setEducationalFoundation(educationalFoundation);
        SystemControl.allStudents.add(this);
    }


    public String getEducationalFoundation() {
        return educationalFoundation;
    }

    public void setEducationalFoundation(String educationalInstitution) {
        this.educationalFoundation = educationalInstitution;
    }
}

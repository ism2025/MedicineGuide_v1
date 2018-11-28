package com.example.ismailamassi.finalprojectandroid.Models;

import com.example.ismailamassi.finalprojectandroid.Control.SystemControl;

import java.util.Date;

public class StudentUser extends User {
    private String educationalFoundation;

    public StudentUser(String id, String name, int role, Date dob, String email, String password, String phoneNumber, String photoUrl) {
        super(id, name, role, dob, email, password, phoneNumber, photoUrl);
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

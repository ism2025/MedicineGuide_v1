package com.example.ismailamassi.finalprojectandroid.Models;

import com.example.ismailamassi.finalprojectandroid.Helper.Constants;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class Medicine implements Serializable {
    private String id;
    private String name;
    private ArrayList<String> traditionalNames;
    private MedicineGroup medicineGroup;
    private MedicineDepartment medicineDepartment;
    private String about;
    private String uses;
    private String sideEffect;
    private static int count = 1;
    private String yearSplit;
    private String year = Calendar.getInstance().get(Calendar.YEAR) + "";

    public Medicine(String name, String about, String uses, String sideEffect, MedicineGroup group, MedicineDepartment department) {
        yearSplit = year.substring(2, 4);
        if (count <= 99999) {
            String countWithZero = String.format(Locale.CANADA, "%04d", count);
            this.setId(Constants.MEDICINE_ID + yearSplit + countWithZero);
            count++;
        } else if (count > 99999) {
            String countWithZero = String.format(Locale.CANADA, "%05d", count);
            this.setId(Constants.MEDICINE_ID + yearSplit + countWithZero);
            count++;
        }
        this.setName(name);
        this.setMedicineGroup(group);
        this.setMedicineDepartment(department);
        this.setAbout(about);
        this.setUses(uses);
        this.setSideEffect(sideEffect);
        group.setGroupItem(this);
        department.addDepartmentItem(this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MedicineGroup getMedicineGroup() {
        return medicineGroup;
    }

    public void setMedicineGroup(MedicineGroup medicineGroup) {
        this.medicineGroup = medicineGroup;
    }

    public MedicineDepartment getMedicineDepartment() {
        return medicineDepartment;
    }

    public void setMedicineDepartment(MedicineDepartment medicineDepartment) {
        this.medicineDepartment = medicineDepartment;
    }

    public ArrayList<String> getTraditionalNames() {
        return traditionalNames;
    }

    public void setTraditionalNames(ArrayList<String> traditionalNames) {
        this.traditionalNames = traditionalNames;
    }

    public void setTraditionalName(String traditionalName) {
        this.traditionalNames.add(traditionalName);
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getUses() {
        return uses;
    }

    public void setUses(String uses) {
        this.uses = uses;
    }

    public String getSideEffect() {
        return sideEffect;
    }

    public void setSideEffect(String sideEffect) {
        this.sideEffect = sideEffect;
    }
}

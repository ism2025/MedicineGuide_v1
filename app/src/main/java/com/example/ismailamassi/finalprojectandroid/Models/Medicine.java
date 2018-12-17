package com.example.ismailamassi.finalprojectandroid.Models;

import com.example.ismailamassi.finalprojectandroid.Control.SystemControl;
import com.example.ismailamassi.finalprojectandroid.Helper.Constants;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class Medicine implements Serializable {
    private int id;
    private String name;
    private String about;
    private String uses;
    private String photoUrl;
    private String storage;
    private String sideEffect;
    private ArrayList<String> traditionalNames;
    private int medicineGroup;
    private int medicineDepartment;


    private static int count = 1;
    private String yearSplit;

    private String year = Calendar.getInstance().get(Calendar.YEAR) + "";

    public Medicine(int id, String name, String about, String uses, String sideEffect,String photoUrl,String storage, int group, int department) {
        this.setId(id);
        this.setName(name);
        this.setMedicineGroup(group);
        this.setMedicineDepartment(department);
        this.setAbout(about);
        this.setUses(uses);
        this.setSideEffect(sideEffect);
        this.setStorage(storage);
        this.setPhotoUrl(photoUrl);
        traditionalNames = new ArrayList<>();
//        group.setGroupItem(this);
//        department.addDepartmentItem(this);
        SystemControl.allMedicine.add(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMedicineGroup() {
        return medicineGroup;
    }

    public void setMedicineGroup(int medicineGroup) {
        this.medicineGroup = medicineGroup;
    }

    public int getMedicineDepartment() {
        return medicineDepartment;
    }

    public void setMedicineDepartment(int medicineDepartment) {
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

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }
}

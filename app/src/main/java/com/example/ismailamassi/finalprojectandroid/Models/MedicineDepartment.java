package com.example.ismailamassi.finalprojectandroid.Models;

import com.example.ismailamassi.finalprojectandroid.Control.SystemControl;
import com.example.ismailamassi.finalprojectandroid.Helper.Constants;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class MedicineDepartment implements Serializable {
    private int id;
    private String name;
    private ArrayList<Medicine> departmentItems;

    public MedicineDepartment(int departmentId, String name) {
        this.setId(departmentId);
        this.setName(name);
        departmentItems = new ArrayList<>();
        SystemControl.allDepartments.add(this);
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

    public ArrayList<Medicine> getDepartmentItems() {
        return departmentItems;
    }

    public void setDepartmentItems(ArrayList<Medicine> departmentItems) {
        this.departmentItems = departmentItems;
    }

    public void addDepartmentItem(Medicine departmentItem) {
        this.departmentItems.add(departmentItem);
    }
}

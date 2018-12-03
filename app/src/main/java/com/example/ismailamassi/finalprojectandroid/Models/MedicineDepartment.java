package com.example.ismailamassi.finalprojectandroid.Models;

import com.example.ismailamassi.finalprojectandroid.Helper.Constants;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class MedicineDepartment {
    private String id;
    private String name;
    private ArrayList<Medicine> departmentItems;

    private static int count = 1;
    private String yearSplit;
    private String year = Calendar.getInstance().get(Calendar.YEAR) + "";

    public MedicineDepartment(String name) {
        yearSplit = year.substring(2, 4);
        if (count <= 99999) {
            String countWithZero = String.format(Locale.CANADA, "%04d", count);
            this.setId(Constants.DEPARTMENT_ID + yearSplit + countWithZero);
            count++;
        } else if (count > 99999) {
            String countWithZero = String.format(Locale.CANADA, "%05d", count);
            this.setId(Constants.DEPARTMENT_ID + yearSplit + countWithZero);
            count++;
        }
        this.setName(name);
        departmentItems = new ArrayList<>();
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

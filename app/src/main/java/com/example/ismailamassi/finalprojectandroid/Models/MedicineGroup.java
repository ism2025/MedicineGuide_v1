package com.example.ismailamassi.finalprojectandroid.Models;

import com.example.ismailamassi.finalprojectandroid.Control.SystemControl;
import com.example.ismailamassi.finalprojectandroid.Helper.Constants;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class MedicineGroup implements Serializable{
    private String id;
    private String name;
    private ArrayList<Medicine> groupItems;

    private static int count = 1;
    private String yearSplit;
    private String year = Calendar.getInstance().get(Calendar.YEAR) + "";

    public MedicineGroup(String name) {
        yearSplit = year.substring(2, 4);
        if (count <= 99999) {
            String countWithZero = String.format(Locale.CANADA, "%04d", count);
            this.setId(Constants.GROUP_ID + yearSplit + countWithZero);
            count++;
        } else if (count > 99999) {
            String countWithZero = String.format(Locale.CANADA, "%05d", count);
            this.setId(Constants.GROUP_ID + yearSplit + countWithZero);
            count++;
        }
        this.setName(name);
        groupItems = new ArrayList<>();
        SystemControl.allGroups.add(this);
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

    public ArrayList<Medicine> getGroupItems() {
        return groupItems;
    }

    public void setGroupItems(ArrayList<Medicine> groupItems) {
        this.groupItems = groupItems;
    }

    public void setGroupItem(Medicine groupItem) {
        this.groupItems.add(groupItem);
    }
}

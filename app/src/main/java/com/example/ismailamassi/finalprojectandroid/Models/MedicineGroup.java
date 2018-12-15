package com.example.ismailamassi.finalprojectandroid.Models;

import com.example.ismailamassi.finalprojectandroid.Control.SystemControl;
import com.example.ismailamassi.finalprojectandroid.Helper.Constants;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class MedicineGroup implements Serializable {
    private int id;
    private String name;
    private ArrayList<Medicine> groupItems;

    private static int count = 1;
    private String yearSplit;
    private String year = Calendar.getInstance().get(Calendar.YEAR) + "";

    public MedicineGroup(int groupId, String name) {
        this.setId(groupId);
        this.setName(name);
        groupItems = new ArrayList<>();
        SystemControl.allGroups.add(this);
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

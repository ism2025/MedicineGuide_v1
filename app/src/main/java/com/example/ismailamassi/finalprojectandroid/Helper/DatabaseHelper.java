package com.example.ismailamassi.finalprojectandroid.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.sql.Date;
import java.util.Calendar;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, Constants.DATABASE_NAME, null, 1);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " +
                Constants.TABLE_FOUNDATION + "(" +
                Constants.COL_FOUND_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                Constants.COL_FOUND_NAME + " varchar(55) ," +
                Constants.COL_FOUND_EMAIL + " varchar(55) ," +
                Constants.COL_FOUND_PASSWORD + " varchar(55) ," +
                Constants.COL_FOUND_PHONE_NUMBER + " varchar(55) ," +
                Constants.COL_FOUND_PHOTO + " varchar(55) ," +
                Constants.COL_FOUND_LOCATION + " varchar(55)" + ")");
        db.execSQL("CREATE TABLE " +
                Constants.TABLE_DOCTOR + "(" +
                Constants.COL_DOCTOR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                Constants.COL_DOCTOR_NAME + " varchar(55) ," +
                Constants.COL_DOCTOR_EMAIL + " varchar(55) ," +
                Constants.COL_DOCTOR_PASSWORD + " varchar(55) ," +
                Constants.COL_DOCTOR_PHONE_NUMBER + " varchar(55) ," +
                Constants.COL_DOCTOR_PHOTO + " varchar(55) ," +
                Constants.COL_DOCTOR_GENDER + " INTEGER," +
                Constants.COL_DOCTOR_RATE + " real ," +
                Constants.COL_DOCTOR_SECTION + " varchar(55) ," +
                Constants.COL_DOCTOR_DOB + " date" + ")");

        db.execSQL("CREATE TABLE " +
                Constants.TABLE_PATIENT + "(" +
                Constants.COL_PATIENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                Constants.COL_PATIENT_NAME + " varchar(55) ," +
                Constants.COL_PATIENT_EMAIL + " varchar(55) ," +
                Constants.COL_PATIENT_PASSWORD + " varchar(55) ," +
                Constants.COL_PATIENT_GENDER + " INTEGER(55) ," +
                Constants.COL_PATIENT_PHOTO + " varchar(55) ," +
                Constants.COL_PATIENT_WEIGHT + " varchar(55) ," +
                Constants.COL_PATIENT_PHONR_NUMBER + " varchar(55) ," +
                Constants.COL_PATIENT_DOB + " date" + ")");


        db.execSQL("CREATE TABLE " +
                Constants.TABLE_DRUG + "(" +
                Constants.COL_DRUG_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                Constants.COL_DRUG_DAYOFWEEK + " varchar(55) ," +
                Constants.COL_DRUG_TYPE + " varchar(55) ," +
                Constants.COL_DRUG_QUANTITY + " INTEGER," +
                Constants.COL_DRUG_ISTAKE + " INTEGER ," +
                "FOREIGN KEY(" + Constants.COL_DRUG_DOCTOR_ID + ") REFERENCES " + Constants.TABLE_DOCTOR + "(" + Constants.COL_DOCTOR_ID + ")," +
                "FOREIGN KEY(" + Constants.COL_DRUG_PATIENT_ID + ") REFERENCES " + Constants.TABLE_PATIENT + "(" + Constants.COL_PATIENT_ID + ")," +
                "FOREIGN KEY(" + Constants.COL_DRUG_MEDICINE_ID + ")  REFERENCES " + Constants.TABLE_MEDICINE + "(" + Constants.COL_MEDICINE_ID + ")" +
                ")");

        db.execSQL("CREATE TABLE " +
                Constants.TABLE_MEDICINE + "(" +
                Constants.COL_MEDICINE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                Constants.COL_MEDICINE_NAME + " varchar(55) ," +
                Constants.COL_MEDICINE_ABOUT + " varchar(55) ," +
                Constants.COL_MEDICINE_USES + " varchar(55)," +
                Constants.COL_MEDICINE_SIDE_EFFECT + " varchar(55)," +
                Constants.COL_MEDICINE_PHOTO + " varchar(55)," +
                Constants.COL_MEDICINE_STORAGE + " varchar(55) ," +
                "FOREIGN KEY(" + Constants.COL_MEDICINE_DEPARTMENT_ID + ") REFERENCES " + Constants.TABLE_DEPARTMENT + "(" + Constants.COL_DEPARTMENT_ID + ")," +
                "FOREIGN KEY(" + Constants.COL_MEDICINE_GROUP_ID + ") REFERENCES " + Constants.TABLE_GROUP + "(" + Constants.COL_GROUP_ID + ")" +
                ")");

        db.execSQL("CREATE TABLE " +
                Constants.TABLE_DEPARTMENT + "(" +
                Constants.COL_DEPARTMENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                Constants.COL_DEPARTMENT_NAME + " varchar(55) " +
                ")");

        db.execSQL("CREATE TABLE " +
                Constants.TABLE_GROUP + "(" +
                Constants.COL_GROUP_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                Constants.COL_GROUP_NAME + " varchar(55) " +
                ")");

        db.execSQL("create table " +
                Constants.TABLE_DOCTOR_PATIENT + "(" +
                Constants.COL_DOCTOR_PATIENT_DOCTOR_ID + " INTEGER REFERENCES " + Constants.TABLE_DOCTOR + "(" + Constants.COL_DOCTOR_ID + ")," +
                Constants.COL_DOCTOR_PATIENT_PATIENT_ID + " INTEGER REFERENCES " + Constants.TABLE_PATIENT + "(" + Constants.COL_PATIENT_ID + ")" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_FOUNDATION);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_DOCTOR);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_DEPARTMENT);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_DOCTOR_PATIENT);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_DRUG);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_PATIENT);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_MEDICINE);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_GROUP);
        onCreate(db);
    }

    public boolean insertToFoundationTable(String foundationName, String foundationEmail, String foundationPassword, String foundationPhoto, String foundationPhoneNumber, String FoundationLocation) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.COL_FOUND_NAME, foundationName);
        values.put(Constants.COL_FOUND_EMAIL, foundationEmail);
        values.put(Constants.COL_FOUND_PASSWORD, foundationPassword);
        values.put(Constants.COL_FOUND_PHONE_NUMBER, foundationPhoneNumber);
        values.put(Constants.COL_FOUND_PHOTO, foundationPhoto);
        values.put(Constants.COL_FOUND_LOCATION, FoundationLocation);
        long result = database.insert(Constants.TABLE_FOUNDATION, null, values);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean insertToDoctorTable(String doctorName, String doctorEmail, String doctorPassword, int doctorGender, String doctorPhotoUrl, String doctorPhoneNumber, float doctorRate, String doctorSection, Date doctorDob) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.COL_DOCTOR_NAME, doctorName);
        values.put(Constants.COL_DOCTOR_EMAIL, doctorEmail);
        values.put(Constants.COL_DOCTOR_PASSWORD, doctorPassword);
        values.put(Constants.COL_DOCTOR_GENDER, doctorGender);
        values.put(Constants.COL_DOCTOR_PHOTO, doctorPhotoUrl);
        values.put(Constants.COL_DOCTOR_PHONE_NUMBER, doctorPhoneNumber);
        values.put(Constants.COL_DOCTOR_RATE, doctorRate);
        values.put(Constants.COL_DOCTOR_SECTION, doctorSection);
        values.put(Constants.COL_DOCTOR_DOB, getDateAsString(doctorDob));
        long result = database.insert(Constants.TABLE_DOCTOR, null, values);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean insertToPatientTable(String patientName, String patientEmail, String patientPassword, int patientGender, String patientPhotoUrl, String patientWeight, String patientPhoneNumber, Date patientDob) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.COL_PATIENT_NAME, patientName);
        values.put(Constants.COL_PATIENT_EMAIL, patientEmail);
        values.put(Constants.COL_PATIENT_PASSWORD, patientPassword);
        values.put(Constants.COL_PATIENT_GENDER, patientGender);
        values.put(Constants.COL_PATIENT_PHOTO, patientPhotoUrl);
        values.put(Constants.COL_PATIENT_WEIGHT, patientWeight);
        values.put(Constants.COL_PATIENT_PHONR_NUMBER, patientPhoneNumber);
        values.put(Constants.COL_DOCTOR_DOB, getDateAsString(patientDob));
        long result = database.insert(Constants.TABLE_PATIENT, null, values);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean insertToMedicineTable(String medicineName, String medicineAbout, String medicineUses, int medicineSideEffect, String medicineStorage, String medicinePhoto, int groubId, int departmentId) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.COL_MEDICINE_NAME, medicineName);
        values.put(Constants.COL_MEDICINE_ABOUT, medicineAbout);
        values.put(Constants.COL_MEDICINE_USES, medicineUses);
        values.put(Constants.COL_MEDICINE_SIDE_EFFECT, medicineSideEffect);
        values.put(Constants.COL_MEDICINE_STORAGE, medicineStorage);
        values.put(Constants.COL_MEDICINE_PHOTO, medicinePhoto);
        values.put(Constants.COL_MEDICINE_DEPARTMENT_ID, departmentId);
        values.put(Constants.COL_MEDICINE_GROUP_ID, groubId);
        long result = database.insert(Constants.TABLE_MEDICINE, null, values);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean insertToGroupTable(String groupName) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.COL_GROUP_NAME, groupName);
        long result = database.insert(Constants.TABLE_GROUP, null, values);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean insertToDepartmentTable(String departmentName) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.COL_DEPARTMENT_NAME, departmentName);
        long result = database.insert(Constants.TABLE_DEPARTMENT, null, values);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean insertToDrugTable(String dayOfWeek, String type, int quantity, int isTake, int doctorId, int patientId, int medicineId) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.COL_DRUG_DAYOFWEEK, dayOfWeek);
        values.put(Constants.COL_DRUG_TYPE, type);
        values.put(Constants.COL_DRUG_QUANTITY, quantity);
        values.put(Constants.COL_DRUG_ISTAKE, isTake);
        values.put(Constants.COL_DRUG_DOCTOR_ID, doctorId);
        values.put(Constants.COL_DRUG_PATIENT_ID, patientId);
        values.put(Constants.COL_DRUG_MEDICINE_ID, medicineId);
        long result = database.insert(Constants.TABLE_DRUG, null, values);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean insertToDoctorPatientTable(int doctorId, int patientId) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.COL_DOCTOR_PATIENT_DOCTOR_ID, doctorId);
        values.put(Constants.COL_DOCTOR_PATIENT_PATIENT_ID, patientId);
        long result = database.insert(Constants.TABLE_DOCTOR_PATIENT, null, values);
        if (result == -1)
            return false;
        else
            return true;
    }

    private String getDateAsString(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return day + "-" + month + "-" + year;
    }

    public Cursor getFromDatabase(String tableName) {
        SQLiteDatabase database = this.getWritableDatabase();
        return database.rawQuery("SELECT * FROM " + tableName, null);
    }

}

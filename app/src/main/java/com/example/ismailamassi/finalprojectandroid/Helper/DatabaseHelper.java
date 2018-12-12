package com.example.ismailamassi.finalprojectandroid.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

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
                Constants.COL_FOUND_LOCATION + " varchar(55)" + ")");
        db.execSQL("CREATE TABLE " +
                Constants.TABLE_DOCTOR + "(" +
                Constants.COL_DOCTOR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                Constants.COL_DOCTOR_NAME + " varchar(55) ," +
                Constants.COL_DOCTOR_EMAIL + " varchar(55) ," +
                Constants.COL_DOCTOR_PASSWORD + " varchar(55) ," +
                Constants.COL_DOCTOR_GENDER + " INTEGER," +
                Constants.COL_DOCTOR_PHOTO + " varchar(55) ," +
                Constants.COL_DOCTOR_PHONE_NUMBER + " varchar(55) ," +
                Constants.COL_DOCTOR_RATE + " real ," +
                Constants.COL_DOCTOR_PHONE_NUMBER + " varchar(55) ," +
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
                "FOREIGN KEY(" + Constants.COL_DRUG_MEDICINE_ID + ") REFERENCES " + Constants.TABLE_MEDICINE + "(" + Constants.COL_MEDICINE_ID + ")" +
                ")");

        db.execSQL("CREATE TABLE " +
                Constants.TABLE_MEDICINE + "(" +
                Constants.COL_MEDICINE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                Constants.COL_MEDICINE_NAME + " varchar(55) ," +
                Constants.COL_MEDICINE_ABOUT + " varchar(55) ," +
                Constants.COL_MEDICINE_USES + " varchar(55)," +
                Constants.COL_MEDICINE_SIDE_EFFECT + " varchar(55)," +
                Constants.COL_MEDICINE_PHOTO + " varchar(55)," +
                Constants.COL_MEDICINE_STORAGE + " varchar(55) " + ")");

        db.execSQL("CREATE TABLE " +
                Constants.TABLE_DEPARTMENT + "(" +
                Constants.COL_DEPARTMENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                Constants.COL_DEPARTMENT_NAME + " varchar(55) ," +
                "FOREIGN KEY(" + Constants.COL_MEDICINE_DEPARTMENT_ID + ") REFERENCES " + Constants.TABLE_DEPARTMENT + "(" + Constants.COL_DEPARTMENT_ID + ")," +
                "FOREIGN KEY(" + Constants.COL_MEDICINE_GROUP_ID + ") REFERENCES " + Constants.TABLE_GROUP + "(" + Constants.COL_GROUP_ID + ")" +
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
        db.execSQL("drop" + db);
        onCreate(db);
    }
}

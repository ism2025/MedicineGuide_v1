package com.example.ismailamassi.finalprojectandroid.Helper;

import com.example.ismailamassi.finalprojectandroid.Models.User;

public class Constants {
    public static final String PREF_NAME = "introSP";
    public static final String ROLE = "role";
    public static final String ID = "id";
    public static final String EMAIL = "email";
    public static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    public static final String IS_SIGN_IN = "IsSignIn";
    public static final String DEPARTMENT_BANDLE = "department";
    public static final String GROUP_BANDLE = "group";
    public static final String MEDICINE_BANDLE = "medicine";
    public static final String DOCTOR_BANDLE = "doctor";
    public static final String FOUNDATION_BANDLE = "foundation";
    public static final int STUDENT_ID = 1;
    public static final int PATIENT_ID = 2;
    public static final int DOCTOR_ID = 3;
    public static final int FOUNDATION_ID = 4;
    public static final int ADMIN_ID = 5;
    public static final int MEDICINE_ID = 6;
    public static final int GROUP_ID = 7;
    public static final int DEPARTMENT_ID = 8;

    public static final String CURRENT_USER = "current_user";
    public static final String FIELD_REQUIRED = "This field is required";
    public static User user = null;
    public static User CURRENT_USER_SIGN_IN = null;

    //DATABASE CONSTANTS
    public static final String DATABASE_NAME = "medicine_guide";
    public static final String TABLE_FOUNDATION = "foundation";
    public static final String TABLE_DOCTOR = "doctor";
    public static final String TABLE_PATIENT = "patient";
    public static final String TABLE_STUDENT = "student";
    public static final String TABLE_MEDICINE = "Medicine";
    public static final String TABLE_DRUG = "drug";
    public static final String TABLE_DOCTOR_PATIENT = "doctor_patient";
    public static final String TABLE_DEPARTMENT = "department";
    public static final String TABLE_GROUP = "group_med";

    //FOUNDATION COLs
    public static final String COL_FOUND_ID = "_id";
    public static final String COL_FOUND_NAME = "name";
    public static final String COL_FOUND_LOCATION = "location";
    public static final String COL_FOUND_PASSWORD = "password";
    public static final String COL_FOUND_EMAIL = "email";
    public static final String COL_FOUND_PHOTO = "photo";
    public static final String COL_FOUND_PHONE_NUMBER = "phoneNumber";

    //DOCTOR COLs
    public static final String COL_DOCTOR_ID = "_id";
    public static final String COL_DOCTOR_NAME = "name";
    public static final String COL_DOCTOR_GENDER = "gender";
    public static final String COL_DOCTOR_DOB = "dob";
    public static final String COL_DOCTOR_EMAIL = "email";
    public static final String COL_DOCTOR_PASSWORD = "password";
    public static final String COL_DOCTOR_PHOTO = "photo";
    public static final String COL_DOCTOR_PHONE_NUMBER = "phoneNumber";
    public static final String COL_DOCTOR_RATE = "rate";
    public static final String COL_DOCTOR_SECTION = "section";
    public static final String COL_DOCTOR_FOUNDATION = "foundation";

    //PATIENT COLs
    public static final String COL_PATIENT_ID = "_id";
    public static final String COL_PATIENT_NAME = "name";
    public static final String COL_PATIENT_GENDER = "gender";
    public static final String COL_PATIENT_DOB = "dob";
    public static final String COL_PATIENT_EMAIL = "email";
    public static final String COL_PATIENT_PASSWORD = "password";
    public static final String COL_PATIENT_PHONR_NUMBER = "phoneNumber";
    public static final String COL_PATIENT_PHOTO = "photo";
    public static final String COL_PATIENT_WEIGHT = "weight";

    //STUDENT COLs
    public static final String COL_STUDENT_ID = "_id";
    public static final String COL_STUDENT_NAME = "name";
    public static final String COL_STUDENT_EMAIL = "email";
    public static final String COL_STUDENT_PASSWORD = "password";
    public static final String COL_STUDENT_PHONR_NUMBER = "phoneNumber";
    public static final String COL_STUDENT_PHOTO = "photo";
    public static final String COL_STUDENT_GENDER = "gender";
    public static final String COL_STUDENT_DOB = "dob";
    public static final String COL_STUDENT_FOUNDATION = "educationFoundation";


    //DRUG COLs
    public static final String COL_DRUG_ID = "_id";
    public static final String COL_DRUG_DAYOFWEEK = "dayOfWeek";
    public static final String COL_DRUG_TYPE = "type";
    public static final String COL_DRUG_QUANTITY = "quantity";
    public static final String COL_DRUG_ISTAKE = "isTake";
    public static final String COL_DRUG_DOCTOR_ID = "doctorId";
    public static final String COL_DRUG_MEDICINE_ID = "medicine_id";
    public static final String COL_DRUG_PATIENT_ID = "patient_id";


    //MEDICINE COLS
    public static final String COL_MEDICINE_ID = "_id";
    public static final String COL_MEDICINE_NAME = "name";
    public static final String COL_MEDICINE_ABOUT = "about";
    public static final String COL_MEDICINE_USES = "uses";
    public static final String COL_MEDICINE_PHOTO = "photo";
    public static final String COL_MEDICINE_STORAGE = "storage";
    public static final String COL_MEDICINE_SIDE_EFFECT = "side_effect";
    public static final String COL_MEDICINE_DEPARTMENT_ID = "department_id";
    public static final String COL_MEDICINE_GROUP_ID = "group_id";

    //DEPARTMENT COLS
    public static final String COL_DEPARTMENT_ID = "_id";
    public static final String COL_DEPARTMENT_NAME = "name";

    //GROUP COLS
    public static final String COL_GROUP_ID = "_id";
    public static final String COL_GROUP_NAME = "name";

    //TABLE_DOCTOR_PATIENT COLs
    public static final String COL_DOCTOR_PATIENT_DOCTOR_ID = "_id_Doctor";
    public static final String COL_DOCTOR_PATIENT_PATIENT_ID = "_id_Patient";


}

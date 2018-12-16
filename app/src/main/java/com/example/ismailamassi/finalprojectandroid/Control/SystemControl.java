package com.example.ismailamassi.finalprojectandroid.Control;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.example.ismailamassi.finalprojectandroid.Activites.DoctorMainActivity;
import com.example.ismailamassi.finalprojectandroid.Activites.FoundationMainActivity;
import com.example.ismailamassi.finalprojectandroid.Activites.PatientMainActivity;
import com.example.ismailamassi.finalprojectandroid.Activites.StudentMainActivity;
import com.example.ismailamassi.finalprojectandroid.Helper.Constants;
import com.example.ismailamassi.finalprojectandroid.Helper.DatabaseHelper;
import com.example.ismailamassi.finalprojectandroid.Models.DoctorUser;
import com.example.ismailamassi.finalprojectandroid.Models.FoundationUser;
import com.example.ismailamassi.finalprojectandroid.Models.Medicine;
import com.example.ismailamassi.finalprojectandroid.Models.MedicineDepartment;
import com.example.ismailamassi.finalprojectandroid.Models.MedicineGroup;
import com.example.ismailamassi.finalprojectandroid.Models.PatientUser;
import com.example.ismailamassi.finalprojectandroid.Models.StudentUser;
import com.example.ismailamassi.finalprojectandroid.Models.User;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

public class SystemControl {
    Context context;

    public void generateData(Context context) {
        DatabaseHelper helper = new DatabaseHelper(context);

        boolean result1 = helper.insertToFoundationTable("التوبة", "mail@mail.com", "123456", "https://api.androidhive.info/images/glide/large/bvs.jpg", "0592182025", "");
        boolean result2 = helper.insertToFoundationTable("الشفاء", "mail@mail.com", "123456", "https://api.androidhive.info/images/glide/large/deadpool.jpg", "0592182025", "");
        boolean result3 = helper.insertToFoundationTable("النصر", "mail@mail.com", "123456", "https://api.androidhive.info/images/glide/large/cacw.jpg", "0592182025", "");
        boolean result4 = helper.insertToFoundationTable("الرنتيسي", "mail@mail.com", "123456", "https://api.androidhive.info/images/glide/large/bourne.jpg", "0592182025", "");
        boolean result5 = helper.insertToFoundationTable("العودة", "mail@mail.com", "123456", "https://api.androidhive.info/images/glide/large/squad.jpg", "0592182025", "");


        Cursor foundations = helper.getFromDatabase(Constants.TABLE_FOUNDATION);
        if (foundations.getCount() != 0) {
            while (foundations.moveToNext()) {
                int foundationId = foundations.getInt(0);
                String foundationName = foundations.getString(1);
                String foundationEmail = foundations.getString(2);
                String foundationPassword = foundations.getString(3);
                String foundationPhoneNumber = foundations.getString(4);
                String foundationPhoto = foundations.getString(5);
                String foundationLoaction = foundations.getString(6);
                new FoundationUser(foundationId, foundationName, foundationEmail, foundationPassword, foundationPhoneNumber, Constants.FOUNDATION_ID, null, foundationPhoto)
                        .setLocation(foundationLoaction);
            }
        }
        Cursor doctors = helper.getFromDatabase(Constants.TABLE_DOCTOR);
        if (doctors.getCount() != 0) {
            while (doctors.moveToNext()) {
                int doctorId = doctors.getInt(0);
                String doctorName = doctors.getString(1);
                String doctorEmail = doctors.getString(2);
                String doctorPassword = doctors.getString(3);
                String doctorPhoneNumber = doctors.getString(4);
                String doctorPhoto = doctors.getString(5);
                int doctorGender = doctors.getInt(6);
                float doctorRate = doctors.getFloat(7);
                String doctorSection = doctors.getString(8);
                String doctorDob = doctors.getString(9);
                DoctorUser doctorUser = new DoctorUser(doctorId, doctorName, doctorEmail, doctorPassword, doctorPhoneNumber, Constants.DOCTOR_ID, doctorDob, doctorPhoto);
                doctorUser.setGender(doctorGender);
                doctorUser.setDoctorRate(doctorRate);
                doctorUser.setSection(doctorSection);
            }
        }

    }

    public static ArrayList<User> allUsers = new ArrayList<>();
    public static ArrayList<PatientUser> allPatients = new ArrayList<>();
    public static ArrayList<StudentUser> allStudents = new ArrayList<>();
    public static ArrayList<DoctorUser> allDoctors = new ArrayList<>();
    public static ArrayList<FoundationUser> allFoundationUsers = new ArrayList<>();
    public static ArrayList<MedicineGroup> allGroups = new ArrayList<>();
    public static ArrayList<MedicineDepartment> allDepartments = new ArrayList<>();
    public static ArrayList<Medicine> allMedicine = new ArrayList<>();

    private static Intent doctorMainActivityIntent;
    private static Intent foundationMainActivityIntent;
    private static Intent patientMainActivityIntent;
    private static Intent studentMainActivityIntent;
    private static Intent adminMainActivityIntent;

    public static User getUserByEmail(String email) {
        for (User user : allUsers) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                Constants.user = user;
                break;
            }
        }
        return Constants.user;
    }

    public static User getUserById(int id) {
        User tmp = null;
        for (User user : allUsers) {
            if (user.getId() == id) {
                tmp = user;
                break;
            }
        }
        return tmp;
    }

    public static User SigninOperation(String email, String password) {
        User tmp = getUserByEmail(email);
        if (tmp != null && tmp.getPassword().equals(password)) {
            return tmp;
        } else
            return null;
    }


    public static void openMainActicityByUserType(Context context, @NonNull User user) {
        studentMainActivityIntent = new Intent(context, StudentMainActivity.class);
        patientMainActivityIntent = new Intent(context, PatientMainActivity.class);
        doctorMainActivityIntent = new Intent(context, DoctorMainActivity.class);
        foundationMainActivityIntent = new Intent(context, FoundationMainActivity.class);
        adminMainActivityIntent = new Intent(context, FoundationMainActivity.class);

//        Bundle bundle = new Bundle();
//        bundle.putSerializable(Constants.CURRENT_USER, user);
//        try {
        switch (user.getRole()) {
            case Constants.STUDENT_ID:
                studentMainActivityIntent.putExtra(Constants.CURRENT_USER, user);
                context.startActivity(studentMainActivityIntent);
                break;
            case Constants.PATIENT_ID:
                patientMainActivityIntent.putExtra(Constants.CURRENT_USER, user);
                context.startActivity(patientMainActivityIntent);
                break;
            case Constants.DOCTOR_ID:
                doctorMainActivityIntent.putExtra(Constants.CURRENT_USER, user);
                context.startActivity(doctorMainActivityIntent);
                break;
            case Constants.FOUNDATION_ID:
                foundationMainActivityIntent.putExtra(Constants.CURRENT_USER, user);
                context.startActivity(foundationMainActivityIntent);
                break;
            case Constants.ADMIN_ID:
                adminMainActivityIntent.putExtra(Constants.CURRENT_USER, user);
                context.startActivity(adminMainActivityIntent);
                break;
            default:
                Toast.makeText(context, "Try Again Later", Toast.LENGTH_SHORT).show();
        }
//        } catch (NullPointerException nullPointerException) {
//
//        }
    }

    public static void openMainActicityByUserType(Context context, int role) {
        studentMainActivityIntent = new Intent(context, StudentMainActivity.class);
        patientMainActivityIntent = new Intent(context, PatientMainActivity.class);
        doctorMainActivityIntent = new Intent(context, DoctorMainActivity.class);
        foundationMainActivityIntent = new Intent(context, FoundationMainActivity.class);
        adminMainActivityIntent = new Intent(context, FoundationMainActivity.class);

        switch (role) {
            case Constants.STUDENT_ID:
//                studentMainActivityIntent.putExtra("user", user);
                context.startActivity(studentMainActivityIntent);
                break;
            case Constants.PATIENT_ID:
//                patientMainActivityIntent.putExtra("user", user);
                context.startActivity(patientMainActivityIntent);
                break;
            case Constants.DOCTOR_ID:
//                doctorMainActivityIntent.putExtra("user", user);
                context.startActivity(doctorMainActivityIntent);
                break;
            case Constants.FOUNDATION_ID:
//                foundationMainActivityIntent.putExtra("user", user);
                context.startActivity(foundationMainActivityIntent);
                break;
            case Constants.ADMIN_ID:
//                adminMainActivityIntent.putExtra("user", user);
                context.startActivity(adminMainActivityIntent);
                break;
            default:
                Toast.makeText(context, "Try Again Later", Toast.LENGTH_SHORT).show();
        }
    }
}

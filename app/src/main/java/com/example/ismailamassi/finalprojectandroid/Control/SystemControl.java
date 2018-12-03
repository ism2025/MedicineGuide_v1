package com.example.ismailamassi.finalprojectandroid.Control;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.example.ismailamassi.finalprojectandroid.Activites.DoctorMainActivity;
import com.example.ismailamassi.finalprojectandroid.Activites.FoundationMainActivity;
import com.example.ismailamassi.finalprojectandroid.Activites.PatientMainActivity;
import com.example.ismailamassi.finalprojectandroid.Activites.SigninActivity;
import com.example.ismailamassi.finalprojectandroid.Activites.StudentMainActivity;
import com.example.ismailamassi.finalprojectandroid.Helper.Constants;
import com.example.ismailamassi.finalprojectandroid.Helper.PrefManager;
import com.example.ismailamassi.finalprojectandroid.Models.DoctorUser;
import com.example.ismailamassi.finalprojectandroid.Models.MedicalFoundation;
import com.example.ismailamassi.finalprojectandroid.Models.PatientUser;
import com.example.ismailamassi.finalprojectandroid.Models.StudentUser;
import com.example.ismailamassi.finalprojectandroid.Models.User;

import java.util.ArrayList;

public class SystemControl {
    public static ArrayList<User> allUsers = new ArrayList<>();
    public static ArrayList<PatientUser> allPatients = new ArrayList<>();
    public static ArrayList<StudentUser> allStudents = new ArrayList<>();
    public static ArrayList<DoctorUser> allDoctors = new ArrayList<>();
    public static ArrayList<MedicalFoundation> allMedicalFoundations = new ArrayList<>();


    //    public static ArrayList<User> allUsers = new ArrayList<>();
//    public static ArrayList<User> allUsers = new ArrayList<>();
//    public static ArrayList<User> allUsers = new ArrayList<>();
//    public static ArrayList<User> allUsers = new ArrayList<>();

    private static Intent doctorMainActivityIntent;
    private static Intent foundationMainActivityIntent;
    private static Intent patientMainActivityIntent;
    private static Intent studentMainActivityIntent;
    private static Intent adminMainActivityIntent;

    public static User getUserByEmail(String email) {
        User tmp = null;
        for (User user : allUsers) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                tmp = user;
                break;
            }
        }
        return tmp;
    }

    public static User getUserById(String id) {
        User tmp = null;
        for (User user : allUsers) {
            if (user.getId().equals(id)) {
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
            case Constants.STUDENT_ACCOUNT:
                studentMainActivityIntent.putExtra(Constants.CURRENT_USER, user);
                context.startActivity(studentMainActivityIntent);
                break;
            case Constants.PATIENT_ACCOUNT:
                patientMainActivityIntent.putExtra(Constants.CURRENT_USER, user);
                context.startActivity(patientMainActivityIntent);
                break;
            case Constants.DOCTOR_ACCOUNT:
                doctorMainActivityIntent.putExtra(Constants.CURRENT_USER, user);
                context.startActivity(doctorMainActivityIntent);
                break;
            case Constants.FOUNDTION_ACCOUNT:
                foundationMainActivityIntent.putExtra(Constants.CURRENT_USER, user);
                context.startActivity(foundationMainActivityIntent);
                break;
            case Constants.ADMIN_ACCOUNT:
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
            case Constants.STUDENT_ACCOUNT:
//                studentMainActivityIntent.putExtra("user", user);
                context.startActivity(studentMainActivityIntent);
                break;
            case Constants.PATIENT_ACCOUNT:
//                patientMainActivityIntent.putExtra("user", user);
                context.startActivity(patientMainActivityIntent);
                break;
            case Constants.DOCTOR_ACCOUNT:
//                doctorMainActivityIntent.putExtra("user", user);
                context.startActivity(doctorMainActivityIntent);
                break;
            case Constants.FOUNDTION_ACCOUNT:
//                foundationMainActivityIntent.putExtra("user", user);
                context.startActivity(foundationMainActivityIntent);
                break;
            case Constants.ADMIN_ACCOUNT:
//                adminMainActivityIntent.putExtra("user", user);
                context.startActivity(adminMainActivityIntent);
                break;
            default:
                Toast.makeText(context, "Try Again Later", Toast.LENGTH_SHORT).show();
        }
    }
}

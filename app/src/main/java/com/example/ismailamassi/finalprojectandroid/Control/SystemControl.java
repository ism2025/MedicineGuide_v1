package com.example.ismailamassi.finalprojectandroid.Control;

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

    public User SigninOperation(String email, String password) {
        User tmp = getUserByEmail(email);
        if (tmp != null && tmp.getPassword().equals(password)) {
            return tmp;
        } else
            return null;
    }


    public void SignupOpertion(int role) {
        if (role == 1) {
            //newStudent();
        } else if (role == 2) {
            //newPatient();
        } else if (role == 3) {
            //newFoundation();
        }
    }
//
//    private PatientUser newPatient(String name, Date dob, String email, String password, String phoneNumber, int pWeight) {
//        return new PatientUser(name, 1, dob, email, password, phoneNumber, pWeight);
//    }
//
//    private void newStudent() {
//    }
//
//    private void newFoundation() {
//    }

}

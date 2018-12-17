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
import java.util.MissingFormatArgumentException;

public class SystemControl {
    Context context;

    public static void generateData(Context context) {
        DatabaseHelper helper = new DatabaseHelper(context);

        boolean result1 = helper.insertToFoundationTable("التوبة", "mail@mail.com", "123456", "https://api.androidhive.info/images/glide/large/bvs.jpg", "0592182025", "");
        boolean result2 = helper.insertToFoundationTable("الشفاء", "mail@mail.com", "123456", "https://api.androidhive.info/images/glide/large/deadpool.jpg", "0592182025", "");
        boolean result3 = helper.insertToFoundationTable("النصر", "mail@mail.com", "123456", "https://api.androidhive.info/images/glide/large/cacw.jpg", "0592182025", "");
        boolean result4 = helper.insertToFoundationTable("الرنتيسي", "mail@mail.com", "123456", "https://api.androidhive.info/images/glide/large/bourne.jpg", "0592182025", "");
        boolean result5 = helper.insertToFoundationTable("العودة", "mail@mail.com", "123456", "https://api.androidhive.info/images/glide/large/squad.jpg", "0592182025", "");


//        boolean d1=helper.insertToDoctorTable("yoesf","ee","ee","0592471020","fdsfsdf",1,5,"sdfsfsd","16/12/1999",1);

        boolean g1 = helper.insertToGroupTable("group1");
        boolean g2 = helper.insertToGroupTable("group2");
        boolean g3 = helper.insertToGroupTable("group3");
        boolean g4 = helper.insertToGroupTable("group4");
        boolean g5 = helper.insertToGroupTable("group5");

        boolean de1 = helper.insertToDepartmentTable("department1");
        boolean de2 = helper.insertToDepartmentTable("department2");
        boolean de3 = helper.insertToDepartmentTable("department3");
        boolean de4 = helper.insertToDepartmentTable("department4");
        boolean de5 = helper.insertToDepartmentTable("department5");

        DoctorUser doctorUser1 = new DoctorUser(1,"ee","ee","ee","ee",Constants.DOCTOR_ID,"ee","ee");

        boolean m1 = helper.insertToMedicineTable("test1 ", "test1", "aaaaaaaaaaaa", "das", "dssd", "", 1, 2);
        boolean m2 = helper.insertToMedicineTable("test2 ", "test2", "bbbbbbbbbbbb", "das", "dssd", "", 1, 2);
        boolean m3 = helper.insertToMedicineTable("test3 ", "test3", "cccccccccccc", "das", "dssd", "", 1, 2);
        boolean m4 = helper.insertToMedicineTable("test4 ", "test4", "dddddddddddd", "das", "dssd", "", 1, 2);
        boolean m5 = helper.insertToMedicineTable("test5 ", "test5", "eeeeeeeeeeee", "das", "dssd", "", 1, 2);
        boolean m6 = helper.insertToMedicineTable("test6 ", "test5", "ffffffffffff", "das", "dssd", "", 2, 1);
        boolean m7 = helper.insertToMedicineTable("test7 ", "test5", "gggggggggggg", "das", "dssd", "", 2, 1);
        boolean m8 = helper.insertToMedicineTable("test8 ", "test5", "hhhhhhhhhhhh", "das", "dssd", "", 2, 1);
        boolean m9 = helper.insertToMedicineTable("test9 ", "test5", "iiiiiiiiiiii", "das", "dssd", "", 2, 1);
        boolean m10= helper.insertToMedicineTable("test10", "test5", "jjjjjjjjjjjj", "das", "dssd", "", 2, 1);
        boolean m11= helper.insertToMedicineTable("test11", "test5", "kkkkkkkkkkkk", "das", "dssd", "", 3, 3);
        boolean m12= helper.insertToMedicineTable("test12", "test5", "llllllllllll", "das", "dssd", "", 3, 3);
        boolean m13= helper.insertToMedicineTable("test13", "test5", "mmmmmmmmmmmm", "das", "dssd", "", 3, 3);
        boolean m14= helper.insertToMedicineTable("test14", "test5", "nnnnnnnnnnnn", "das", "dssd", "", 3, 3);
        boolean m15= helper.insertToMedicineTable("test15", "test5", "oooooooooooo", "das", "dssd", "", 3, 3);
        boolean m16= helper.insertToMedicineTable("test16", "test5", "pppppppppppp", "das", "dssd", "", 4, 5);
        boolean m17= helper.insertToMedicineTable("test17", "test5", "qqqqqqqqqqqq", "das", "dssd", "", 4, 5);
        boolean m18= helper.insertToMedicineTable("test18", "test5", "rrrrrrrrrrrr", "das", "dssd", "", 4, 5);
        boolean m19= helper.insertToMedicineTable("test19", "test5", "ssssssssssss", "das", "dssd", "", 4, 5);
        boolean m20= helper.insertToMedicineTable("test20", "test5", "uuuuuuuuuuuu", "das", "dssd", "", 4, 5);
        boolean m21= helper.insertToMedicineTable("test21", "test5", "vvvvvvvvvvvv", "das", "dssd", "", 5, 4);
        boolean m22= helper.insertToMedicineTable("test22", "test5", "wwwwwwwwwwww", "das", "dssd", "", 5, 4);
        boolean m23= helper.insertToMedicineTable("test23", "test5", "xxxxxxxxxxxx", "das", "dssd", "", 5, 4);
        boolean m24= helper.insertToMedicineTable("test24", "test5", "yyyyyyyyyyyy", "das", "dssd", "", 5, 4);
        boolean m25= helper.insertToMedicineTable("test25", "test5", "zzzzzzzzzzzz", "das", "dssd", "", 5, 4);


        Cursor foundations = helper.getFromDatabase(Constants.TABLE_FOUNDATION);
        if (foundations.getCount() != 0) {
            foundations.moveToFirst();
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
                int foundationId = doctors.getInt(9);
                String doctorDob = doctors.getString(10);
                DoctorUser doctorUser = new DoctorUser(doctorId, doctorName, doctorEmail, doctorPassword, doctorPhoneNumber, Constants.DOCTOR_ID, doctorDob, doctorPhoto);
                FoundationUser foundationUser = SystemControl.getFoundationById(foundationId);
                doctorUser.setGender(doctorGender);
                doctorUser.setDoctorRate(doctorRate);
                doctorUser.setSection(doctorSection);
                doctorUser.setFoundationUser(foundationUser);
            }
        }
//        Toast.makeText(context, doctors.getCount()+" .. ", Toast.LENGTH_SHORT).show();

        Cursor groups = helper.getFromDatabase(Constants.TABLE_GROUP);
        if (groups.getCount() != 0) {
            groups.moveToFirst();
            while (groups.moveToNext()) {
                int groupsId = groups.getInt(0);
                String groupsName = groups.getString(1);
                new MedicineGroup(groupsId,groupsName);

            }
        }


        Cursor departments = helper.getFromDatabase(Constants.TABLE_DEPARTMENT);
        if (departments.getCount() != 0) {
            departments.moveToFirst();
            while (departments.moveToNext()) {
                int departmentsId = departments.getInt(0);
                String departmentsName = departments.getString(1);
                new MedicineDepartment(departmentsId,departmentsName);

            }
        }

        Cursor medicine = helper.getFromDatabase(Constants.TABLE_MEDICINE);
        if (medicine!=null&&medicine.getCount() != 0) {
            medicine.moveToFirst();
            while (medicine.moveToNext()) {
                int medicineId = medicine.getInt(0);
                String medicineName = medicine.getString(1);
                String medicineAbout=medicine.getString(2);
                String medicineUses =medicine.getString(3);
                String medicineSideEfect = medicine.getString(4);
                String medicinePhoto = medicine.getString(5);
                String medicineStorge = medicine.getString(6);
                int medicineGroup = medicine.getInt(7);
                int medicineDepartment = medicine.getInt(8);
                Medicine medicine1 =new Medicine(medicineId,medicineName,medicineAbout,medicineUses,medicineSideEfect,medicinePhoto,medicineStorge,medicineGroup,medicineDepartment);


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

    public static FoundationUser getFoundationById(int id) {
        FoundationUser tmp = null;
        for (FoundationUser user : allFoundationUsers) {
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

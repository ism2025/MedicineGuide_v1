package com.example.ismailamassi.finalprojectandroid.Fragments.DoctorFragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ismailamassi.finalprojectandroid.Activites.DoctorMainActivity;
import com.example.ismailamassi.finalprojectandroid.Control.SystemControl;
import com.example.ismailamassi.finalprojectandroid.Helper.Constants;
import com.example.ismailamassi.finalprojectandroid.Helper.PrefManager;
import com.example.ismailamassi.finalprojectandroid.Models.DoctorUser;
import com.example.ismailamassi.finalprojectandroid.Models.Drug;
import com.example.ismailamassi.finalprojectandroid.Models.Medicine;
import com.example.ismailamassi.finalprojectandroid.Models.PatientUser;
import com.example.ismailamassi.finalprojectandroid.Models.User;
import com.example.ismailamassi.finalprojectandroid.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * A simple {@link Fragment} subclass.
 */
public class MedicineDateilsFragment extends Fragment {

    Bundle bundle;
    Medicine medicine;
    TextView tv_medicinename, tv_groupname, tv_departmentname, tv_traditional, tv_uses, tv_storage, tv_about;
    Button btn_addToDoctor;

    EditText et_doctorName, et_medicineName, et_quantity;
    Spinner spinner_patients, spinner_quantityUnit;
    Button btn_addToPatirnt;

    PatientUser selectedPatient;
    User user;

    public MedicineDateilsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_midicine_dateils, container, false);
        tv_medicinename = view.findViewById(R.id.tv_medicinename);
        tv_groupname = view.findViewById(R.id.tv_groupname);
        tv_departmentname = view.findViewById(R.id.tv_departmentname);
        tv_traditional = view.findViewById(R.id.tv_traditional);
        tv_uses = view.findViewById(R.id.tv_uses);
        tv_storage = view.findViewById(R.id.tv_storage);
        tv_about = view.findViewById(R.id.tv_about);
        btn_addToDoctor = view.findViewById(R.id.btn_addToDoctor);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindViews(view);
        bundle = getArguments();
        try {
            medicine = (Medicine) bundle.getSerializable(Constants.MEDICINE_BANDLE);
            tv_medicinename.setText(medicine.getName());
//            tv_groupname.setText(medicine.getMedicineGroup().getName());
//            tv_departmentname.setText(medicine.getMedicineDepartment().getName());
            String names = "";
            for (String x : medicine.getTraditionalNames()) {
                names += x + " .\n";
            }
            tv_traditional.setText(names);
            tv_uses.setText(medicine.getUses());
            tv_storage.setText(medicine.getStorage());
            tv_about.setText(medicine.getAbout());
            user = SystemControl.getUserById(new PrefManager(getContext().getApplicationContext()).getIdAccount());
            if (user instanceof DoctorUser) {
                btn_addToDoctor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openDrugFragment(v, medicine, (DoctorUser) user);
                    }
                });
            }
        } catch (ClassCastException e) {
            Toast.makeText(getContext(), "Something Error, Please Try Again Later .", Toast.LENGTH_SHORT).show();
        }

    }

    void openDrugFragment(View v, Medicine medicine, DoctorUser doctorUser) {

        AddDrugToPatirntFragment addDrugToPatirntFragment = new AddDrugToPatirntFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constants.MEDICINE_BANDLE, medicine);
        bundle.putSerializable(Constants.DOCTOR_BANDLE, doctorUser);
        addDrugToPatirntFragment.setArguments(bundle);
        ((DoctorMainActivity) getContext().getApplicationContext()).getSupportFragmentManager().beginTransaction().replace(R.id.view_pagermidicinedoctor, addDrugToPatirntFragment).addToBackStack(null).commit();
    }

    void bindViews(View view) {
        et_doctorName = view.findViewById(R.id.et_doctorName);
        et_medicineName = view.findViewById(R.id.et_medicineName);
        et_quantity = view.findViewById(R.id.et_quantity);
        spinner_patients = view.findViewById(R.id.spinner_patients);
        spinner_quantityUnit = view.findViewById(R.id.spinner_quantityUnit);
        btn_addToPatirnt = view.findViewById(R.id.btn_addToPatirnt);
    }
}

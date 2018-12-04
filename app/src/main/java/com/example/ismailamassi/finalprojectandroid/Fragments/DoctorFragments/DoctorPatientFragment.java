package com.example.ismailamassi.finalprojectandroid.Fragments.DoctorFragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ismailamassi.finalprojectandroid.Adapters.PatientDoctorAdapter;
import com.example.ismailamassi.finalprojectandroid.Control.SystemControl;
import com.example.ismailamassi.finalprojectandroid.Models.PatientUser;
import com.example.ismailamassi.finalprojectandroid.R;

import java.util.ArrayList;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class DoctorPatientFragment extends Fragment {

    RecyclerView rv_patient;

    public DoctorPatientFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_patientdoctor, container, false);
        rv_patient = view.findViewById(R.id.rv_patient);


        PatientDoctorAdapter patientDoctorAdapter = new PatientDoctorAdapter(getActivity().getBaseContext(), SystemControl.allPatients);
        rv_patient.setAdapter(patientDoctorAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rv_patient.setLayoutManager(layoutManager);
        return view;
    }

}

package com.example.ismailamassi.finalprojectandroid.Fragments.DoctorFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.ismailamassi.finalprojectandroid.Adapters.PatientDoctorAdapter;
import com.example.ismailamassi.finalprojectandroid.Models.PatientUser;
import com.example.ismailamassi.finalprojectandroid.R;

import java.util.ArrayList;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class DoctorPatientFragment extends Fragment {

    RecyclerView recyclerView;
    public DoctorPatientFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view =inflater.inflate(R.layout.fragment_patientdoctor, container, false);
        recyclerView=view.findViewById(R.id.rv_patient);
        recyclerView.setLayoutManager(new LinearLayoutManager(

                getActivity().getBaseContext()));

        ArrayList<PatientUser> patientUsers = new ArrayList<>();
        patientUsers.add(new PatientUser("yosef","yos.ail@outlook.com","111111","3553454",1,new Date(),"ic_launcher_foreground"));
        patientUsers.add(new PatientUser("yosef","yos.ail@outlook.com","111111","3553454",1,new Date(),"ic_launcher_foreground"));
        patientUsers.add(new PatientUser("yosef","yos.ail@outlook.com","111111","3553454",1,new Date(),"ic_launcher_foreground"));
        patientUsers.add(new PatientUser("yosef","yos.ail@outlook.com","111111","3553454",1,new Date(),"ic_launcher_foreground"));
        patientUsers.add(new PatientUser("yosef","yos.ail@outlook.com","111111","3553454",1,new Date(),"ic_launcher_foreground"));
        patientUsers.add(new PatientUser("yosef","yos.ail@outlook.com","111111","3553454",1,new Date(),"ic_launcher_foreground"));
        patientUsers.add(new PatientUser("yosef","yos.ail@outlook.com","111111","3553454",1,new Date(),"ic_launcher_foreground"));
        patientUsers.add(new PatientUser("yosef","yos.ail@outlook.com","111111","3553454",1,new Date(),"ic_launcher_foreground"));
        patientUsers.add(new PatientUser("yosef","yos.ail@outlook.com","111111","3553454",1,new Date(),"ic_launcher_foreground"));
        patientUsers.add(new PatientUser("yosef","yos.ail@outlook.com","111111","3553454",1,new Date(),"ic_launcher_foreground"));
        patientUsers.add(new PatientUser("yosef","yos.ail@outlook.com","111111","3553454",1,new Date(),"ic_launcher_foreground"));
        patientUsers.add(new PatientUser("yosef","yos.ail@outlook.com","111111","3553454",1,new Date(),"ic_launcher_foreground"));

        PatientDoctorAdapter patientDoctorAdapter = new PatientDoctorAdapter(patientUsers,getActivity().getBaseContext());
        recyclerView.setAdapter(patientDoctorAdapter);
        return view;
    }

}

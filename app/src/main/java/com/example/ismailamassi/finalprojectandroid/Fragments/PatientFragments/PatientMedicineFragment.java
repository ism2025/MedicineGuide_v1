package com.example.ismailamassi.finalprojectandroid.Fragments.PatientFragments;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ismailamassi.finalprojectandroid.Adapters.MedicinePatientAdapter;
import com.example.ismailamassi.finalprojectandroid.Control.SystemControl;
import com.example.ismailamassi.finalprojectandroid.Helper.Constants;
import com.example.ismailamassi.finalprojectandroid.Helper.PrefManager;
import com.example.ismailamassi.finalprojectandroid.Models.Drug;
import com.example.ismailamassi.finalprojectandroid.Models.PatientUser;
import com.example.ismailamassi.finalprojectandroid.Models.User;
import com.example.ismailamassi.finalprojectandroid.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PatientMedicineFragment extends Fragment {
    RecyclerView rv_patientmedicine;
    Activity activity = getActivity();

    public PatientMedicineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_patientmedicine, container, false);
        rv_patientmedicine = view.findViewById(R.id.rv_patientmedicine);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        PatientUser patientUser = (PatientUser) this.getActivity().getIntent().getSerializableExtra(Constants.CURRENT_USER);
/*
        MedicinePatientAdapter medicinePatientAdapter = new MedicinePatientAdapter(activity, patientUser.getDrugs());
        rv_patientmedicine.setAdapter(medicinePatientAdapter);
*/
        LinearLayoutManager layoutManager = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);
        rv_patientmedicine.setLayoutManager(layoutManager);
    }
}

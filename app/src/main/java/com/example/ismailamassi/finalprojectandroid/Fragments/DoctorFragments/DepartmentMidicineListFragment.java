package com.example.ismailamassi.finalprojectandroid.Fragments.DoctorFragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.ismailamassi.finalprojectandroid.Adapters.DepartmentDoctorMedicineAdapter;
import com.example.ismailamassi.finalprojectandroid.Control.SystemControl;
import com.example.ismailamassi.finalprojectandroid.Models.MedicineDepartment;
import com.example.ismailamassi.finalprojectandroid.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DepartmentMidicineListFragment extends Fragment {

    RecyclerView rv_medicinedepartment;


    public DepartmentMidicineListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_department_midicine_list, container, false);
        rv_medicinedepartment = view.findViewById(R.id.rv_medicinedepartment);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DepartmentDoctorMedicineAdapter departmentDoctorMedicineAdapter = new DepartmentDoctorMedicineAdapter(getActivity(), SystemControl.allDepartments);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayout.VERTICAL, false);
        rv_medicinedepartment.setAdapter(departmentDoctorMedicineAdapter);
        rv_medicinedepartment.setLayoutManager(layoutManager);
    }

}

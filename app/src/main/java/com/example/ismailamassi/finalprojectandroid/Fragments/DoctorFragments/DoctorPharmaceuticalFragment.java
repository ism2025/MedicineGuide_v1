package com.example.ismailamassi.finalprojectandroid.Fragments.DoctorFragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.ismailamassi.finalprojectandroid.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DoctorPharmaceuticalFragment extends Fragment {

    Button btn_group, btn_department;
    LinearLayout viewPager;

    public DoctorPharmaceuticalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_pharmaceuticaldoctor, container, false);
        btn_group = view.findViewById(R.id.btn_group);
        btn_department = view.findViewById(R.id.btn_department);
        viewPager = view.findViewById(R.id.view_pagermidicinedoctor);
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        onClickItems();
    }

    private void onClickItems() {
        btn_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.view_pagermidicinedoctor, new GroupMidicineListFragment()).commit();
                btn_group.setVisibility(View.GONE);
                btn_department.setVisibility(View.GONE);

            }
        });
        btn_department.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.view_pagermidicinedoctor, new DepartmentMidicineListFragment()).commit();
                btn_group.setVisibility(View.GONE);
                btn_department.setVisibility(View.GONE);
            }
        });
    }

    private void startFragment() {

    }
}

package com.example.ismailamassi.finalprojectandroid.Fragments.DoctorFragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ismailamassi.finalprojectandroid.Helper.Constants;
import com.example.ismailamassi.finalprojectandroid.Models.Medicine;
import com.example.ismailamassi.finalprojectandroid.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MedicineDateilsFragment extends Fragment {

    Bundle bundle;
    Medicine medicine;
    TextView tv_medicinename, tv_groupname, tv_departmentname, tv_traditional, tv_uses, tv_storage, tv_about;

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
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bundle = getArguments();
        try {
            medicine = (Medicine) bundle.getSerializable(Constants.MEDICINE_BANDLE);
            tv_medicinename.setText(medicine.getName());
            tv_groupname.setText(medicine.getMedicineGroup().getName());
            tv_departmentname.setText(medicine.getMedicineDepartment().getName());
            String names = "";
            for (String x : medicine.getTraditionalNames()) {
                names += x + " .\n";
            }
            tv_traditional.setText(names);
            tv_uses.setText(medicine.getUses());
            tv_storage.setText(medicine.getStorage());
            tv_about.setText(medicine.getAbout());
        } catch (ClassCastException e) {
            Toast.makeText(getContext(), "Something Error, Please Try Again Later .", Toast.LENGTH_SHORT).show();
        }


    }
}

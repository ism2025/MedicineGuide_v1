package com.example.ismailamassi.finalprojectandroid.Fragments.DoctorFragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ismailamassi.finalprojectandroid.Adapters.MedicineAdapter;
import com.example.ismailamassi.finalprojectandroid.Helper.Constants;
import com.example.ismailamassi.finalprojectandroid.Models.Medicine;
import com.example.ismailamassi.finalprojectandroid.Models.MedicineDepartment;
import com.example.ismailamassi.finalprojectandroid.Models.MedicineGroup;
import com.example.ismailamassi.finalprojectandroid.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MedicineItemFragment extends Fragment {

    Bundle argument;
    String typeBundle;
    MedicineGroup mg = null;
    MedicineDepartment md = null;

    ArrayList<Medicine> medicines;
    RecyclerView rv_medicines;

    public MedicineItemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_midicine_item, container, false);
        rv_medicines = view.findViewById(R.id.rv_medicines);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        selectedItem();
        if (mg != null) {
            medicines = mg.getGroupItems();
        } else if (md != null) {
            medicines = md.getDepartmentItems();
        }
        MedicineAdapter medicineAdapter = new MedicineAdapter(getActivity(), medicines);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rv_medicines.setLayoutManager(layoutManager);
        rv_medicines.setAdapter(medicineAdapter);
    }

    void selectedItem() {
        argument = getArguments();
        if (argument != null) {
            typeBundle = argument.getString("type");
            if (typeBundle.equals(Constants.GROUP_BANDLE)) {
                mg = (MedicineGroup) argument.getSerializable(Constants.GROUP_BANDLE);
            } else if (typeBundle.equals(Constants.DEPARTMENT_BANDLE)) {
                md = (MedicineDepartment) argument.getSerializable(Constants.DEPARTMENT_BANDLE);
            }
        }
    }
}

package com.example.ismailamassi.finalprojectandroid.Fragments.DoctorFragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ismailamassi.finalprojectandroid.Adapters.GroupDoctorMedicineAdapter;
import com.example.ismailamassi.finalprojectandroid.Control.SystemControl;
import com.example.ismailamassi.finalprojectandroid.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GroupMidicineListFragment extends Fragment {
    RecyclerView rv_medidinegroup;

    public GroupMidicineListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_group_midicine_list, container, false);
        rv_medidinegroup = view.findViewById(R.id.rv_medicinegroup);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        GroupDoctorMedicineAdapter groupDoctorMedicineAdapter = new GroupDoctorMedicineAdapter(getActivity(), SystemControl.allGroups);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rv_medidinegroup.setAdapter(groupDoctorMedicineAdapter);
        rv_medidinegroup.setLayoutManager(layoutManager);

    }
}

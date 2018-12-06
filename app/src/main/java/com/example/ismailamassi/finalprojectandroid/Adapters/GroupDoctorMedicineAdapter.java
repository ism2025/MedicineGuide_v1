package com.example.ismailamassi.finalprojectandroid.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ismailamassi.finalprojectandroid.Activites.DoctorMainActivity;
import com.example.ismailamassi.finalprojectandroid.Fragments.DoctorFragments.MedicineItemFragment;
import com.example.ismailamassi.finalprojectandroid.Helper.Constants;
import com.example.ismailamassi.finalprojectandroid.Models.MedicineGroup;
import com.example.ismailamassi.finalprojectandroid.R;

import java.util.List;

public class GroupDoctorMedicineAdapter extends RecyclerView.Adapter<GroupDoctorMedicineAdapter.MyViewHolder> {
    Context context;
    List<MedicineGroup> list;
    Bundle bundle;
    MedicineItemFragment medicineItemFragment;
    public GroupDoctorMedicineAdapter(Context context, List<MedicineGroup> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public GroupDoctorMedicineAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_group, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GroupDoctorMedicineAdapter.MyViewHolder holder, int position) {
        final MedicineGroup group = list.get(position);
        holder.tv_groupname.setText(group.getName());
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGroupMedicine(group);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CardView container;
        TextView tv_groupname;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_groupname = itemView.findViewById(R.id.tv_groupname);
            container = itemView.findViewById(R.id.container);
        }
    }

    private void openGroupMedicine(MedicineGroup group) {
        medicineItemFragment = new MedicineItemFragment();
        bundle = new Bundle();
        bundle.putString("type",Constants.GROUP_BANDLE);
        bundle.putSerializable(Constants.GROUP_BANDLE, group);
        medicineItemFragment.setArguments(bundle);
        ((DoctorMainActivity) context).getSupportFragmentManager().beginTransaction().replace(R.id.view_pagermidicinedoctor, medicineItemFragment).commit();
    }
}

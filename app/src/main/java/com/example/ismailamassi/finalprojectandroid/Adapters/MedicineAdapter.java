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
import com.example.ismailamassi.finalprojectandroid.Fragments.DoctorFragments.MedicineDateilsFragment;
import com.example.ismailamassi.finalprojectandroid.Helper.Constants;
import com.example.ismailamassi.finalprojectandroid.Models.Medicine;
import com.example.ismailamassi.finalprojectandroid.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Medicine> list;
    Bundle bundle;

    public MedicineAdapter(Context context, ArrayList<Medicine> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MedicineAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_medicine, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Medicine medicine = list.get(position);
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMedicineDetails(medicine);
            }
        });
        int id = context.getResources().getIdentifier(medicine.getPhotoUrl(), "drawable", "com.example.ismailamassi.finalprojectandroid");

        holder.iv_medicineimg.setImageResource(id
//                R.drawable.ic_dashboard_black_24dp
//                medicine.getPhotoUrl()
        );
        holder.tv_medicinename.setText(medicine.getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CardView container;
        CircleImageView iv_medicineimg;
        TextView tv_medicinename;

        public MyViewHolder(View itemView) {
            super(itemView);
            container = itemView.findViewById(R.id.container);
            iv_medicineimg = itemView.findViewById(R.id.iv_medicineimg);
            tv_medicinename = itemView.findViewById(R.id.tv_medicinename);

        }
    }

    void openMedicineDetails(Medicine medicine) {
        MedicineDateilsFragment medicineDateilsFragment = new MedicineDateilsFragment();
        bundle = new Bundle();
        bundle.putString("type", Constants.GROUP_BANDLE);
        bundle.putSerializable(Constants.GROUP_BANDLE, medicine);
        medicineDateilsFragment.setArguments(bundle);
        ((DoctorMainActivity) context).getSupportFragmentManager().beginTransaction().replace(R.id.view_pagermidicinedoctor, medicineDateilsFragment).commit();

    }
}


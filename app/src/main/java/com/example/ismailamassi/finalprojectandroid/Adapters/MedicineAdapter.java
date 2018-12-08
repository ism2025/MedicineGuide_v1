package com.example.ismailamassi.finalprojectandroid.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ismailamassi.finalprojectandroid.Activites.DoctorMainActivity;
import com.example.ismailamassi.finalprojectandroid.Control.SystemControl;
import com.example.ismailamassi.finalprojectandroid.Fragments.DoctorFragments.MedicineDateilsFragment;
import com.example.ismailamassi.finalprojectandroid.Helper.Constants;
import com.example.ismailamassi.finalprojectandroid.Helper.PrefManager;
import com.example.ismailamassi.finalprojectandroid.Models.DoctorUser;
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
//        int id = context.getResources().getIdentifier(medicine.getPhotoUrl(), "drawable", "com.example.ismailamassi.finalprojectandroid");

        holder.iv_medicineimg.setImageResource(
//                id
                R.drawable.ic_lock_outline_black_24dp
//                medicine.getPhotoUrl()
        );
        holder.container.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                openPopupMenu(v, medicine, (DoctorUser) SystemControl.getUserById(new PrefManager(context).getIdAccount()));
                return true;
            }
        });
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
        bundle.putSerializable(Constants.MEDICINE_BANDLE, medicine);
        medicineDateilsFragment.setArguments(bundle);
        ((DoctorMainActivity) context).getSupportFragmentManager().beginTransaction().replace(R.id.view_pagermidicinedoctor, medicineDateilsFragment).commit();

    }

    public void openPopupMenu(View v, final Medicine medicine, final DoctorUser doctorUser) {
        PopupMenu popupMenu = new PopupMenu(context, v);
        popupMenu.getMenuInflater().inflate(R.menu.popup_medicine, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.addToPatient:
                        Toast.makeText(context.getApplicationContext(), item.getTitle(), Toast.LENGTH_LONG).show();
                        break;
                    case R.id.AddToSaves:
                        doctorUser.getSavesMedicine().add(medicine);
                        Toast.makeText(context, "Mission Successfully ", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.Report:
                        Toast.makeText(context, "Done Report About " + medicine.getName() + ", and We Will Review about this.", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
        popupMenu.show();
    }
}


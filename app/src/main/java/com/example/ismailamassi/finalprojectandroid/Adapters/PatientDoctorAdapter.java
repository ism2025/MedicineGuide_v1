package com.example.ismailamassi.finalprojectandroid.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.ismailamassi.finalprojectandroid.Models.PatientUser;
import com.example.ismailamassi.finalprojectandroid.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class PatientDoctorAdapter extends RecyclerView.Adapter<PatientDoctorAdapter.ViewHolder> {
    ArrayList<PatientUser> patientUsers;
    Context context;

    public PatientDoctorAdapter(Context context, ArrayList<PatientUser> patientUsers) {
        this.patientUsers = patientUsers;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_patientfordoctor, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final PatientUser patientUser = patientUsers.get(position);
        holder.textView.setText(patientUser.getName());

        Picasso.with(context).load(patientUser.getPhotoUrl()).resize(500, 500)
                .error(R.drawable.ic_dashboard_black_24dp)
                .centerCrop().into(holder.circleImageView);
        int id = context.getResources().getIdentifier(patientUser.getPhotoUrl(), "drawable", "com.example.ismailamassi.finalprojectandroid");
        holder.circleImageView.setImageResource(id);
    }

    @Override
    public int getItemCount() {
        return patientUsers.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView circleImageView;
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.patient_image);
            textView = itemView.findViewById(R.id.patient_name);
        }
    }
}

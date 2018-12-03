package com.example.ismailamassi.finalprojectandroid.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ismailamassi.finalprojectandroid.Models.MedicineGroup;
import com.example.ismailamassi.finalprojectandroid.R;

import java.security.acl.Group;
import java.util.List;

public class MedicineDoctorAdapter extends RecyclerView.Adapter<MedicineDoctorAdapter.MyViewHolder> {
    Context context;
    List<MedicineGroup> list;
//    List<MedicineDepartment> departments;

    public MedicineDoctorAdapter(Context context, List<MedicineGroup> list) {
        this.context = context;
        this.list = list;
    }

//    public MedicineDoctorAdapter(Context context, List<MedicineDepartment> departments) {
//        this.context = context;
//        this.departments = departments;
//    }

    @Override
    public MedicineDoctorAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_group, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MedicineDoctorAdapter.MyViewHolder holder, int position) {
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
//        context.startActivity(new Intent(context,));
    }
}

package com.example.ismailamassi.finalprojectandroid.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ismailamassi.finalprojectandroid.Models.MedicineDepartment;
import com.example.ismailamassi.finalprojectandroid.Models.MedicineGroup;
import com.example.ismailamassi.finalprojectandroid.R;

import java.util.List;

public class DepartmentDoctorMedicineAdapter extends RecyclerView.Adapter<DepartmentDoctorMedicineAdapter.MyViewHolder> {
    Context context;
    List<MedicineDepartment> list;

    public DepartmentDoctorMedicineAdapter(Context context, List<MedicineDepartment> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public DepartmentDoctorMedicineAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_group, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DepartmentDoctorMedicineAdapter.MyViewHolder holder, int position) {
        final MedicineDepartment department = list.get(position);
        holder.tv_departmentname.setText(department.getName());
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGroupMedicine(department);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CardView container;
        TextView tv_departmentname;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_departmentname = itemView.findViewById(R.id.tv_departmentname);
            container = itemView.findViewById(R.id.container);
        }
    }

    private void openGroupMedicine(MedicineDepartment department) {
//        context.startActivity(new Intent(context,));
    }
}

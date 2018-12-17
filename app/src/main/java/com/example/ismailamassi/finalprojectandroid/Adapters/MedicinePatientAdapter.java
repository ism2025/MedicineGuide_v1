package com.example.ismailamassi.finalprojectandroid.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.ismailamassi.finalprojectandroid.Models.Drug;
import com.example.ismailamassi.finalprojectandroid.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MedicinePatientAdapter extends RecyclerView.Adapter<MedicinePatientAdapter.MyViewHolder> {
    private Context context;
    private List<Drug> list;

    public MedicinePatientAdapter(Context context, List<Drug> list) {
        this.context = context;
        this.list = list;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_medicinetopatient, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Drug drug = list.get(position);
        holder.tv_medicinename.setText(drug.getMedicine().getName());
        holder.tv_drugquantity.setText(drug.getDrugQuantity() + "");

        Picasso.with(context).load(drug.getPhotoUrl()).resize(350, 350)
                .error(R.drawable.ic_dashboard_black_24dp)
                .centerCrop().into(holder.iv_drugphoto);
        holder.cb_status.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                drug.setTake(isChecked);
            }
        });
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrugInfoDialog(drug);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CardView container;
        TextView tv_medicinename, tv_drugquantity;
        CircleImageView iv_drugphoto;
        CheckBox cb_status;

        public MyViewHolder(View itemView) {
            super(itemView);
            container = itemView.findViewById(R.id.container);
            tv_medicinename = itemView.findViewById(R.id.tv_medicinename);
            tv_drugquantity = itemView.findViewById(R.id.tv_drugquantity);
            iv_drugphoto = itemView.findViewById(R.id.iv_medicineimg);
            cb_status = itemView.findViewById(R.id.cb_status);
        }
    }

    private void openDrugInfoDialog(Drug drug) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(context.getApplicationContext())
                .setTitle(drug.getDayOfWeek())
                .setMessage(
                        drug.getMedicine().getName() + "\n"
                                + drug.getDoctor().getName() + "\n"
                                + drug.getDayOfWeek() + "\n"
                                + drug.getDrugQuantity() + "\n"
                                + drug.getDrugType() + "\n"
                                + drug.isTake()
                );
        dialog.create().show();
    }
}

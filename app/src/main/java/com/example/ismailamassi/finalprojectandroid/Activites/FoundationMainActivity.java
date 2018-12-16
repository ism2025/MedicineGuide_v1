package com.example.ismailamassi.finalprojectandroid.Activites;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.ismailamassi.finalprojectandroid.Control.SystemControl;
import com.example.ismailamassi.finalprojectandroid.Fragments.FoundationFragment.AddDoctorFragment;
import com.example.ismailamassi.finalprojectandroid.Helper.Constants;
import com.example.ismailamassi.finalprojectandroid.Helper.PrefManager;
import com.example.ismailamassi.finalprojectandroid.Models.FoundationUser;
import com.example.ismailamassi.finalprojectandroid.R;

public class FoundationMainActivity extends AppCompatActivity {

    RecyclerView rv_foundation_doctor;
    FloatingActionButton fb_add_patient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainfoundation);
        bindView();

        onClickItems();
    }

    void bindView() {
        rv_foundation_doctor = findViewById(R.id.rv_foundation_doctor);
        fb_add_patient = findViewById(R.id.fb_add_patient);
    }

    void onClickItems() {
        final AddDoctorFragment addDoctorFragment = new AddDoctorFragment();
        Bundle bundle = new Bundle();
        FoundationUser fu = (FoundationUser) SystemControl.getUserByEmail(new PrefManager(FoundationMainActivity.this).getEmailAccount());
        bundle.putSerializable(Constants.FOUNDATION_BANDLE, fu);
        addDoctorFragment.setArguments(bundle);
        fb_add_patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                DoctorMainActivity.getSupportFragmentManager().beginTransaction().replace(null, addDoctorFragment).commit();
            }
        });
    }
}

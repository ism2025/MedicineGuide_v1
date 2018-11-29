package com.example.ismailamassi.finalprojectandroid.Activites;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ismailamassi.finalprojectandroid.Adapters.SignupAdapter;
import com.example.ismailamassi.finalprojectandroid.Fragments.Signup1Fragment;
import com.example.ismailamassi.finalprojectandroid.Fragments.Signup2Fragment;
import com.example.ismailamassi.finalprojectandroid.Fragments.Signup3FoundtionFragment;
import com.example.ismailamassi.finalprojectandroid.Fragments.Signup3PatientFragment;
import com.example.ismailamassi.finalprojectandroid.Fragments.Signup3StudentFragment;
import com.example.ismailamassi.finalprojectandroid.R;

public class SignupActivity extends AppCompatActivity {
    Button btn_studentacc, btn_patientacc, btn_foundtionacc;
    ViewPager viewPager;
    Fragment[] fragments = new Fragment[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        bindView();
        onClickItems();
    }

    //♦

    private void bindView() {
        viewPager = findViewById(R.id.viewPager);
        btn_studentacc = findViewById(R.id.btn_studentacc);
        btn_patientacc = findViewById(R.id.btn_patientacc);
        btn_foundtionacc = findViewById(R.id.btn_foundtionacc);
    }

    private void onClickItems() {
        fragments[0] = new Signup1Fragment();
        fragments[1] = new Signup2Fragment();
        btn_studentacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragments[2] = new Signup3StudentFragment();
                viewPager.setAdapter(new SignupAdapter(getSupportFragmentManager(), fragments));
                viewPager.setVisibility(View.VISIBLE);
            }
        });
        btn_patientacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragments[2] = new Signup3PatientFragment();
                viewPager.setAdapter(new SignupAdapter(getSupportFragmentManager(), fragments));
                viewPager.setVisibility(View.VISIBLE);
            }
        });
        btn_foundtionacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragments[2] = new Signup3FoundtionFragment();
                viewPager.setAdapter(new SignupAdapter(getSupportFragmentManager(), fragments));
                viewPager.setVisibility(View.VISIBLE);
            }
        });
    }
}

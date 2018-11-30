package com.example.ismailamassi.finalprojectandroid.Activites;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ismailamassi.finalprojectandroid.Fragments.Signup1Fragment;
import com.example.ismailamassi.finalprojectandroid.Helper.Constants;
import com.example.ismailamassi.finalprojectandroid.R;

public class SignupActivity extends AppCompatActivity {
    Button btn_studentacc, btn_patientacc, btn_foundtionacc;
    LinearLayout viewPager;
    Fragment[] fragments = new Fragment[1];
    TextView tv_type ;
    int typeAcc;

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
        tv_type = findViewById(R.id.tv_type);
    }

    private void onClickItems() {
        fragments[0] = new Signup1Fragment();
        btn_studentacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                typeAcc=Constants.STUDENT_ACCOUNT;
                getSupportFragmentManager().beginTransaction().replace(R.id.viewPager, new Signup1Fragment()).commit();
                visibleGone();
                viewPager.setVisibility(View.VISIBLE);
            }
        });
        btn_patientacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                typeAcc=Constants.PATIENT_ACCOUNT;
                getSupportFragmentManager().beginTransaction().replace(R.id.viewPager, new Signup1Fragment()).commit();
                visibleGone();
                viewPager.setVisibility(View.VISIBLE);
            }
        });
        btn_foundtionacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                typeAcc=Constants.FOUNDTION_ACCOUNT;
                getSupportFragmentManager().beginTransaction().replace(R.id.viewPager, new Signup1Fragment()).commit();
                visibleGone();
                viewPager.setVisibility(View.VISIBLE);
            }
        });
    }
    public void visibleGone(){
        btn_studentacc.setVisibility(View.GONE);
        btn_patientacc.setVisibility(View.GONE);
        btn_foundtionacc.setVisibility(View.GONE);
        tv_type.setVisibility(View.GONE);

    }
    public void repleceFragmentSignUp(int typeAcc){
        Signup1Fragment signup1Fragment =new Signup1Fragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.viewPager, signup1Fragment).commit();

    }
    public int getTypeAcc(){
        return typeAcc;
    }
}

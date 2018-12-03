package com.example.ismailamassi.finalprojectandroid.Activites;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.ismailamassi.finalprojectandroid.Adapters.ViewPagerAdapter;
import com.example.ismailamassi.finalprojectandroid.Fragments.DoctorFragments.DoctorHomeFragment;
import com.example.ismailamassi.finalprojectandroid.Helper.Constants;
import com.example.ismailamassi.finalprojectandroid.Helper.PrefManager;
import android.widget.TextView;

import com.example.ismailamassi.finalprojectandroid.Fragments.DoctorFragments.DoctorHomeFragment;
import com.example.ismailamassi.finalprojectandroid.Fragments.DoctorFragments.DoctorMessageFragment;
import com.example.ismailamassi.finalprojectandroid.Fragments.DoctorFragments.DoctorPatientFragment;
import com.example.ismailamassi.finalprojectandroid.Fragments.DoctorFragments.DoctorPharmaceuticalFragment;
import com.example.ismailamassi.finalprojectandroid.Fragments.DoctorFragments.DoctorSavedFragment;

import com.example.ismailamassi.finalprojectandroid.Helper.Constants;
import com.example.ismailamassi.finalprojectandroid.Helper.PrefManager;
import com.example.ismailamassi.finalprojectandroid.R;

public class DoctorMainActivity extends AppCompatActivity {

    private PrefManager prefManager;
    private MenuItem prevMenuItem;
    private ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    private TextView mTextMessage;
    DoctorHomeFragment doctorHomeFragment;
    DoctorPatientFragment patientPageFragment;
    DoctorPharmaceuticalFragment doctorPharmaceuticalFragment;
    DoctorSavedFragment doctorSavedFragment;
    DoctorMessageFragment doctorMessageFragment;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_Patient:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_message:
                    viewPager.setCurrentItem(2);
                    return true;
                case R.id.navigation_pharmaceutical:
                    viewPager.setCurrentItem(3);
                    return true;
                case R.id.navigation_saves:
                    viewPager.setCurrentItem(4);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maindoctor);
        prefManager = new PrefManager(this);
        int role = prefManager.getTypeAccount();
        if (role == Constants.STUDENT_ACCOUNT) {
//            setContentView(R.layout.);
        } else if (role == Constants.PATIENT_ACCOUNT) {

        } else if (role == Constants.DOCTOR_ACCOUNT) {

        } else if (role == Constants.FOUNDTION_ACCOUNT) {

        } else if (role == Constants.ADMIN_ACCOUNT) {

        }
//        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pagerbottomnav);

        final BottomNavigationView navigation =  findViewById(R.id.navigation);

        navigation.setItemBackgroundResource(R.color.colorPrimaryDark);
            viewPager.setCurrentItem(0);
        setContentView(R.layout.activity_maindoctor);

        viewPager = findViewById(R.id.view_pagerbottomnav);

        navigation.setItemBackgroundResource(R.color.colorPrimaryDark);
        viewPager.setCurrentItem(0);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);

                } else {
                    navigation.getMenu().getItem(0).setChecked(false);
                }
                navigation.getMenu().getItem(position).setChecked(true);
                prevMenuItem = navigation.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        setupViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        doctorHomeFragment = new DoctorHomeFragment();
        patientPageFragment = new DoctorPatientFragment();
        doctorPharmaceuticalFragment = new DoctorPharmaceuticalFragment();
        doctorSavedFragment = new DoctorSavedFragment();
        doctorMessageFragment = new DoctorMessageFragment();
        viewPagerAdapter.addFragment(doctorHomeFragment);
        viewPagerAdapter.addFragment(patientPageFragment);
        viewPagerAdapter.addFragment(doctorPharmaceuticalFragment);
        viewPagerAdapter.addFragment(doctorSavedFragment);
        viewPagerAdapter.addFragment(doctorMessageFragment);
        viewPager.setAdapter(viewPagerAdapter);
    }
}

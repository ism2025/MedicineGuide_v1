package com.example.ismailamassi.finalprojectandroid.Activites;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.ismailamassi.finalprojectandroid.Fragments.HomePageFragment;
import com.example.ismailamassi.finalprojectandroid.Fragments.NotificationsPageFragment;
import com.example.ismailamassi.finalprojectandroid.Fragments.PatientPageFragment;
import com.example.ismailamassi.finalprojectandroid.Fragments.PharmaceuticalPageFragment;
import com.example.ismailamassi.finalprojectandroid.Fragments.SavedPageFragment;
import com.example.ismailamassi.finalprojectandroid.R;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setFragment(new HomePageFragment());
                    return true;
                case R.id.navigation_Patient:
                    setFragment(new PatientPageFragment());
                    return true;
                case R.id.navigation_notifications:
                    setFragment(new NotificationsPageFragment());
                    return true;
                case R.id.navigation_pharmaceutical:
                    setFragment(new PharmaceuticalPageFragment());
                    return true;
                case R.id.navigation_saves:
                    setFragment(new SavedPageFragment());
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setItemBackgroundResource(R.color.colorPrimaryDark);
        setFragment(new HomePageFragment());
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void setFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.view_pagerbottomnav,fragment).commit();

    }
}

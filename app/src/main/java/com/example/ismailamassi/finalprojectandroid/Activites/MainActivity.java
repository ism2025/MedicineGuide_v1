package com.example.ismailamassi.finalprojectandroid.Activites;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.ismailamassi.finalprojectandroid.Adapters.ViewPagerAdapter;
import com.example.ismailamassi.finalprojectandroid.Fragments.HomePageFragment;
import com.example.ismailamassi.finalprojectandroid.Fragments.NotificationsPageFragment;
import com.example.ismailamassi.finalprojectandroid.Fragments.PatientPageFragment;
import com.example.ismailamassi.finalprojectandroid.Fragments.PharmaceuticalPageFragment;
import com.example.ismailamassi.finalprojectandroid.Fragments.SavedPageFragment;
import com.example.ismailamassi.finalprojectandroid.R;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    MenuItem prevMenuItem;
    ViewPager viewPager;
    MenuItem PrevMenuItem;
    HomePageFragment homePageFragment;
    PatientPageFragment patientPageFragment;
    NotificationsPageFragment notificationsPageFragment;
    PharmaceuticalPageFragment pharmaceuticalPageFragment;
    SavedPageFragment savedPageFragment;

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
                case R.id.navigation_notifications:
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
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        viewPager = findViewById(R.id.view_pagerbottomnav);

        final BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setItemBackgroundResource(R.color.colorPrimaryDark);
        viewPager.setCurrentItem(0);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(prevMenuItem!=null){
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
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        homePageFragment = new HomePageFragment();
        patientPageFragment = new PatientPageFragment();
        notificationsPageFragment=new NotificationsPageFragment();
        pharmaceuticalPageFragment = new PharmaceuticalPageFragment();
        savedPageFragment = new SavedPageFragment();
        viewPagerAdapter.addFragment(homePageFragment);
        viewPagerAdapter.addFragment(patientPageFragment);
        viewPagerAdapter.addFragment(notificationsPageFragment);
        viewPagerAdapter.addFragment(pharmaceuticalPageFragment);
        viewPagerAdapter.addFragment(savedPageFragment);
        viewPager.setAdapter(viewPagerAdapter);
    }
}

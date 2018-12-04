package com.example.ismailamassi.finalprojectandroid.Activites;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.ismailamassi.finalprojectandroid.Adapters.ViewPagerStudentAdapter;
import com.example.ismailamassi.finalprojectandroid.Fragments.StudentFragments.StudentMidicineFragment;
import com.example.ismailamassi.finalprojectandroid.Fragments.StudentFragments.StudentNotificationFragment;
import com.example.ismailamassi.finalprojectandroid.Fragments.StudentFragments.StudentSavedFragment;
import com.example.ismailamassi.finalprojectandroid.R;

public class StudentMainActivity extends AppCompatActivity {
    ViewPager viewPagerStudent;
    BottomNavigationView bottomNavigationViewStudent;
    MenuItem prevMenuItem;
    StudentMidicineFragment studentMidicineFragment;
    StudentSavedFragment studentSavedFragment;
    StudentNotificationFragment studentNotificationFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_midicinestudent:
                    viewPagerStudent.setCurrentItem(0);
                    return true;
                case R.id.navigation_savesStudent:
                    viewPagerStudent.setCurrentItem(1);
                    return true;
                case R.id.navigation_notificationstudent:
                    viewPagerStudent.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainstudent);
        viewPagerStudent = findViewById(R.id.viewpager_student);
        bottomNavigationViewStudent = findViewById(R.id.bottom_navigationviewstudent);
        bottomNavigationViewStudent.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        setupViewPager(viewPagerStudent);
        viewPagerStudent.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setCheckable(false);
                } else {
                    bottomNavigationViewStudent.getMenu().getItem(0).setCheckable(false);
                }
                bottomNavigationViewStudent.getMenu().getItem(position).setCheckable(true);
                prevMenuItem = bottomNavigationViewStudent.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerStudentAdapter viewPagerStudentAdapter = new ViewPagerStudentAdapter(getSupportFragmentManager());
        studentMidicineFragment = new StudentMidicineFragment();
        studentSavedFragment = new StudentSavedFragment();
        studentNotificationFragment = new StudentNotificationFragment();


        viewPagerStudentAdapter.addFragment(studentMidicineFragment);
        viewPagerStudentAdapter.addFragment(studentSavedFragment);
        viewPagerStudentAdapter.addFragment(studentNotificationFragment);
        viewPager.setAdapter(viewPagerStudentAdapter);

    }
}

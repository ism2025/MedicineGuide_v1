package com.example.ismailamassi.finalprojectandroid.Activites;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.ismailamassi.finalprojectandroid.Adapters.ViewPagerPatientAdapter;
import com.example.ismailamassi.finalprojectandroid.Fragments.PatientFragments.PatientMedicineFragment;
import com.example.ismailamassi.finalprojectandroid.Fragments.PatientFragments.PatientMessageFragment;
import com.example.ismailamassi.finalprojectandroid.Fragments.PatientFragments.PatientNotificationFragment;
import com.example.ismailamassi.finalprojectandroid.Models.PatientUser;
import com.example.ismailamassi.finalprojectandroid.Models.User;
import com.example.ismailamassi.finalprojectandroid.R;

public class PatientMainActivity extends AppCompatActivity {

    ViewPager viewPagerPatient;
    BottomNavigationView bottomNavigationItemViewPatient;
    MenuItem PrevMenuItem;
    PatientMedicineFragment patientMedicineFragment;
    PatientMessageFragment patientMessageFragment;
    PatientNotificationFragment patientNotificationFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_midicinepatient:
                    viewPagerPatient.setCurrentItem(0);
                    return true;
                case R.id.navigation_messagepatient:
                    viewPagerPatient.setCurrentItem(1);
                    return true;
                case R.id.navigation_notificationpatient:
                    viewPagerPatient.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpatient);
        viewPagerPatient = findViewById(R.id.viewpager_patient);
        bottomNavigationItemViewPatient = findViewById(R.id.bottom_navigationviewpatient);
        bottomNavigationItemViewPatient.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        setupViewPager(viewPagerPatient);
        Intent intent = getIntent();
        PatientUser user = (PatientUser) intent.getSerializableExtra("user");
        viewPagerPatient.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
            @Override
            public void onPageSelected(int position) {
                if (PrevMenuItem != null) {
                    PrevMenuItem.setChecked(false);
                } else {
                    bottomNavigationItemViewPatient.getMenu().getItem(0).setChecked(false);
                }
                bottomNavigationItemViewPatient.getMenu().getItem(position).setChecked(true);
                PrevMenuItem = bottomNavigationItemViewPatient.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerPatientAdapter viewPagerPatientAdapter = new ViewPagerPatientAdapter(getSupportFragmentManager());
        patientMedicineFragment = new PatientMedicineFragment();
        patientMessageFragment = new PatientMessageFragment();
        patientNotificationFragment = new PatientNotificationFragment();
        viewPagerPatientAdapter.addFragment(patientMedicineFragment);
        viewPagerPatientAdapter.addFragment(patientMessageFragment);
        viewPagerPatientAdapter.addFragment(patientNotificationFragment);
        viewPager.setAdapter(viewPagerPatientAdapter);
    }

}

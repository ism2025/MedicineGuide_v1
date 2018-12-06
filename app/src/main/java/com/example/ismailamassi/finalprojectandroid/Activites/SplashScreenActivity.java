package com.example.ismailamassi.finalprojectandroid.Activites;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.ismailamassi.finalprojectandroid.R;

public class SplashScreenActivity extends AppCompatActivity {

    Intent sliderIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        sliderIntent = new Intent(SplashScreenActivity.this, IntroSliderActivity.class);
        CountDownTimer count = new CountDownTimer(1500, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                startActivity(sliderIntent);
            }
        }.start();

    }
}

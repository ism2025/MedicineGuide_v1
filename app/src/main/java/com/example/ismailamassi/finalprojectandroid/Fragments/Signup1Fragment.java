package com.example.ismailamassi.finalprojectandroid.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ismailamassi.finalprojectandroid.Activites.IntroSliderActivity;
import com.example.ismailamassi.finalprojectandroid.Activites.SignupActivity;
import com.example.ismailamassi.finalprojectandroid.R;

public class Signup1Fragment extends Fragment {

    EditText et_username, et_email, et_password, et_confrimpass;
    Button btn_next, btn_back;
    TextView tv_createaccount;
    String username, email, password, confirmpass;

    Intent signupIntent;

    Fragment[] fragments;
    ViewPager viewPager;

    public Signup1Fragment() {
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup1, container, false);
        et_username = view.findViewById(R.id.et_username);
        et_email = view.findViewById(R.id.et_email);
        et_password = view.findViewById(R.id.et_password);
        et_confrimpass = view.findViewById(R.id.et_confrimpass);

        btn_back = view.findViewById(R.id.btn_back);
        btn_next = view.findViewById(R.id.btn_next);

        tv_createaccount = view.findViewById(R.id.tv_createaccount);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        signupIntent = new Intent(getActivity(), SignupActivity.class);
        signupIntent = new Intent("signinActivity");
        onClickItems();
    }

    private void onClickItems() {
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        tv_createaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(signupIntent);
            }
        });
    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }
}

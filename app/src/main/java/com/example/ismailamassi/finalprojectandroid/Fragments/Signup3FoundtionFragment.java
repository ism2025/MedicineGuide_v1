package com.example.ismailamassi.finalprojectandroid.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ismailamassi.finalprojectandroid.Activites.SigninActivity;
import com.example.ismailamassi.finalprojectandroid.Helper.Constants;
import com.example.ismailamassi.finalprojectandroid.Models.PatientUser;
import com.example.ismailamassi.finalprojectandroid.R;

public class Signup3FoundtionFragment extends Fragment {

    Button btn_finish, btn_back;

    TextView tv_haveacc;
    Intent signinIntent;
    Bundle bundle;

    public Signup3FoundtionFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup3foundtion, container, false);
        signinIntent = new Intent(getActivity(), SigninActivity.class);
        tv_haveacc = view.findViewById(R.id.tv_haveacc);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        signinIntent = new Intent(getActivity(), SigninActivity.class);
        bundle = getArguments();
        signinIntent = new Intent(getActivity(), SigninActivity.class);
        onClickItems();
    }

    private void onClickItems() {
        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(signinIntent);
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.viewPager, new Signup2Fragment()).commit();
            }
        });
        tv_haveacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(signinIntent);
            }
        });
    }
    private void saveData() {
        //User
        int role = Constants.PATIENT_ACCOUNT;
        String name = bundle.getString("username");
        String email = bundle.getString("email");
        String password = bundle.getString("password");
        String phoneNumber = bundle.getString("phoneNumber");
        String photoUrl = "";   //bundle.getString("");
        //Patient
        int gender = bundle.getInt("gender");
        String Dob = bundle.getString("dob");
        int weight = bundle.getInt("weight");
        String diseases = bundle.getString("diseases");

        PatientUser pu = new PatientUser(name, email, password, phoneNumber, role, null, photoUrl);
        pu.setGender(gender);
//        pu.setDiseases(diseases);
        pu.setpWeight(weight);
    }
}

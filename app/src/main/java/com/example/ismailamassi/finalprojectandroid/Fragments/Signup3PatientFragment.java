package com.example.ismailamassi.finalprojectandroid.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.ismailamassi.finalprojectandroid.Activites.SigninActivity;
import com.example.ismailamassi.finalprojectandroid.Helper.Constants;
import com.example.ismailamassi.finalprojectandroid.Helper.Methods;
import com.example.ismailamassi.finalprojectandroid.Models.PatientUser;
import com.example.ismailamassi.finalprojectandroid.*;
import com.fourhcode.forhutils.FUtilsValidation;

public class Signup3PatientFragment extends Fragment {
    EditText et_weight, et_diseases;
    RadioGroup rg_gender;
    RadioButton rb_male, rb_female;
    Button btn_finish, btn_back;
    TextView tv_haveacc;
    int selectedGender = 0;
    Intent signinIntent;
    Bundle bundle;

    public Signup3PatientFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup3patient, container, false);
        et_weight = view.findViewById(R.id.et_weight);
        et_diseases = view.findViewById(R.id.et_diseases);

        rg_gender = view.findViewById(R.id.rg_gender);

        rb_male = view.findViewById(R.id.rb_male);
        rb_female = view.findViewById(R.id.rb_female);

        btn_finish = view.findViewById(R.id.btn_finish);
        btn_back = view.findViewById(R.id.btn_back);

        tv_haveacc = view.findViewById(R.id.tv_haveacc);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        signinIntent = new Intent(getActivity(), SigninActivity.class);
        bundle = getArguments();
        onClickItems();

    }

    private void onClickItems() {
        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int valid = ValidationData();
                if (valid != -1) {
                    saveData();
                    startActivity(signinIntent);
                }
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.viewPager, new Signup2Fragment()).commit();
            }
        });
        rg_gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_male) {
                    selectedGender = 1;
                } else if (checkedId == R.id.rb_female) {
                    selectedGender = 2;
                }
            }
        });
    }

    private int ValidationData() {
        if (FUtilsValidation.isEmpty(et_weight, Constants.FIELD_REQUIRED) || selectedGender == 0) {
            return -1;
        } else {
            bundle.putInt("gender", selectedGender);
            bundle.putInt("weight", Integer.parseInt(Methods.getStringFromEditText(et_diseases)));
            bundle.putString("diseases", Methods.getStringFromEditText(et_diseases));
            return 1;
        }
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

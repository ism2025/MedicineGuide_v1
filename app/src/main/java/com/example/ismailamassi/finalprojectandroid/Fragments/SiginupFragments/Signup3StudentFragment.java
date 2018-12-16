package com.example.ismailamassi.finalprojectandroid.Fragments.SiginupFragments;

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
import com.example.ismailamassi.finalprojectandroid.Models.StudentUser;
import com.example.ismailamassi.finalprojectandroid.R;
import com.fourhcode.forhutils.FUtilsValidation;

public class Signup3StudentFragment extends Fragment {
    EditText et_foundtion;
    RadioGroup rg_gender;
    int selectedGender = 0;
    RadioButton rb_male, rb_female;
    Button btn_finish, btn_back;
    TextView tv_haveacc;

    Bundle bundle;
    Intent signinIntent;

    public Signup3StudentFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup3student, container, false);
        et_foundtion = view.findViewById(R.id.et_foundtion);
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
        signinIntent = new Intent(getActivity(), SigninActivity.class);
        onClickItems();
    }

    private void onClickItems() {

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
        tv_haveacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(signinIntent);
            }
        });
    }

    private int ValidationData() {
        String foundation = Methods.getStringFromEditText(et_foundtion);
        if (FUtilsValidation.isEmpty(et_foundtion, Constants.FIELD_REQUIRED) || selectedGender == 0) {
            return -1;
        } else {
            bundle.putString("foundation", foundation);
            bundle.putInt("gender", selectedGender);
            return 1;
        }
    }

    private void saveData() {
        //User
        int role = Constants.STUDENT_ID;
        String name = bundle.getString("username");
        String email = bundle.getString("email");
        String password = bundle.getString("password");
        String phoneNumber = bundle.getString("phoneNumber");
        String photoUrl = "";   //bundle.getString("");

        //Student
        int gender = bundle.getInt("gender");
        String foundation = bundle.getString("foundation");
        String Dob = bundle.getString("dob");

        StudentUser su = new StudentUser(456, name, email, password, phoneNumber, role, null, photoUrl);
        su.setEducationalFoundation(foundation);
        su.setGender(gender);
    }
}

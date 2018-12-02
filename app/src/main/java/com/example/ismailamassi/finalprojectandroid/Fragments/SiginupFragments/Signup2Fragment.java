package com.example.ismailamassi.finalprojectandroid.Fragments.SiginupFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.ismailamassi.finalprojectandroid.Activites.SignupActivity;
import com.example.ismailamassi.finalprojectandroid.Helper.Constants;
import com.example.ismailamassi.finalprojectandroid.Helper.Methods;
import com.example.ismailamassi.finalprojectandroid.R;
import com.fourhcode.forhutils.FUtilsValidation;

public class Signup2Fragment extends Fragment {
    Button btn_next, btn_Back;
    Bundle bundle;
    EditText et_phonenum, et_dob;
    SignupActivity activity;

    public Signup2Fragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup2, container, false);
        btn_next = view.findViewById(R.id.btn_nextsignup2);
        btn_Back = view.findViewById(R.id.btn_backsignup2);

        et_phonenum = view.findViewById(R.id.et_phonenum);
        et_dob = view.findViewById(R.id.et_dob);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bundle = getArguments();
        onClickItems();

    }

    private void onClickItems() {

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int valid = ValidationData();
                if (valid != -1) {
                    startFragment3();
                }
            }
        });

        btn_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.viewPager, new Signup1Fragment()).commit();
            }
        });

    }

    private int ValidationData() {
        String phoneNumber = Methods.getStringFromEditText(et_phonenum);
        String Dob = Methods.getStringFromEditText(et_dob);
        if (FUtilsValidation.isEmpty(et_phonenum, "This field is required") || FUtilsValidation.isEmpty(et_dob, "This field is required")) {
            return -1;
        } else {
            bundle.putString("phoneNumber", phoneNumber);
            bundle.putString("dob", Dob);
            return 1;
        }
    }

    private void startFragment3() {
        final int typeAcc = bundle.getInt("typeAcc");
        if (typeAcc == Constants.STUDENT_ACCOUNT) {
            Signup3StudentFragment studentFragment = new Signup3StudentFragment();
            studentFragment.setArguments(bundle);
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.viewPager, studentFragment).commit();
        } else if (typeAcc == Constants.FOUNDTION_ACCOUNT) {
            Signup3FoundtionFragment studentFragment = new Signup3FoundtionFragment();
            studentFragment.setArguments(bundle);
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.viewPager, studentFragment).commit();
        } else if (typeAcc == Constants.PATIENT_ACCOUNT) {
            Signup3PatientFragment patientFragment = new Signup3PatientFragment();
            patientFragment.setArguments(bundle);
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.viewPager, patientFragment).commit();
        }
    }
}


package com.example.ismailamassi.finalprojectandroid.Fragments.SiginupFragments;

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

import com.example.ismailamassi.finalprojectandroid.Activites.SigninActivity;
import com.example.ismailamassi.finalprojectandroid.Activites.SignupActivity;
import com.example.ismailamassi.finalprojectandroid.Control.SystemControl;
import com.example.ismailamassi.finalprojectandroid.Helper.Constants;
import com.example.ismailamassi.finalprojectandroid.Helper.Methods;
import com.example.ismailamassi.finalprojectandroid.R;
import com.fourhcode.forhutils.FUtilsValidation;

public class Signup1Fragment extends Fragment {
    int typeAcc;
    EditText et_username, et_email, et_password, et_confrimpass;
    Button btn_next;
    String username, email, password, confirmpass;
    Bundle bundle;
    SignupActivity activity;
    ViewPager viewPager;
    TextView tv_haveacc;
    Intent signinIntent;

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

        btn_next = view.findViewById(R.id.btn_next);

        tv_haveacc = view.findViewById(R.id.tv_haveacc);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        activity = (SignupActivity) getActivity();
        bundle = new Bundle();
        signinIntent = new Intent(getActivity(), SigninActivity.class);
        onClickItems();
    }

    private void onClickItems() {
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Signup2Fragment signup2Fragment = new Signup2Fragment();
                int isValid = ValidationData();
                if (isValid == 1) {
                    signup2Fragment.setArguments(bundle);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.viewPager, signup2Fragment).commit();
                } else if (isValid == -2) {
                    et_email.setError("This Email is alaredy Sign up");
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
        username = Methods.getStringFromEditText(et_username);
        email = Methods.getStringFromEditText(et_email);
        password = Methods.getStringFromEditText(et_password);
        confirmpass = Methods.getStringFromEditText(et_confrimpass);
        if (SystemControl.getUserByEmail(email) != null) {
            return -2;
        } else {
            if (FUtilsValidation.isEmpty(et_username, Constants.FIELD_REQUIRED)
                    || !FUtilsValidation.isValidEmail(et_email, Constants.FIELD_REQUIRED)
                    || FUtilsValidation.isEmpty(et_password, Constants.FIELD_REQUIRED)
                    || !FUtilsValidation.isPasswordEqual(et_password, et_confrimpass, "No Match")
                    ) {
                if (!FUtilsValidation.isLengthCorrect(password, 6, 32)) {
                    et_password.setError("The Password Must be between 6 - 32 digit");
                    return -1;
                }
                return -1;

            } else {
                typeAcc = activity.getTypeAcc();
                bundle.putInt("typeAcc", typeAcc);
                bundle.putString("username", username);
                bundle.putString("email", email);
                bundle.putString("password", password);
                return 1;
            }
        }
    }
}




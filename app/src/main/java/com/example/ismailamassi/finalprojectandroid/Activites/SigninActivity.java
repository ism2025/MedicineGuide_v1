package com.example.ismailamassi.finalprojectandroid.Activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ismailamassi.finalprojectandroid.Control.SystemControl;
import com.example.ismailamassi.finalprojectandroid.Helper.Constants;
import com.example.ismailamassi.finalprojectandroid.Helper.Methods;
import com.example.ismailamassi.finalprojectandroid.Helper.PrefManager;
import com.example.ismailamassi.finalprojectandroid.Models.User;
import com.example.ismailamassi.finalprojectandroid.R;
import com.example.ismailamassi.finalprojectandroid.TestData;

public class SigninActivity extends AppCompatActivity {

    TextView tv_forgetpassword, tv_createaccount;
    EditText et_email, et_password;
    Button btn_login;
    String email, password;
    Intent signupIntent, forgetPasswordIntent;

    PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        bindView();
        TestData.GenerateData();
        signupIntent = new Intent(SigninActivity.this, SignupActivity.class);
        forgetPasswordIntent = new Intent(SigninActivity.this, ForgetPasswordActivity.class);
        prefManager = new PrefManager(this);
        onClickItems();

    }

    private void bindView() {
        tv_createaccount = findViewById(R.id.tv_haveacc);
        tv_forgetpassword = findViewById(R.id.tv_forgetpassword);

        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);

        btn_login = findViewById(R.id.btn_login);
    }

    private void onClickItems() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = Methods.getStringFromEditText(et_email);
                password = Methods.getStringFromEditText(et_password);
                User user = SystemControl.SigninOperation(email, password);
                if (user != null) {
                    prefManager.setSignin(true);
                    prefManager.setTypeAccount(user.getRole());
                    prefManager.setIdAccount(user.getId());
                    SystemControl.openMainActicityByUserType(SigninActivity.this,
                            SystemControl.getUserById(prefManager.getIdAccount()));
                } else
                    Toast.makeText(SigninActivity.this, Methods.getStringFromResources(SigninActivity.this, R.string.error_signin), Toast.LENGTH_SHORT).show();
            }
        });
        tv_createaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(signupIntent);
            }
        });

        tv_forgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(forgetPasswordIntent);
            }
        });
    }

}

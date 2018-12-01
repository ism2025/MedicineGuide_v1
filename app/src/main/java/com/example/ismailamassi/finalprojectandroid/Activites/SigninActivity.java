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
import com.example.ismailamassi.finalprojectandroid.Models.StudentUser;
import com.example.ismailamassi.finalprojectandroid.Models.User;
import com.example.ismailamassi.finalprojectandroid.R;

public class SigninActivity extends AppCompatActivity {

    TextView tv_forgetpassword, tv_createaccount;
    EditText et_email, et_password;
    Button btn_login;
    String email, password;
    Intent mainActivityIntent, signupIntent, forgetPasswordIntent;

    PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        bindView();
        StudentUser studentUser = new StudentUser("admin", "email", "password", "0592182025", Constants.STUDENT_ACCOUNT, null, "");
        mainActivityIntent = new Intent(SigninActivity.this, MainActivity.class);
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
                    startActivity(mainActivityIntent);
                    prefManager.setSignin(true);
                    prefManager.setTypeAccount(user.getRole());
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

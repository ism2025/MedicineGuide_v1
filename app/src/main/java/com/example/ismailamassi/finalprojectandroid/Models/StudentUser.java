package com.example.ismailamassi.finalprojectandroid.Models;

import com.example.ismailamassi.finalprojectandroid.Control.SystemControl;
import com.example.ismailamassi.finalprojectandroid.Helper.Constants;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class StudentUser extends User implements Serializable {
    private String educationalFoundation;
    private static int count = 1;
    private String yearSplit;
    private String year = Calendar.getInstance().get(Calendar.YEAR) + "";

    public StudentUser(String name, String email, String password, String phoneNumber, int role, Date dob, String photoUrl) {
        super(name, email, password, phoneNumber, role, dob, photoUrl);
        yearSplit = year.substring(2, 4);
        if (role == Constants.STUDENT_ID) {
            if (count <= 99999) {
                String countWithZero = String.format(Locale.CANADA,"%04d", count);
                this.setId(Constants.STUDENT_ID + yearSplit + countWithZero);
                count++;
            } else if (count > 99999) {
                String countWithZero = String.format(Locale.CANADA,"%05d", count);
                this.setId(Constants.STUDENT_ID + yearSplit + countWithZero);
                count++;
            }
        }
        this.setEducationalFoundation(educationalFoundation);
        SystemControl.allStudents.add(this);
    }


    public String getEducationalFoundation() {
        return educationalFoundation;
    }

    public void setEducationalFoundation(String educationalInstitution) {
        this.educationalFoundation = educationalInstitution;
    }
}

/*
public class Id extends AppCompatActivity {

    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id);
        final TextView textView = findViewById(R.id.textView);
        Button btn = findViewById(R.id.button2);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}
 */

package com.example.ismailamassi.finalprojectandroid.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.EditText;
import android.widget.TextView;

public class Methods {
    Context context;

    public static String getStringFromEditText(EditText editText) {
        return editText.getText().toString().trim();
    }

    public static String getStringFromTextView(TextView textView) {
        return textView.getText().toString().trim();
    }

    public static String getStringFromResources(Context context, int RecID) {
        return context.getResources().getString(RecID);
    }


}

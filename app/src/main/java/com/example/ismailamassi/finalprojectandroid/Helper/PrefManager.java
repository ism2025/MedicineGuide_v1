package com.example.ismailamassi.finalprojectandroid.Helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Lincoln on 05/05/16.
 */
public class PrefManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    SharedPreferences prefTest;
    SharedPreferences.Editor editorTest;
    Context mContext;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name


    public PrefManager(Context context) {
        this.mContext = context;
        pref = mContext.getSharedPreferences(Constants.PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }


    public PrefManager(Context context, int x) {
        this.mContext = context;
        pref = PreferenceManager.getDefaultSharedPreferences(context);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(Constants.IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(Constants.IS_FIRST_TIME_LAUNCH, true);
    }

    public void setSignin(boolean isSignin) {
        editor.putBoolean(Constants.IS_SIGN_IN, isSignin);
        editor.commit();//apply();
    }

    public boolean isSignin() {
        return pref.getBoolean(Constants.IS_SIGN_IN, false);
    }

    public void setTypeAccount(int typeAccount) {
        editor.putInt(Constants.ROLE, typeAccount);
        editor.commit();//apply();

    }

    public int getTypeAccount() {
        return pref.getInt(Constants.ROLE, 0);
    }


    public void setEmailAccount(String emailAccount) {
        editor.putString(Constants.EMAIL, emailAccount);
        editor.commit();//apply();

    }

    public String getEmailAccount() {
        return pref.getString(Constants.EMAIL, "A/N");
    }


    public void setIdAccount(int idAccount) {
        editor.putInt(Constants.ID, idAccount);
        editor.commit();//apply();

    }

    public int getIdAccount() {
        return pref.getInt(Constants.ID, 0);
    }

}
package com.ergomotions.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.ergomotions.network.LoginResponse;
import com.google.gson.Gson;

public class PrefsUtil {

    private static final String USER_DATA = "com.ergomotions.USER_DATA";
    private static final String COMPANY_ID = "com.ergomotions.COMPANY_ID";
    private static final String PREF_NAME = "com.ergomotions.ERGOMOTIONS_PREFERENCES";
    private static PrefsUtil sInstance;
    private final SharedPreferences mPreferences;

    private PrefsUtil(Context context) {
        mPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static synchronized void initializeInstance(Context context) {
        if (sInstance == null) {
            sInstance = new PrefsUtil(context);
        }
    }

    public static synchronized PrefsUtil getInstance() {
        if (sInstance == null) {
            throw new IllegalStateException(PrefsUtil.class.getSimpleName() +
                    " is not initialized, call initializeInstance(..) method first.");
        }
        return sInstance;
    }

    public void setUserData(LoginResponse loginResponse) {
        getEditor().putString(USER_DATA, new Gson().toJson(loginResponse)).commit();
    }

    public void setCompanyId(int id) {
        getEditor().putInt(COMPANY_ID, id).commit();
    }

    public int getCompanyId() {
        return getPrefs().getInt(COMPANY_ID, 0);
    }

    public LoginResponse getUserData() {
        return new Gson().fromJson(getPrefs().getString(USER_DATA, ""), LoginResponse.class);
    }

    private SharedPreferences.Editor getEditor() {
        return mPreferences.edit();
    }

    private SharedPreferences getPrefs() {
        return mPreferences;
    }

}
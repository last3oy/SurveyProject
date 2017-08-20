package com.example.last3oy.surveyproject.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceUtil {

    private static SharedPreferenceUtil instance;


    public static SharedPreferenceUtil getInstance() {
        if (instance == null) {
            instance = new SharedPreferenceUtil();
        }
        return instance;
    }

    private SharedPreferenceUtil() {
    }

    private SharedPreferences mPreferences;

    public void init(Context context) {
        mPreferences = context.getSharedPreferences("survey_token_pref", Context.MODE_PRIVATE);
    }

    public String getAccessToken() {
        return mPreferences.getString("access_token", null);
    }

    public void putAccessToeken(String accessToken) {
        mPreferences.edit()
                .putString("access_token", accessToken)
                .apply();
    }


}

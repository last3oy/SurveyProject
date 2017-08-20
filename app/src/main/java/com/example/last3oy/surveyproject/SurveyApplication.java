package com.example.last3oy.surveyproject;

import android.app.Application;

import com.example.last3oy.surveyproject.util.SharedPreferenceUtil;

public class SurveyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SharedPreferenceUtil.getInstance().init(getApplicationContext());
    }
}

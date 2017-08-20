package com.example.last3oy.surveyproject.fragment.surveylist.presenter;

import com.example.last3oy.surveyproject.fragment.surveylist.SurveyPageContact;


public class SurveyPagePresenter implements SurveyPageContact.Presenter {

    private SurveyPageContact.View mView;

    public SurveyPagePresenter(SurveyPageContact.View view) {
        mView = view;
    }
}

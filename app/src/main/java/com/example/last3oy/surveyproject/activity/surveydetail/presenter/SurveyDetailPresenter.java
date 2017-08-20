package com.example.last3oy.surveyproject.activity.surveydetail.presenter;

import com.example.last3oy.surveyproject.activity.surveydetail.SurveyDetailContact;

public class SurveyDetailPresenter implements SurveyDetailContact.Presenter {

    private SurveyDetailContact.View mView;

    public SurveyDetailPresenter(SurveyDetailContact.View view) {
        mView = view;
    }
}

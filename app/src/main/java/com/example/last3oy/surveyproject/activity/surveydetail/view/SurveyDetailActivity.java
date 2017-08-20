package com.example.last3oy.surveyproject.activity.surveydetail.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.last3oy.surveyproject.R;
import com.example.last3oy.surveyproject.activity.surveydetail.SurveyDetailContact;
import com.example.last3oy.surveyproject.activity.surveydetail.presenter.SurveyDetailPresenter;

public class SurveyDetailActivity extends AppCompatActivity implements SurveyDetailContact.View {


    private SurveyDetailContact.Presenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_detail);

        mPresenter = new SurveyDetailPresenter(this);
    }
}

package com.example.last3oy.surveyproject.activity.surveylist.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.last3oy.surveyproject.R;
import com.example.last3oy.surveyproject.activity.surveylist.adapter.SurveyListAdapter;
import com.example.last3oy.surveyproject.activity.surveylist.SurveyListContact;
import com.example.last3oy.surveyproject.activity.surveylist.interactor.SurveyListInteractor;
import com.example.last3oy.surveyproject.activity.surveylist.presenter.SurveyListPresenter;
import com.example.last3oy.surveyproject.databinding.ActivitySurveyListBinding;
import com.example.last3oy.surveyproject.model.Survey;

import java.util.List;

public class SurveyListActivity extends AppCompatActivity
        implements SurveyListContact.View {

    private ActivitySurveyListBinding mBinding;

    private SurveyListPresenter mPresenter;
    private SurveyListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_survey_list);

        mPresenter = new SurveyListPresenter(this, new SurveyListInteractor());

        mAdapter = new SurveyListAdapter(getSupportFragmentManager());
        mBinding.vpSurveys.setAdapter(mAdapter);
        mBinding.indicatorPage.setViewPager(mBinding.vpSurveys);

        mBinding.ivRefresh.setOnClickListener(v -> fetchSurvey());

    }

    @Override
    protected void onStart() {
        super.onStart();
        fetchSurvey();
    }

    private void fetchSurvey() {
        mBinding.progressBar.setVisibility(View.VISIBLE);
        mPresenter.fetchSurvey();
    }

    @Override
    public void showSurveyList(List<Survey> surveys) {
        mAdapter.setSurveys(surveys);
    }

    @Override
    public void hideProgressBar() {
        mBinding.progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mPresenter.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mPresenter.onRestoreInstanceState(savedInstanceState);
    }
}

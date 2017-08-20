package com.example.last3oy.surveyproject.activity.surveylist;

import com.example.last3oy.surveyproject.base.BaseInteractor;
import com.example.last3oy.surveyproject.base.BasePresenter;
import com.example.last3oy.surveyproject.model.Survey;

import java.util.List;

import io.reactivex.Single;

public interface SurveyListContact {

    interface View {

        void showSurveyList(List<Survey> surveys);

        void hideProgressBar();

        void showProgressBar();
    }

    interface Presenter extends BasePresenter {

        void fetchSurvey();

    }

    interface Interactor extends BaseInteractor {

        Single<List<Survey>> getFetchSurveyList(Integer page, Integer perPage, String accessToken);

    }

}

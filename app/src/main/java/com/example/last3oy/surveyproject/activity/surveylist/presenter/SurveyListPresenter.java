package com.example.last3oy.surveyproject.activity.surveylist.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.last3oy.surveyproject.model.Constant;
import com.example.last3oy.surveyproject.activity.surveylist.SurveyListContact;
import com.example.last3oy.surveyproject.model.Survey;

import org.parceler.Parcels;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class SurveyListPresenter implements SurveyListContact.Presenter {

    private final String SURVEYS_KEY = "SURVEYS_KEY";

    private final String LOG_TAG = SurveyListPresenter.class.getName();

    private SurveyListContact.View mView;
    private SurveyListContact.Interactor mInteractor;

    private List<Survey> surveys;
    private Disposable mSubscription;


    public SurveyListPresenter(SurveyListContact.View view, SurveyListContact.Interactor interactor) {
        mView = view;
        mInteractor = interactor;
    }


    @Override
    public void fetchSurvey() {
        mView.showProgressBar();

        if (mSubscription != null && !mSubscription.isDisposed()) {
            mSubscription.dispose();
        }


        mSubscription = mInteractor.getFetchSurveyList(null, null, mInteractor.getAccessToken())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleFetchSurveyListResponse,
                        this::handleError);

    }

    private void handleFetchSurveyListResponse(List<Survey> surveys) {
        this.surveys = surveys;
        mView.hideProgressBar();
        mView.showSurveyList(surveys);
    }

    private void handleError(Throwable throwable) {
        mView.hideProgressBar();
        String errMsg = throwable.getMessage();
        Log.e(LOG_TAG, errMsg);
        if (errMsg != null && errMsg.contains(Constant.HTTP_UNAUTHORIZED)) {
            mInteractor.getFetchToken(Constant.GRANT_TPYE, Constant.USERNAME, Constant.PASSWORD)
                    .subscribe((surveyAccessToken, _throwable) -> {
                        if (surveyAccessToken != null) {
                            mInteractor.putAccessToken(surveyAccessToken.getAccessToken());
                            fetchSurvey();
                        }
                    });
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelable(SURVEYS_KEY, Parcels.wrap(surveys));
    }

    @Override
    public void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        surveys = Parcels.unwrap(savedInstanceState.getParcelable(SURVEYS_KEY));
        mView.showSurveyList(surveys);
    }
}

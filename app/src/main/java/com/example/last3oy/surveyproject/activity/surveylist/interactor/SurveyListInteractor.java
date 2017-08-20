package com.example.last3oy.surveyproject.activity.surveylist.interactor;

import com.example.last3oy.surveyproject.util.SharedPreferenceUtil;
import com.example.last3oy.surveyproject.activity.surveylist.SurveyListContact;
import com.example.last3oy.surveyproject.util.http.SurveyApiManager;
import com.example.last3oy.surveyproject.model.Survey;
import com.example.last3oy.surveyproject.model.SurveyAccessToken;

import java.util.List;

import io.reactivex.Single;

public class SurveyListInteractor implements SurveyListContact.Interactor {

    @Override
    public Single<List<Survey>> getFetchSurveyList(Integer page, Integer perPage, String accessToken) {
        return SurveyApiManager.getInstance().getService().loadSurveys(page, perPage, accessToken);
    }

    @Override
    public Single<SurveyAccessToken> getFetchToken(String grantType, String username, String password) {
        return SurveyApiManager.getInstance().getService().fetchToken(grantType, username, password);
    }

    @Override
    public String getAccessToken() {
        return SharedPreferenceUtil.getInstance().getAccessToken();
    }

    @Override
    public void putAccessToken(String accessToken) {
        SharedPreferenceUtil.getInstance().putAccessToeken(accessToken);
    }


}

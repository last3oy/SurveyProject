package com.example.last3oy.surveyproject.base;

import com.example.last3oy.surveyproject.model.Survey;
import com.example.last3oy.surveyproject.model.SurveyAccessToken;

import java.util.List;

import io.reactivex.Single;

public interface BaseInteractor {


    Single<SurveyAccessToken> getFetchToken(String grantType, String username, String password);

    String getAccessToken();

    void putAccessToken(String accessToken);

}

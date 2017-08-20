package com.example.last3oy.surveyproject.util.http;

import com.example.last3oy.surveyproject.model.Survey;
import com.example.last3oy.surveyproject.model.SurveyAccessToken;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface SurveyApiService {


    @FormUrlEncoded
    @POST("oauth/token")
    Single<SurveyAccessToken> fetchToken(@Field("grant_type") String grantType,
                                         @Field("username") String username,
                                         @Field("password") String password);



    @GET("surveys.json")
    Single<List<Survey>> loadSurveys(@Query("page") Integer page,
                                     @Query("per_page") Integer perPage,
                                     @Query("access_token") String accessToken);
}

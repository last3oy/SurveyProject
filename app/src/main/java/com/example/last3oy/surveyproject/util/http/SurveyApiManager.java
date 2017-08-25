package com.example.last3oy.surveyproject.util.http;

import com.example.last3oy.surveyproject.BuildConfig;

import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class SurveyApiManager {

    private static SurveyApiManager instance;

    public static SurveyApiManager getInstance() {
        if (instance == null) {
            instance = new SurveyApiManager();
        }
        return instance;
    }

    private SurveyApiService mService;

    private SurveyApiManager() {

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BuildConfig.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build();

        mService = retrofit.create(SurveyApiService.class);
    }


    public SurveyApiService getService() {
        return mService;
    }
}

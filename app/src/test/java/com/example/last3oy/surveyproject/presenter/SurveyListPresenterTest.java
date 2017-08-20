package com.example.last3oy.surveyproject.presenter;

import com.example.last3oy.surveyproject.activity.surveylist.SurveyListContact;
import com.example.last3oy.surveyproject.activity.surveylist.presenter.SurveyListPresenter;
import com.example.last3oy.surveyproject.model.Survey;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import io.reactivex.Single;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.schedulers.Schedulers;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SurveyListPresenterTest {

    @Mock
    SurveyListContact.View mView;

    @Mock
    SurveyListContact.Interactor mInteractor;

    SurveyListPresenter mPresenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(schedulerCallable -> Schedulers.trampoline());

        mPresenter = new SurveyListPresenter(mView, mInteractor);
    }


    @Test
    public void Should_ShowSurveyList_When_FetchSuccess() throws Exception {
        when(mInteractor.getFetchSurveyList(anyInt(), anyInt(), anyString())).thenReturn(Single.just(new ArrayList<>()));

        mPresenter.fetchSurvey();
        verify(mView).showProgressBar();
        verify(mView).showSurveyList(anyListOf(Survey.class));
    }

    @Test
    public void Should_HideProgressBar_When_FetchError() throws Exception {
        when(mInteractor.getFetchSurveyList(anyInt(),anyInt(),anyString())).thenReturn(Single.error(new Throwable()));

        mPresenter.fetchSurvey();
        verify(mView).hideProgressBar();
    }
}

package com.example.last3oy.surveyproject.activity;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.last3oy.surveyproject.R;
import com.example.last3oy.surveyproject.activity.surveylist.view.SurveyListActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class SurveyListActivityTest {

    @Rule
    public ActivityTestRule<SurveyListActivity> mSurveyListActivityTestRule =
            new ActivityTestRule<>(SurveyListActivity.class);

    @Test
    public void should_toolbarShow_when_openActivity() throws Exception {
        onView(withId(R.id.llToolbar)).check(matches(isDisplayed()));

        onView(withId(R.id.tvTitle)).check(matches(isDisplayed()));

        onView(withId(R.id.ivMenu)).check(matches(isDisplayed()));

        onView(withId(R.id.ivRefresh)).check(matches(isDisplayed()));

    }

    @Test
    public void should_progressBarHide_when_openActivity() throws Exception {
        onView(withId(R.id.tvTitle)).check(matches(withText(R.string.toolbar_surveys)));
    }

}

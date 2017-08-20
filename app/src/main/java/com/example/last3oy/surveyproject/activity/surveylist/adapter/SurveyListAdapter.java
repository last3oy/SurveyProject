package com.example.last3oy.surveyproject.activity.surveylist.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.last3oy.surveyproject.fragment.surveylist.view.SurveyPageFragment;
import com.example.last3oy.surveyproject.model.Survey;

import java.util.ArrayList;
import java.util.List;

public class SurveyListAdapter extends FragmentStatePagerAdapter {

    private List<Survey> surveys;

    public SurveyListAdapter(FragmentManager fm) {
        super(fm);
        surveys = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return SurveyPageFragment.newInstance(surveys.get(position));
    }

    @Override
    public int getCount() {
        if (surveys == null)
            return 0;

        return surveys.size();
    }

    public List<Survey> getSurveys() {
        return surveys;
    }

    public void setSurveys(List<Survey> surveys) {
        this.surveys = surveys;
        notifyDataSetChanged();
    }
}

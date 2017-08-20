package com.example.last3oy.surveyproject.fragment.surveylist.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.last3oy.surveyproject.R;
import com.example.last3oy.surveyproject.activity.surveydetail.SurveyDetailContact;
import com.example.last3oy.surveyproject.activity.surveydetail.view.SurveyDetailActivity;
import com.example.last3oy.surveyproject.databinding.FragmentSurveyPageBinding;
import com.example.last3oy.surveyproject.fragment.surveylist.SurveyPageContact;
import com.example.last3oy.surveyproject.model.Survey;

import org.parceler.Parcels;


public class SurveyPageFragment extends Fragment implements SurveyPageContact.View {

    public static final String SURVEY_KEY = "SURVEY_KEY";

    private FragmentSurveyPageBinding mBinding;

    public static SurveyPageFragment newInstance(Survey survey) {
        Bundle args = new Bundle();
        args.putParcelable(SURVEY_KEY, Parcels.wrap(survey));
        SurveyPageFragment fragment = new SurveyPageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_survey_page, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Survey survey = Parcels.unwrap(getArguments().getParcelable(SURVEY_KEY));

        mBinding.tvName.setText(survey.getTitle());
        mBinding.tvDescription.setText(survey.getDescription());

        Glide.with(this)
                .load(survey.getCoverImageUrl() + "l")
                .into(mBinding.ivBackground);

        mBinding.btnTakeSurvey.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), SurveyDetailActivity.class);
            startActivity(intent);
        });

    }
}

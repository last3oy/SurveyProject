package com.example.last3oy.surveyproject.custom.transform;


import android.support.v4.view.ViewPager;
import android.view.View;

public class VerticalPageTransformer implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View page, float position) {
        float alpha = 0;
        float yPosition = position * page.getHeight();

        if (position >= -1 && position <= 1) {
            alpha = 1;
        }

        page.setAlpha(alpha);
        page.setTranslationX(page.getWidth() * (-position));
        page.setTranslationY(yPosition);

    }
}


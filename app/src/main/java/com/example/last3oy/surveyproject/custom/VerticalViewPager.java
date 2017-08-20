package com.example.last3oy.surveyproject.custom;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.example.last3oy.surveyproject.custom.transform.VerticalPageTransformer;

public class VerticalViewPager extends ViewPager {

    public VerticalViewPager(Context context) {
        super(context);
        initInstances();
    }


    public VerticalViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInstances();
    }

    private void initInstances() {
        setPageTransformer(false, new VerticalPageTransformer());
        setOverScrollMode(OVER_SCROLL_NEVER);
    }


    private MotionEvent swapTouchEvent(MotionEvent event) {
        float width = getWidth();
        float height = getHeight();
        float swappedX = (event.getY() / height) * width;
        float swappedY = (event.getX() / width) * height;
        event.setLocation(swappedX, swappedY);
        return event;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        boolean intercept = super.onInterceptTouchEvent(swapTouchEvent(event));
        swapTouchEvent(event);
        return intercept;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(swapTouchEvent(ev));
    }
}

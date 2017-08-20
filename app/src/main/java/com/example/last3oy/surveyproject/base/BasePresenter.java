package com.example.last3oy.surveyproject.base;

import android.os.Bundle;
import android.support.annotation.NonNull;

public interface BasePresenter {

    void onSaveInstanceState(@NonNull Bundle outState);

    void onRestoreInstanceState(@NonNull Bundle savedInstanceState);

}

package com.example.vaddiapp.ui.calculator;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CalViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CalViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is calculator fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
package com.fahim.mobileapplicationdevelopment_labwork;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<String> message = new MutableLiveData<>();

    public void setMessage(String msg) {
        message.setValue(msg);
    }

    public LiveData<String> getMessage() {
        return message;
    }
}

package com.fahim.mobileapplicationdevelopment_labwork;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private MutableLiveData<String> liveDataMutable = new MutableLiveData<>();
    public LiveData<String> liveData = liveDataMutable;

    public void sendToModel(String string) {
        liveDataMutable.setValue(string);
    }
}

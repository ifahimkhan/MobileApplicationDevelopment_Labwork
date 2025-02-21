package com.fahim.mobileapplicationdevelopment_labwork;

import android.content.Context;

public interface Storage {
    void writeToFile(String data, Context context);

    String readFromFile(Context context);
}

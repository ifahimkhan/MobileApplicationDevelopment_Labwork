package com.fahim.mobileapplicationdevelopment_labwork;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesStorage {

    private static final String SHARED_PREFS = "userPrefs";

    private static final String KEY_DATA = "KEY_DATA";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public SharedPreferencesStorage(Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveUserData(String data) {
        editor.putString(KEY_DATA, data);
        editor.apply();
    }

    public String fetchUserData() {
        return sharedPreferences.getString(KEY_DATA, "No Data Found");
    }

    public void clearUserData() {
        editor.clear();
        editor.apply();
    }
}

package com.fahim.mobileapplicationdevelopment_labwork;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKeys;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class EncryptedSharedPreferenceStorage {

    private static final String KEY_DATA = "KEY_DATA";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public EncryptedSharedPreferenceStorage(Context context) {
        String masterKeyAlias = null;
        try {
            masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC);
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            sharedPreferences = EncryptedSharedPreferences.create(
                    "secret_shared_prefs",
                    masterKeyAlias,
                    context,
                    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            );

            editor = sharedPreferences.edit();
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

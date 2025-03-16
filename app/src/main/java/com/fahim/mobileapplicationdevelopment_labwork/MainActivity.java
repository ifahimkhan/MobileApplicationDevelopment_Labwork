package com.fahim.mobileapplicationdevelopment_labwork;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void attachBaseContext(Context newBase) {
        Log.e("TAG", "attachBaseContext: ");
        ContextUtils.updateLocale(newBase, Locale.forLanguageTag("ar"));
        super.attachBaseContext(newBase);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("TAG", "onCreate: ");

    }
}
package com.fahim.mobileapplicationdevelopment_labwork;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = SecondActivity.class.getName();

    public static void getInstance(Context context) {
        context.startActivity(new Intent(context, SecondActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.w(TAG, "onCreate: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.w(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.w(TAG, "onStop: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.w(TAG, "onRestart: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w(TAG, "onDestroy: ");
    }
}
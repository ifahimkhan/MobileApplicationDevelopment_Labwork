package com.fahim.mobileapplicationdevelopment_labwork;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new FirstFragment())
                .commit();

        findViewById(R.id.btnFirst).setOnClickListener(v ->
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new FirstFragment())
                        .commit()
        );

        findViewById(R.id.btnSecond).setOnClickListener(v ->
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new SecondFragment())
                        .commit()
        );
    }
}

package com.fahim.mobileapplicationdevelopment_labwork;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if (findViewById(R.id.container_one) != null) {
            // LANDSCAPE: show both fragments
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_one, new FragmentOne())
                    .replace(R.id.container_two, new FragmentTwo())
                    .commit();
        } else {
            // PORTRAIT: show one fragment
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_container, new FragmentOne())
                    .commit();
            findViewById(R.id.btnFirst).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_container, new FragmentOne())
                            .commit();
                }
            });
            findViewById(R.id.btnSecond).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_container, new FragmentTwo())
                            .commit();
                }
            });
        }
    }
}


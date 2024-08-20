package com.fahim.mobileapplicationdevelopment_labwork;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomCircleView customCircleView = findViewById(R.id.customCircleView);

        customCircleView.setCircleColor(Color.RED);
        customCircleView.setCircleRadius(150f);

        Spinner colorSpinner = findViewById(R.id.spinner_color);
        SeekBar seekBar = findViewById(R.id.seekBar);
        ArrayList<String> colorList = new ArrayList<>();
        colorList.add("Green");
        colorList.add("RED");
        colorList.add("BLUE");
        colorList.add("YELLOW");

        ArrayAdapter<String> colorAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, colorList);
        colorSpinner.setAdapter(colorAdapter);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                customCircleView.setCircleRadius(progress * 20f);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        colorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        customCircleView.setCircleColor(Color.GREEN);
                        break;
                    case 1:
                        customCircleView.setCircleColor(Color.RED);
                        break;
                    case 2:
                        customCircleView.setCircleColor(Color.BLUE);
                        break;
                    case 3:
                        customCircleView.setCircleColor(Color.YELLOW);
                        break;
                    default:
                        customCircleView.setCircleColor(Color.BLUE);
                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
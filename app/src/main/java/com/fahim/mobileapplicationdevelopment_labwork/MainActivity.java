package com.fahim.mobileapplicationdevelopment_labwork;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = findViewById(R.id.radiogroup);
        submit = findViewById(R.id.button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton selectedRadioButton = findViewById(radioGroup.getCheckedRadioButtonId());
                String selectedAnswer = selectedRadioButton.getText().toString();
                Intent kushiIntent = new Intent(MainActivity.this, SecondActivity.class);
                kushiIntent.putExtra("selectedAnswer", selectedAnswer);
                startActivity(kushiIntent);




            }
        });



    }
}
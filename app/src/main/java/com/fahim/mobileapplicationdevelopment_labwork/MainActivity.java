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
    private Button button;
    private Spinner spinner;
    private ArrayList<String> subjects = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = findViewById(R.id.radioGroup);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedItem =spinner.getSelectedItem().toString();
                RadioButton radioButton = findViewById(radioGroup.getCheckedRadioButtonId());
                String selectedOption = radioButton.getText().toString();
                // Do something with the selected option
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("selectedAnswer",selectedOption);
                intent.putExtra("selectedItem",selectedItem);
                startActivity(intent);

            }
        });
        subjects.add("MAD");
        subjects.add("SE");
        subjects.add("AI");
        subjects.add("OS");
        spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,subjects);
        spinner.setAdapter(adapter);




    }
}
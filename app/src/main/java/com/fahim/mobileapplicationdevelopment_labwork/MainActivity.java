package com.fahim.mobileapplicationdevelopment_labwork;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.date);
    }

    public void showDialog(View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this);
        datePickerDialog.show();
        datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                textView.setText("Date"+dayOfMonth+"/"+(month+1)+"/"+year);
            }
        });


    }

    public void showNextScreen(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("DateSelected", textView.getText().toString());
        startActivity(intent);
    }

    public void launchCamera(View view) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivityForResult(intent,100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100){
            textView.setText("Image Captured");
        }
    }
}
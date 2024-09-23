package com.fahim.mobileapplicationdevelopment_labwork;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FileReadWriteActivity extends AppCompatActivity {


    private EditText editText;
    private TextView textView;
    private SharedPreferencesStorage sharedPreferencesStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_read_write);
        sharedPreferencesStorage = new SharedPreferencesStorage(this);
        editText = findViewById(R.id.textInputEditText);
        textView = findViewById(R.id.textView);
    }

    public void readData(View view) {
        String data = sharedPreferencesStorage.fetchUserData();
        textView.setText(data);
    }

    public void writeData(View view) {
        String data = editText.getText().toString()+"\n";
       sharedPreferencesStorage.saveUserData(data);
    }
}
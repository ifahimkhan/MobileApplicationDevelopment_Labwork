package com.fahim.mobileapplicationdevelopment_labwork;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private EditText editText;
    private TextView textView;
    private InternalStorage internalStorage = new InternalStorage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.textInputEditText);
        textView = findViewById(R.id.textView);
    }

    public void readData(View view) {
        String data = internalStorage.readFromFile(this);
        textView.setText(data);
    }

    public void writeData(View view) {
        String data = editText.getText().toString();
        internalStorage.writeToFile(data, this);
    }
}
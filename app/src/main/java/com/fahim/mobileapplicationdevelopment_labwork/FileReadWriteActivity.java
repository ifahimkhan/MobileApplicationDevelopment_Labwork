package com.fahim.mobileapplicationdevelopment_labwork;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FileReadWriteActivity extends AppCompatActivity {


    private EditText editText;
    private TextView textView;
    private InternalStorage internalStorage = new InternalStorage();
    private String selectedDate, selectedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_read_write);
        editText = findViewById(R.id.textInputEditText);
        textView = findViewById(R.id.textView);
        selectedDate = getIntent().getStringExtra("selectedDate");
        selectedTime = getIntent().getStringExtra("selectedTime");
    }

    public void readData(View view) {
        String data = internalStorage.readFromFile(this);
        textView.setText(data);
    }

    public void writeData(View view) {
        String data = editText.getText().toString()+"\n";
        data = data + selectedDate +"\n"+ selectedTime;
        internalStorage.writeToFile(data, this);
    }
}
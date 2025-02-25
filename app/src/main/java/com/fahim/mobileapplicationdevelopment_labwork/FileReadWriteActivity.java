package com.fahim.mobileapplicationdevelopment_labwork;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FileReadWriteActivity extends AppCompatActivity {


    private EditText editText;
    private TextView textView;
    private Storage storage = null;
    private String selectedDate, selectedTime;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_read_write);
        editText = findViewById(R.id.textInputEditText);
        textView = findViewById(R.id.textView);
        radioGroup = findViewById(R.id.radioGroup);
        selectedDate = getIntent().getStringExtra("selectedDate");
        selectedTime = getIntent().getStringExtra("selectedTime");
    }

    private void initStorage() {
        if (radioGroup.getCheckedRadioButtonId() == R.id.radioInternal) {
            storage = new InternalStorage();
        } else if (radioGroup.getCheckedRadioButtonId() == R.id.radioExternal) {
            storage = new ExternalStorage();
        }
    }

    public void readData(View view) {
        initStorage();
        String data = storage.readFromFile(this);
        textView.setText(data);
    }


    public void writeData(View view) {
        initStorage();
        String data = editText.getText().toString() + "\n";
        data = data + selectedDate + "\n" + selectedTime;
        storage.writeToFile(data, this);
    }
}
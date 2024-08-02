package com.fahim.mobileapplicationdevelopment_labwork;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CheckBoxesActivity extends AppCompatActivity {

    private CheckBox checkBox1, checkBox2, checkBox3;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_boxes);

        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(v -> {
            StringBuilder result = new StringBuilder();
            result.append("Selected: ");

            if (checkBox1.isChecked()) {
                result.append(checkBox1.getText()).append(" ");
            }
            if (checkBox2.isChecked()) {
                result.append(checkBox2.getText()).append(" ");
            }
            if (checkBox3.isChecked()) {
                result.append(checkBox3.getText()).append(" ");
            }

            textView.setText(result.toString().trim());
        });
    }
}

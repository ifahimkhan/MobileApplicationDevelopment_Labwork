package com.fahim.mobileapplicationdevelopment_labwork;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etNumber1, etNumber2;
    Spinner spinnerOperators;
    Button equalBtn;
    TextView resultTextview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumber1 = findViewById(R.id.etNumber1);
        etNumber2 = findViewById(R.id.etNumber2);
        spinnerOperators = findViewById(R.id.spinnerOperators);
        equalBtn = findViewById(R.id.equalBtn);
        resultTextview = findViewById(R.id.resultTextview);

        ArrayList<String> operators = new ArrayList<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, R.layout.row_dropdown, R.id.item, operators);
        spinnerOperators.setAdapter(adapter);

        equalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number1 = etNumber1.getText().toString();
                String number2 = etNumber2.getText().toString();
                String operator = spinnerOperators.getSelectedItem().toString();

                if (TextUtils.isEmpty(number1)) {
                    etNumber1.setError("Please enter a number");
                    return;
                }
                if (TextUtils.isEmpty(number2)) {
                    etNumber2.setError("Please enter a number");
                    return;
                }

                double num1 = Double.parseDouble(number1);
                double num2 = Double.parseDouble(number2);
                double result = 0;

                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            Toast.makeText(MainActivity.this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Invalid operator", Toast.LENGTH_SHORT).show();
                        return;
                }
                resultTextview.setText(String.valueOf(result));


            }
        });


    }
}
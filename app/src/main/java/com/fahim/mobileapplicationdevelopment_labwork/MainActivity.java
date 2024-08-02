package com.fahim.mobileapplicationdevelopment_labwork;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private EditText editText;
    private Button btnIsEven, btnIsPrime;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editTextNum);
        btnIsEven = findViewById(R.id.btnIsEven);
        btnIsPrime = findViewById(R.id.btnFactorial);
        textViewResult = findViewById(R.id.textResult);


    }

    public void checkNumberFactorial(View view) {
        String readEditTextString = editText.getText().toString();
        if (TextUtils.isEmpty(readEditTextString)) {
            editText.setError("Field should not be empty!");
            return;
        }
        int enteredNumber = Integer.parseInt(readEditTextString);
        int factorial = 1;
        for (int i = 1; i <= enteredNumber; i++) {
            factorial *= i;
        }
        textViewResult.setText("Factorial of " + enteredNumber + " is " + factorial);
    }

    public void checkNumberIsEven(View view) {
        String readEditTextString = editText.getText().toString();
        if (TextUtils.isEmpty(readEditTextString)) {
            editText.setError("Field should not be empty!");
            return;
        }
        int enteredNumber = Integer.parseInt(readEditTextString);
        if (enteredNumber % 2 == 0) {
            textViewResult.setText(enteredNumber + " is even");
        } else {
            textViewResult.setText(enteredNumber + " is odd");
        }

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("result",textViewResult.getText().toString());

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        textViewResult.setText(savedInstanceState.getString("result"));
    }
}
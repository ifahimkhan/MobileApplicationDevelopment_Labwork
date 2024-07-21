package com.fahim.mobileapplicationdevelopment_labwork;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText number1, number2;
    private Button equal;
    private TextView result;
    private Spinner operators;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        equal = findViewById(R.id.equal);
        result = findViewById(R.id.result);
        operators = findViewById(R.id.operators);
        ArrayList<String> operatorList = new ArrayList<>();
        operatorList.add("+");
        operatorList.add("-");
        operatorList.add("*");
        operatorList.add("/");
        ArrayAdapter<String> adaper = new ArrayAdapter<>(this, R.layout.row_dropdown,R.id.item, operatorList);
        operators.setAdapter(adaper);
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard(MainActivity.this);
                String num1 = number1.getText().toString();
                String num2 = number2.getText().toString();
                String operator = operators.getSelectedItem().toString();
                if (TextUtils.isEmpty(num1)){
                    number1.setError("Field cannot be empty");
                    Toast.makeText(MainActivity.this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(num2)){
                    number2.setError("Field cannot be empty");
                    Toast.makeText(MainActivity.this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                int num1Int = Integer.parseInt(num1);
                int num2Int = Integer.parseInt(num2);
                int resultInt = 0;
                switch (operator) {
                    case "+":
                        resultInt = num1Int + num2Int;
                        break;
                    case "-":
                        resultInt = num1Int - num2Int;
                        break;
                    case "*":
                        resultInt = num1Int * num2Int;
                        break;
                    case "/":
                        resultInt = num1Int / num2Int;
                        break;
                }
                result.setText(resultInt + "");
            }
        });


    }

    public static void hideKeyboard(Context context) {
        View view = ((Activity) context).getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }
}
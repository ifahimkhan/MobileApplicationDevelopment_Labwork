package com.fahim.mobileapplicationdevelopment_labwork;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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


    private  EditText userNameEditText, passwordEditText, confirmPasswordEditText,
            emailEditText, phoneNumberEditText, addressEditText;
    private Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userNameEditText = findViewById(R.id.editTextUserName);
        passwordEditText = findViewById(R.id.editTextTextPassword);
        confirmPasswordEditText = findViewById(R.id.editTextTextPassword2);
        emailEditText = findViewById(R.id.editTextTextEmailAddress);
        phoneNumberEditText = findViewById(R.id.editTextPhone);
        addressEditText = findViewById(R.id.editTextTextMultiLine);
        submitButton = findViewById(R.id.button);





    }

    public void printDataInLog(View view) {
        Log.e("TAG", "userName: "+userNameEditText.getText().toString());
        Log.e("TAG", "password: "+passwordEditText.getText().toString());
        Log.e("TAG", "confirmPassword: "+confirmPasswordEditText.getText().toString());
        Log.e("TAG", "email: "+emailEditText.getText().toString());
        Log.e("TAG", "phoneNumber: "+phoneNumberEditText.getText().toString());
        Log.e("TAG", "Address: "+addressEditText.getText().toString());

        String EnteredData = userNameEditText.getText().toString()+"\n"+passwordEditText.getText().toString()+"\n"+
                confirmPasswordEditText.getText().toString()+"\n"+emailEditText.getText().toString()+"\n"+
                phoneNumberEditText.getText().toString()+"\n"+addressEditText.getText().toString();

        startActivity(new Intent(this, SecondActivity.class).putExtra("data", EnteredData));

    }
}
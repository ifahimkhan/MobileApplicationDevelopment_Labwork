package com.fahim.mobileapplicationdevelopment_labwork;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    EditText editText;
    private ActivityResultLauncher<Intent> secondActivityResultLauncher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        secondActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult activityResult) {
                        if (activityResult.getResultCode() == Activity.RESULT_OK) {
                            Intent data = activityResult.getData();
                            if (data != null) {
                                String returnedResult = data.getStringExtra("data");
                                editText.setText(returnedResult);
                            }
                        }
                    }
                }
        );
        editText = findViewById(R.id.editTextText);
    }

    public void send(View view) {
        String dataEntered = editText.getText().toString();
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("data", dataEntered);
        secondActivityResultLauncher.launch(intent);
    }

    public void startService(View view) {
        String dataEntered = editText.getText().toString();
        Intent intent = new Intent(MainActivity.this, MyService.class);
        intent.putExtra("data", dataEntered);
        startService(intent);
    }
}
package com.fahim.mobileapplicationdevelopment_labwork;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView showSurname;
    ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editTextText);
        showSurname = findViewById(R.id.showSurname);
        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult o) {

                        Intent data = o.getData();
                        if (data != null) {
                            String fullName = data.getStringExtra("FullName");
                            showSurname.setText(fullName);
                        }
                    }
                });

    }

    public void gotoFullNameActivity(View view) {
        String firstName = editText.getText().toString();
        Intent intent = new Intent(this, FullNameActivity.class);
        intent.putExtra("firstName", firstName);
        launcher.launch(intent);


    }
}
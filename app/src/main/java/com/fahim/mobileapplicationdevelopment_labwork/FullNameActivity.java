package com.fahim.mobileapplicationdevelopment_labwork;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FullNameActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    TextView firstnameTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_full_name);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String firstName = getIntent().getStringExtra("firstName");
        firstnameTextView = findViewById(R.id.textView2);
        firstnameTextView.setText(firstName);

        editText = findViewById(R.id.editTextText2);
        button = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname = firstnameTextView.getText().toString();
                String surname = editText.getText().toString();
                String fullName = firstname + " " + surname;
                Toast.makeText(FullNameActivity.this, fullName, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.putExtra("FullName",fullName);
                setResult(RESULT_OK,intent);
                finish();
            }
        });


    }
}
package com.fahim.mobileapplicationdevelopment_labwork;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView textView = findViewById(R.id.textView2);
        String selectedAnswer = getIntent().getStringExtra("selectedAnswer");
        textView.setText(selectedAnswer);

        if (selectedAnswer.equalsIgnoreCase("James Gosling")){
            textView.setTextColor(ContextCompat.getColor(this, R.color.darkgreen));
        }else{
            textView.setTextColor(ContextCompat.getColor(this, R.color.darkred));
        }


    }
}
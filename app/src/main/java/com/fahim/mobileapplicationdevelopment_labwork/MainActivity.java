package com.fahim.mobileapplicationdevelopment_labwork;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.fahim.mobileapplicationdevelopment_labwork.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {



    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mainViewModel= new ViewModelProvider(this).get(MainViewModel.class);
        mainViewModel.liveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String data) {
                binding.textView.setText(data);
            }
        });
        binding.edittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mainViewModel.sendToModel(s.toString());
            }
        });

    }
}
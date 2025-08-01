package com.fahim.mobileapplicationdevelopment_labwork;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class FragmentOne extends Fragment {
    private SharedViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        EditText editText = view.findViewById(R.id.editTextMessage);
        Button button = view.findViewById(R.id.btnSend);

        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        button.setOnClickListener(v -> {
            String text = editText.getText().toString();
            viewModel.setMessage(text);
        });

        return view;
    }
}

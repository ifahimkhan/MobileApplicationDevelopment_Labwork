package com.fahim.mobileapplicationdevelopment_labwork;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class FragmentTwo extends Fragment {
    private SharedViewModel viewModel;
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        textView = view.findViewById(R.id.textViewReceived);

        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        viewModel.getMessage().observe(getViewLifecycleOwner(), msg -> {
            textView.setText(msg);
        });

        return view;
    }
}

package com.fahim.mobileapplicationdevelopment_labwork;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        Button btn = view.findViewById(R.id.secondButton);
        btn.setOnClickListener(v -> 
            Toast.makeText(getActivity(), "Second Fragment", Toast.LENGTH_SHORT).show()
        );
        return view;
    }
}

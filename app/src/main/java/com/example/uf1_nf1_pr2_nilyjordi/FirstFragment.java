package com.example.uf1_nf1_pr2_nilyjordi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

public class FirstFragment extends Fragment {

    private Button openSecondFragmentButton;
    private SharedViewModel sharedViewModel;
    private TextView DataReceived;
    private EditText DataToSend;
    private Button SendData;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        DataToSend = view.findViewById(R.id.DataToSend);
        SendData = view.findViewById(R.id.SendData);
        DataReceived = view.findViewById(R.id.DataReceived);

        openSecondFragmentButton = view.findViewById(R.id.open_second_fragment_button);
        openSecondFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new SecondFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);

        sharedViewModel.getData().observe(getViewLifecycleOwner(), newDataReceived -> {
                    DataReceived.setText(newDataReceived);
                }
        );

        SendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedViewModel.setData(
                        DataToSend.getText().toString()
                );
                DataReceived.setText(
                        DataToSend.getText().toString()
                );
            }
        });
        return view;
    }
}

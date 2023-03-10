package com.example.uf1_nf1_pr2_nilyjordi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SecondFragment extends Fragment {

    private EditText dataEditText;
    private Button sendDataButton;
    private DatabaseReference databaseReference;
    private TextView DataReceived2;
    private SharedViewModel sharedViewModel2;
    private EditText DataToSend2;
    private Button SendData2;

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        dataEditText = view.findViewById(R.id.data_edit_text);
        sendDataButton = view.findViewById(R.id.send_data_button);
        DataReceived2 = view.findViewById(R.id.DataReceived2);
        DataToSend2 = view.findViewById(R.id.DataToSend2);
        SendData2 = view.findViewById(R.id.SendData2);

        sharedViewModel2 = new ViewModelProvider(this).get(SharedViewModel.class);

        sharedViewModel2.getData().observe(getViewLifecycleOwner(), newDataReceived -> {
                    DataReceived2.setText(newDataReceived);
                }
        );

        databaseReference = FirebaseDatabase.getInstance().getReference();

        SendData2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataReceived2.setText(
                        DataToSend2.getText().toString()
                );
                sharedViewModel2.setData(
                        DataToSend2.getText().toString()
                );
            }
        });

        sendDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = dataEditText.getText().toString();
                databaseReference.child("data").setValue(data);
                Toast.makeText(requireContext(), "Data sent!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}

package com.example.uf1_nf1_pr2_nilyjordi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;

public class SecondActivity extends AppCompatActivity {

    private SharedViewModel sharedViewModel;
    private TextView SharedData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);
        sharedViewModel.getData().observe(this, newDataReceived -> {
            SharedData.setText(newDataReceived);
        });

        SharedData = findViewById(R.id.SharedData);

        sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);
        String receivedValue = getIntent().getStringExtra("text");

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new FirstFragment())
                .commit();

    }
}


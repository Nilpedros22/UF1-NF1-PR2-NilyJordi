package com.example.uf1_nf1_pr2_nilyjordi;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class SecondActivity extends AppCompatActivity {

    private SharedViewModel sharedViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new FirstFragment())
                .commit();
    }
}


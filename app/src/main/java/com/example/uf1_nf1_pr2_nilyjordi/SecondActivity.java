package com.example.uf1_nf1_pr2_nilyjordi;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView messageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //messageTextView = findViewById(R.id.message_text_view);

        if (getIntent().getExtras() != null) {
            String message = getIntent().getStringExtra("message");
            messageTextView.setText(message);
        }
    }
}

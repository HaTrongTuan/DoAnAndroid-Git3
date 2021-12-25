package com.example.doanck2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Process_HistoryClass_Detail extends AppCompatActivity {
    Button btnFeedback;
    ImageButton imbBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process_history_class_detail);
        btnFeedback = findViewById(R.id.btnFeedback);
        imbBack = findViewById(R.id.imbBack);
        btnFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Process_HistoryClass_Detail.this, Process_HistoryClass_Feedback.class);
                startActivity(intent);
            }
        });
        imbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
    }
}
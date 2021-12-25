package com.example.doanck2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Process_HistoryClass_Feedback extends AppCompatActivity {

    Button btnSendFeedback;
    ImageButton imbBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process_history_class_feedback);
        btnSendFeedback = findViewById(R.id.btnSendFeedback);
        imbBack = findViewById(R.id.imbBack);
        btnSendFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Process_HistoryClass_Feedback.this, Process.class);
                startActivity(intent);
                Toast.makeText(Process_HistoryClass_Feedback.this, "Hệ thống đã tiếp nhận Feedback của bạn", Toast.LENGTH_SHORT).show();
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
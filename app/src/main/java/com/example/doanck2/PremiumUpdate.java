package com.example.doanck2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageButton;

public class PremiumUpdate extends AppCompatActivity {

    ImageButton imbBack;
    RecyclerView rcvPreTeacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premium_update);

        linkViews();
    }

    private void linkViews() {
        imbBack = findViewById(R.id.imbBack);
        rcvPreTeacher = findViewById(R.id.rcvPreTeacher);
    }
}
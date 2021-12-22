package com.example.doanck2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class Leo extends AppCompatActivity {
    ImageButton imbBack;
    Spinner spThanhLap, spBDH, spThanhTich;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leo);

        linkview();
        back();
    }

    private void back() {
        imbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void linkview() {
        imbBack = findViewById(R.id.imbBack);
        spThanhLap = findViewById(R.id.spThanhLap);
        spBDH = findViewById(R.id.spBDH);
        spThanhTich = findViewById(R.id.spThanhTich);

    }
}
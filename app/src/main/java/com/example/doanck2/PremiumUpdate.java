package com.example.doanck2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PremiumUpdate extends AppCompatActivity {

    RecyclerView rcvPreTeacher;
    LinearLayout lnQuanLyTKPrem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premium_update);
        
        bottomNav();
        linkViews();
        setEvents();
    }

    private void setEvents() {
        lnQuanLyTKPrem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PremiumUpdate.this, QuanLyPremium.class);
                startActivity(intent);
            }
        });
    }

    private void bottomNav() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.premium);
    }

    private void linkViews() {
        rcvPreTeacher = findViewById(R.id.rcvPreTeacher);
        lnQuanLyTKPrem = findViewById(R.id.lnQuanLyTKPrem);
    }
}
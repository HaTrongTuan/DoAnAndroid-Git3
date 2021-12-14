package com.example.doanck2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomePage extends AppCompatActivity {

    TextView txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        bottomNav();
        linkViews();


    }

    private void linkViews() {
        txtName = findViewById(R.id.txtName);
    }

    private void bottomNav() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.homepage);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.homepage);



        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.process:
                        startActivity(new Intent(getApplicationContext(),Process.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.homepage:

                        return true;
                    case R.id.user:
                        startActivity(new Intent(getApplicationContext(),UserPage.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.premium:
                        startActivity(new Intent(getApplicationContext(),Premium.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.notification:
                        startActivity(new Intent(getApplicationContext(),Notification.class));
                        overridePendingTransition(0,0);
                        return true;

                }

                return false;
            }
        });
    }
}
package com.example.doanck2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.utils.General;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomePage extends AppCompatActivity {

    TextView txtName;
    ImageButton imbLop, imbGv, imbTin, imbLeo;
    ImageView imvAvaHP,imvPremium;
    String username = General.Us.getUsername();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        bottomNav();
        linkViews();
        showInfo();
        changePage();



    }

    private void showInfo() {

        txtName.setText(General.ADB.ShowInfo(username).getString(3));
        //convert photo
        byte[] photo = General.ADB.ShowInfo(username).getBlob(7);
        Bitmap bitmap = BitmapFactory.decodeByteArray(photo,0,photo.length);
        imvAvaHP.setImageBitmap(bitmap);
        imvPremium.setVisibility(View.INVISIBLE);

    }

    private void changePage() {
        imbLop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTranstoPhone = new Intent(HomePage.this, Class.class);
                startActivity(intentTranstoPhone);
            }
        });
        imbGv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gv = new Intent(HomePage.this, GiangVien.class);
                startActivity(gv);
            }
        });
        imbTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent news = new Intent(HomePage.this, News.class);
                startActivity(news);
            }
        });
        imbLeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent leo= new Intent(HomePage.this, Leo.class);
                startActivity(leo);
            }
        });

    }

    private void linkViews() {
        txtName = findViewById(R.id.txtName);
        imbLop = findViewById(R.id.imbLop);
        imbGv = findViewById(R.id.imbGv);
        imbTin = findViewById(R.id.imbTin);
        imbLeo = findViewById(R.id.imbLeo);
        imvAvaHP = findViewById(R.id.imvAvaHP);
        imvPremium = findViewById(R.id.imvPremium);

    }

    private void bottomNav() {
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
                            Intent intent = new Intent(HomePage.this, UserPage.class);
                            startActivity(intent);
                            overridePendingTransition(0, 0);
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
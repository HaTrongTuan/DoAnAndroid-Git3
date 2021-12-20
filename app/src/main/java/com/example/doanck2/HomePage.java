package com.example.doanck2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
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
    ImageView imvAvaHP;

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
        Intent nhanUsername = getIntent();
        String fullname = nhanUsername.getStringExtra("UserName");
        txtName.setText(General.ADB.ShowInfo(fullname).getString(2));
        //convert photo
        byte[] photo = General.ADB.ShowInfo(fullname).getBlob(7);
        Bitmap bitmap = BitmapFactory.decodeByteArray(photo,0,photo.length);
        imvAvaHP.setImageBitmap(bitmap);
    }

    private void changePage() {
        imbLop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTranstoPhone = new Intent(HomePage.this, Class.class);
                startActivity(intentTranstoPhone);
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
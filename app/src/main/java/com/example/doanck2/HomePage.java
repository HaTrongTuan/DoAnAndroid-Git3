package com.example.doanck2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.database.AccountDataBase;
import com.example.utils.General;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.ByteArrayOutputStream;

public class HomePage extends AppCompatActivity {

    TextView txtName;
    ImageView imvAva;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        bottomNav();
        linkViews();
        showInfo();


    }

    private void showInfo() {
        Intent nhanUsername = getIntent();
        String fullname = nhanUsername.getStringExtra("UserName");
        txtName.setText(General.ADB.ShowInfo(fullname).getString(2));
            //convert photo
        byte[] photo = General.ADB.ShowInfo(fullname).getBlob(7);
        Bitmap bitmap = BitmapFactory.decodeByteArray(photo,0,photo.length);
        imvAva.setImageBitmap(bitmap);


    }

    private void linkViews() {

        txtName = findViewById(R.id.txtName);
        imvAva = findViewById(R.id.imvAvaHP);
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
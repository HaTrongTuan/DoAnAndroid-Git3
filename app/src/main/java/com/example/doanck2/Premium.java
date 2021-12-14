package com.example.doanck2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Premium extends AppCompatActivity {
    private TypedArray images;
    private ImageView itemImage;
    RadioButton radChangeImage1 = null;
    RadioButton radChangeImage2 = null;
    RadioButton radChangeImage3 = null;
    RadioGroup rgChangeImage = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premium);


        bottomNav();


    }

    private void bottomNav() {

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.premium);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.process:
                        startActivity(new Intent(getApplicationContext(),Process.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.homepage:
                        startActivity(new Intent(getApplicationContext(),HomePage.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.user:
                        startActivity(new Intent(getApplicationContext(),UserPage.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.premium:
                        return true;
                    case R.id.notification:
                        startActivity(new Intent(getApplicationContext(),Notification.class));
                        overridePendingTransition(0,0);
                        return true;

                }

                return false;
            }
        });
        linkview();

        rgChangeImage.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkID) {
                if (checkID == radChangeImage1.getId()){
                    itemImage.setImageResource(R.drawable.hinh6);
                }else if (checkID == radChangeImage2.getId()){
                    itemImage.setImageResource(R.drawable.hinh1);
                }else if (checkID == radChangeImage3.getId()) {
                    itemImage.setImageResource(R.drawable.hinh5);
                }
            }
        });

    }


    private void linkview() {
        images = getResources().obtainTypedArray(R.array.radiobtn_image);
        itemImage = findViewById(R.id.imvChangeImagePremium);
        radChangeImage1 = findViewById(R.id.radChangeImage1);
        radChangeImage2 = findViewById(R.id.radChangeImage2);
        radChangeImage3 = findViewById(R.id.radChangeImage3);
        rgChangeImage = findViewById(R.id.rgChangeImage);
    }
}
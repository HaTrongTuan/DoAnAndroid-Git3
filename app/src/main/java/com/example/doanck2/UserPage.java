package com.example.doanck2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.utils.General;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UserPage extends AppCompatActivity {

    TextView txtIdUser, txtNameUser, txtPhoneUser, txtEmailUser;
    Button btnChangePass, btnPolicy, btnContact, btnQues,btnEditAcc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);

        linkViews();
        bottomNav();
        showInfo();
        setEvents();



    }

    private void showInfo() {
        Intent nhanUsername = getIntent();
        String fullname = nhanUsername.getStringExtra("UserNametoUsers");
        txtIdUser.setText(General.ADB.ShowInfo(fullname).getString(0));
        txtNameUser.setText(General.ADB.ShowInfo(fullname).getString(3));
        txtPhoneUser.setText(General.ADB.ShowInfo(fullname).getString(4));
        txtEmailUser.setText(General.ADB.ShowInfo(fullname).getString(5));
    }

    private void setEvents() {
        btnQues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.user_page_faq);
            }
        });
        btnPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.user_page_rule);
            }
        });
        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.user_page_contact);
            }
        });
        btnChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_user_page_change_pass);
            }
        });
        btnEditAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_user_page_edit);
            }
        });
    }

    private void linkViews() {
        txtIdUser = findViewById(R.id.txtIdUser);
        txtNameUser = findViewById(R.id.txtNameUser);
        txtPhoneUser = findViewById(R.id.txtPhoneUser);
        txtEmailUser = findViewById(R.id.txtEmailUser);
        btnChangePass = findViewById(R.id.btnChangePassword);
        btnPolicy = findViewById(R.id.btnDieuKhoan);
        btnContact = findViewById(R.id.btnLienhe);
        btnQues = findViewById(R.id.btnCauhoithuonggap);
        btnEditAcc = findViewById(R.id.btnEditAcc);

    }

    private void bottomNav() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.user);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.process:
                        startActivity(new Intent(getApplicationContext(),Process.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.homepage:
                        Intent nhanUsername = getIntent();
                        String username = nhanUsername.getStringExtra("UserNametoUsers");
                        Intent intent = new Intent(UserPage.this,HomePage.class);
                        intent.putExtra("UserNametoHP",username);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.user:

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
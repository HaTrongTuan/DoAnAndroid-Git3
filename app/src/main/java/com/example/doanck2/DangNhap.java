package com.example.doanck2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DangNhap extends AppCompatActivity {

    Button btnDn, btnDk;
    EditText edtUsername, edtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        linkViews();
        dangNhap();
        dangKy();
        getDataFromMail();
        getDataFromPhone();
    }

    private void getDataFromPhone() {
        Intent intentGetDataFromPhone = getIntent();
        edtUsername.setText(intentGetDataFromPhone.getStringExtra("NamePhone_To_Login"));

    }

    private void getDataFromMail() {
        Intent intentGetDataFromMail = getIntent();
        edtUsername.setText(intentGetDataFromMail.getStringExtra("NameEmail_To_Login"));




    }

    private void dangKy() {
        btnDk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentDangKy = new Intent(DangNhap.this,DangKyMail.class);
                startActivity(intentDangKy);
            }
        });

    }

    private void dangNhap() {

        btnDn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Lấy dữ liệu
                String userName = edtUsername.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();

                //Check dữ liệu
                if (userName.equals("admin") && password.equals("admin") ){
                    Toast.makeText(DangNhap.this, "Login...", Toast.LENGTH_SHORT).show();
                    //Đăng nhập
                    Intent intentDangNhap = new Intent(DangNhap.this, HomePage.class);
                    //Mở HomePage
                    startActivity(intentDangNhap);
                }else

                Toast.makeText(DangNhap.this, "Wrong Username or Password", Toast.LENGTH_SHORT).show();
            }

        });
    }

    private void linkViews() {
        btnDn = findViewById(R.id.btnDn);
        btnDk = findViewById(R.id.btnDk);
        edtPassword = findViewById(R.id.edtPassword);
        edtUsername = findViewById(R.id.edtUsername);
    }
}
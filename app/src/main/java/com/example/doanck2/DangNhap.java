package com.example.doanck2;

import static com.example.doanck2.R.layout.activity_dang_nhap;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.database.AccountDataBase;

import java.io.ByteArrayOutputStream;

public class DangNhap extends AppCompatActivity {

    Button btnDn, btnDk;
    EditText edtUsername, edtPassword;
    AccountDataBase ADB = new AccountDataBase(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);

        prepareDb();
        linkViews();
        getEvents();
        getDataFromMail();
        getDataFromPhone();


    }


    private void getEvents() {
        AccountDataBase accountDataBase = new AccountDataBase(this);
        btnDk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentDangKy = new Intent(DangNhap.this,DangKyMail.class);
                startActivity(intentDangKy);
            }
        });
        btnDn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Lấy dữ liệu
                String userName = edtUsername.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();

                //Check dữ liệu
                boolean CheckUserPass = ADB.checkUsernamePassword(userName, password);
                if (CheckUserPass == true) {
                    Toast.makeText(DangNhap.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    //Đăng nhập
                    Intent intentDangNhap = new Intent(DangNhap.this, HomePage.class);
                    //Mở HomePage
                    startActivity(intentDangNhap);
                }else

                    Toast.makeText(DangNhap.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
            }

        });
    }

    private byte[] convertPhoto(int image) {
        BitmapDrawable drawable = (BitmapDrawable) getDrawable(image);
        Bitmap bitmap = drawable.getBitmap();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
        return outputStream.toByteArray();
    }

    private void prepareDb() {
        AccountDataBase accountDataBase = new AccountDataBase(this);
//        accountDataBase.onUpgrade(accountDataBase.getWritableDatabase(), 0,1);
        if(accountDataBase.getCount() == 0) {
            accountDataBase.insertData("admin", "admin", "admin", "0123456789", "admin@gmail.com", "01092001", convertPhoto(R.drawable.ava));
        }
    }




    private void getDataFromPhone() {
        Intent intentGetDataFromPhone = getIntent();
        edtUsername.setText(intentGetDataFromPhone.getStringExtra("NamePhone_To_Login"));

    }

    private void getDataFromMail() {
        Intent intentGetDataFromMail = getIntent();
        edtUsername.setText(intentGetDataFromMail.getStringExtra("NameEmail_To_Login"));

    }

    private void linkViews() {
        btnDn = findViewById(R.id.btnDn);
        btnDk = findViewById(R.id.btnDk);
        edtPassword = findViewById(R.id.edtPassword);
        edtUsername = findViewById(R.id.edtUsername);
    }
}
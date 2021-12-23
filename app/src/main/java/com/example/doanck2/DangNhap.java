package com.example.doanck2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.database.AccountDataBase;
import com.example.utils.General;

import java.io.ByteArrayOutputStream;

public class DangNhap extends AppCompatActivity {

    Button btnDn, btnDk;
    EditText edtUsername, edtPassword;
    CheckBox chkLuu;
    TextView txtQuen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        General.ADB = new AccountDataBase(this);
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

        txtQuen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent quen = new Intent(DangNhap.this, LayLaiTkEmail.class);
                startActivity(quen);
            }
        });

        btnDn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //Lấy dữ liệu
                String userName = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();

                //Check dữ liệu
                boolean CheckUserPass = General.ADB.checkUsernamePassword(userName, password);
                if (CheckUserPass) {
                    Toast.makeText(DangNhap.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    //Đăng nhập
                    //Truyền username đề dùng db cho homepage
                    Intent truyenUserPage = new Intent(DangNhap.this, HomePage.class);
                    truyenUserPage.putExtra("UsernameFromDangNhap",userName);
                    startActivity(truyenUserPage);

                }else

                    Toast.makeText(DangNhap.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
            }

        });
        txtQuen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DangNhap.this,LayLaiTkEmail.class);
                startActivity(intent);
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
//        accountDataBase.onUpgrade(accountDataBase.getWritableDatabase(), 0,1);
        if(General.ADB.getCount() == 0) {
            General.ADB.insertData("admin", "admin", "admin", "0123456789", "admin@gmail.com", "01092001", convertPhoto(R.drawable.unknownava));
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
        chkLuu = findViewById(R.id.chkLuu);
        txtQuen = findViewById(R.id.txtQuen);
    }
}
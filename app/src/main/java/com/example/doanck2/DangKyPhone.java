package com.example.doanck2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DangKyPhone extends AppCompatActivity {

    TextView txtEmailDk;
    EditText edtPhonePhone, edtNamePhone, edtPassPhone, edtRePassPhone;
    Button btnActDkPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky_phone);

        linkViews();
        dangKyPhone();
        transToEmail();

    }

    private void dangKyPhone() {
        btnActDkPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Check dữ liệu
                String PhonePhone = edtPhonePhone.getText().toString().trim();
                String NamePhone = edtNamePhone.getText().toString().trim();
                String PassPhone = edtPassPhone.getText().toString().trim();
                String RePassPhone = edtRePassPhone.getText().toString().trim();
                if (RePassPhone.equals(PassPhone)){
                    Intent intentActDangKyPhone = new Intent(DangKyPhone.this, DangNhap.class);
                    intentActDangKyPhone.putExtra("NamePhone_To_Login", NamePhone);

                    startActivity(intentActDangKyPhone);
                    Toast.makeText(DangKyPhone.this, "Đăng kí thành công!", Toast.LENGTH_SHORT).show();

                }else{

                    Toast.makeText(DangKyPhone.this, "Nhập lại mật khẩu sai", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void transToEmail() {
        txtEmailDk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentTranstoMail = new Intent(DangKyPhone.this, DangKyMail.class);
                startActivity(intentTranstoMail);
            }
        });
    }

    private void linkViews() {
        txtEmailDk = findViewById(R.id.txtEmailDK);
        edtPhonePhone =findViewById(R.id.edtPhone);
        edtNamePhone = findViewById(R.id.edtNamePhone);
        edtPassPhone= findViewById(R.id.edtPassPhone);
        edtRePassPhone = findViewById(R.id.edtRePassPhone);
        btnActDkPhone = findViewById(R.id.btnActDkPhone);
    }
}
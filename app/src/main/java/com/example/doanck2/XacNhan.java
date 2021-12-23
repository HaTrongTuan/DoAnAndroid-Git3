package com.example.doanck2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class XacNhan extends AppCompatActivity {
    ImageView imvback;
    EditText edtOTP;
    Button btnXNOTP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xac_nhan);

        linkView();
        setEvents();
    }

    private void setEvents() {
        imvback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTranstoPhone = new Intent(XacNhan.this, DangNhap.class);
                startActivity(intentTranstoPhone);
            }
        });
        btnXNOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nhanMail = getIntent();
                String mail = nhanMail.getStringExtra("MailfromLayLaiTK");
                Intent nhanPhone = getIntent();
                String phone = nhanPhone.getStringExtra("PhoneFromLayLaiTK");
                if (mail != null){
                    Toast.makeText(XacNhan.this, "Xác nhận OTP thành công!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(XacNhan.this, XacNhanLayLaiTK.class);
                    intent.putExtra("MailfromXNOTP",mail);
                    startActivity(intent);
                }if (phone != null){
                    Toast.makeText(XacNhan.this, "Xác nhận OTP thành công!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(XacNhan.this, XacNhanLayLaiTK.class);
                    intent.putExtra("PhonefromXNOTP",phone);
                    startActivity(intent);
                }

            }
        });
    }

    private void linkView() {
        imvback = findViewById(R.id.back);
        edtOTP = findViewById(R.id.edtVerify);
        btnXNOTP = findViewById(R.id.btnXnOTP);
    }
}
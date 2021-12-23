package com.example.doanck2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.utils.General;

public class XacNhanLayLaiTK extends AppCompatActivity {
    ImageView imvback;
    EditText edtPass, edtNewPass;
    Button btnXNTK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xac_nhan_lay_lai_tk);

        linkView();
        setEvents();
    }

    private void setEvents() {
        imvback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTranstoPhone = new Intent(XacNhanLayLaiTK.this, DangNhap.class);
                startActivity(intentTranstoPhone);
            }
        });
        btnXNTK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pass = edtPass.getText().toString().trim();
                String newPass = edtNewPass.getText().toString().trim();
                Intent nhanmail = getIntent();
                String mail = nhanmail.getStringExtra("MailfromXNOTP");
                Intent nhanphone = getIntent();
                String phone = nhanphone.getStringExtra("PhonefromXNOTP");
                if (pass.equals("")||newPass.equals("")){
                    Toast.makeText(XacNhanLayLaiTK.this, "Vui lòng nhập đủ các ô!", Toast.LENGTH_SHORT).show();
                }else{
                    if (!pass.equals(newPass)){
                        Toast.makeText(XacNhanLayLaiTK.this, "Nhập lại mật khẩu không đúng", Toast.LENGTH_SHORT).show();
                    }else{
                        if (mail != null){
                             General.ADB.updatePassFromEmail(mail,pass);
                                Toast.makeText(XacNhanLayLaiTK.this, "Cập nhật mật khẩu thành công!", Toast.LENGTH_SHORT).show();
                                Intent intent =new Intent(XacNhanLayLaiTK.this,DangNhap.class);
                                startActivity(intent);
                        }if (phone !=null){
                            boolean check = General.ADB.updatePassFromPhone(phone,pass);
                                Toast.makeText(XacNhanLayLaiTK.this, "Cập nhật mật khẩu thành công!", Toast.LENGTH_SHORT).show();
                            Intent intent =new Intent(XacNhanLayLaiTK.this,DangNhap.class);
                            startActivity(intent);
                        }
                    }
                }
            }
        });
    }

    private void linkView() {
        imvback = findViewById(R.id.back);
        edtPass = findViewById(R.id.edtNewPassXNTK);
        edtNewPass = findViewById(R.id.edtReNewPassXNTK);
        btnXNTK = findViewById(R.id.btnXNTK);
    }
}
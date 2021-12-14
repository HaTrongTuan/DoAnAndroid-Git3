package com.example.doanck2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DangKyMail extends AppCompatActivity {

    TextView txtPhoneDk;
    EditText edtEmailEmail, edtNameEmail, edtPassEmail, edtRePassEmail;
    Button btnActDkEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky_mail);

        linkView();
        dangKyMail();
        transToPhone();



    }

    private void dangKyMail() {

        btnActDkEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Check dữ liệu
                String EmailEmail = edtEmailEmail.getText().toString().trim();
                String NameEmail = edtNameEmail.getText().toString().trim();
                String PassEmail = edtPassEmail.getText().toString().trim();
                String RePassEmail = edtRePassEmail.getText().toString().trim();
                if (RePassEmail.equals(PassEmail)){
                    Intent intentActDangKyEmail = new Intent(DangKyMail.this, DangNhap.class);
                    intentActDangKyEmail.putExtra("NamePhone_To_Login", NameEmail);

                    startActivity(intentActDangKyEmail);
                    Toast.makeText(DangKyMail.this, "Đăng kí thành công!", Toast.LENGTH_SHORT).show();

                }else{

                    Toast.makeText(DangKyMail.this, "Nhập lại mật khẩu sai", Toast.LENGTH_SHORT).show();
            }}
        });

    }

    private void transToPhone() {
        txtPhoneDk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentTranstoPhone = new Intent(DangKyMail.this, DangKyPhone.class);
                startActivity(intentTranstoPhone);
            }
        });
    }

    private void linkView() {
        txtPhoneDk = findViewById(R.id.txtPhoneDk);
        edtEmailEmail =findViewById(R.id.edtEmail);
        edtNameEmail = findViewById(R.id.edtNameEmail);
        edtPassEmail = findViewById(R.id.edtPassEmail);
        edtRePassEmail = findViewById(R.id.edtRePassEmail);
        btnActDkEmail = findViewById(R.id.btnActDkEmail);
    }
}
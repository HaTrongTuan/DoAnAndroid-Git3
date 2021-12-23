package com.example.doanck2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.utils.General;

public class LayLaiTkPhone extends AppCompatActivity {

    ImageView imvback;
    EditText edtPhonemk;
    TextView txtTranstoMail;
    Button btnXnmkPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lay_lai_tk_phone);

        linkView();
        setEvents();
        TranstoMail();
    }


    private void setEvents() {
        imvback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LayLaiTkPhone.this, DangNhap.class);
                startActivity(intent);
            }
        });

        btnXnmkPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = edtPhonemk.getText().toString().trim();
                boolean check = General.ADB.checkPhone(phone);
                if (!check){
                    Toast.makeText(LayLaiTkPhone.this, "Không tồn tại Email này!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(LayLaiTkPhone.this, "Xác nhận thành công!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LayLaiTkPhone.this, XacNhan.class);
                    intent.putExtra("PhoneFromLayLaiTK",phone);
                    startActivity(intent);
                }
            }
        });


    }

    private void linkView() {
        imvback = findViewById(R.id.back);
        edtPhonemk = findViewById(R.id.edtPhonemk);
        txtTranstoMail = findViewById(R.id.txtEmailmk);
        btnXnmkPhone = findViewById(R.id.btnXnmkPhone);
    }
    private void TranstoMail(){
        txtTranstoMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentTranstoMail = new Intent(LayLaiTkPhone.this,LayLaiTkEmail.class);
                startActivity(intentTranstoMail);
            }
        });

    }
}
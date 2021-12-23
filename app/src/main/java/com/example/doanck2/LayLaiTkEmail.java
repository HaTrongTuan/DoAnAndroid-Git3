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

public class LayLaiTkEmail extends AppCompatActivity {

    ImageView imvback;
    EditText edtEmailmk;
    TextView txtTranstoPhone;
    Button btnXnmk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lay_lai_tk_email);

        linkView();
        setEvents();
        TranstoPhone();
    }


    private void setEvents() {
        imvback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTranstoPhone = new Intent(LayLaiTkEmail.this, DangNhap.class);
                startActivity(intentTranstoPhone);
            }
        });

        btnXnmk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String mail = edtEmailmk.getText().toString().trim();
               boolean check = General.ADB.checkEmail(mail);
               if (!check){
                   Toast.makeText(LayLaiTkEmail.this, "Không tồn tại Email này!", Toast.LENGTH_SHORT).show();
               }else{
                   Toast.makeText(LayLaiTkEmail.this, "Xác nhận thành công!", Toast.LENGTH_SHORT).show();
                   Intent intent = new Intent(LayLaiTkEmail.this, XacNhan.class);
                   intent.putExtra("MailfromLayLaiTK",mail);
                   startActivity(intent);

               }
            }
        });

    }

    private void linkView() {
        imvback = findViewById(R.id.back);
        edtEmailmk = findViewById(R.id.edtEmailmk);
        txtTranstoPhone = findViewById(R.id.txtSDTmk);
        btnXnmk = findViewById(R.id.btnXnmkMail);
    }
    private void TranstoPhone(){
        txtTranstoPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent transtophone = new Intent(LayLaiTkEmail.this,LayLaiTkPhone.class);
                startActivity(transtophone);
            }
        });

    }
}
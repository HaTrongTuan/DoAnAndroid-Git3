package com.example.doanck2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class ClassDetail extends AppCompatActivity {

    Button btnAttend,btnXnDk,btnHuy;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_detail);

        linkView();
        editDialog();
        addEvents();
    }

    private void addEvents() {
        btnAttend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });

        btnXnDk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ClassDetail.this,"Đăng ký thành công",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                btnAttend.setBackgroundColor(Color.RED);
                btnAttend.setText("ĐÃ ĐĂNG KÝ");
            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    private void editDialog() {
        dialog = new Dialog(ClassDetail.this);
        dialog.setContentView(R.layout.dialog_dky);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.alert_box));
        }

        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);


    }

    private void linkView() {
        btnAttend = findViewById(R.id.btnAttend);
        btnXnDk = findViewById(R.id.btnXnDk);
        btnHuy = findViewById(R.id.btnHuy);
    }
}
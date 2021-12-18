package com.example.doanck2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class LayLaiTkPhone extends AppCompatActivity {

    ImageView imvback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lay_lai_tk_email);

        linkView();
        back();
    }

    private void back() {
        imvback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTranstoPhone = new Intent(LayLaiTkPhone.this, DangNhap.class);
                startActivity(intentTranstoPhone);
            }
        });
    }

    private void linkView() {
        imvback = findViewById(R.id.back);
    }
}
package com.example.doanck2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    ImageView imbBack;
    LinearLayout Register1Month;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.premium_register);

        linkView();
        addEvents();

    }

    private void addEvents() {
        imbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTranstoPhone = new Intent(Register.this, Premium.class);
                startActivity(intentTranstoPhone);
            }
        });
        Register1Month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTranstoPhone = new Intent(Register.this, Payment.class);
                startActivity(intentTranstoPhone);
            }
        });
    }

    private void linkView() {
        imbBack = findViewById(R.id.imbBack);
        Register1Month = findViewById(R.id.Register1Month);
    }


}

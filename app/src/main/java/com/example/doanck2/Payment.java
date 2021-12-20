package com.example.doanck2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Payment extends AppCompatActivity {

    Button btnChangePremium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.premium_payment);

        linkView();
        addEvents();
    }

    private void addEvents() {
        btnChangePremium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTranstoPhone = new Intent(Payment.this, Register.class);
                startActivity(intentTranstoPhone);
            }
        });
    }

    private void linkView() {
        btnChangePremium = findViewById(R.id.btnChangePremium);
    }
}

package com.example.doanck2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class Premium_Register extends AppCompatActivity {

    ImageButton imbBack;
    LinearLayout Register300,Register700,Register1200,Register2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premium_register);

        linkView();
        addEvents();

    }

    private void addEvents() {
        imbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Register300.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Premium_Register.this, Premium_Payment.class);
                intent.putExtra("TimeFromPaymentRegister","1 Month");
                startActivity(intent);
            }
        });
        Register700.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Premium_Register.this, Premium_Payment.class);
                intent.putExtra("TimeFromPaymentRegister","3 Month");
                startActivity(intent);
            }
        });
        Register1200.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Premium_Register.this, Premium_Payment.class);
                intent.putExtra("TimeFromPaymentRegister","6 Month");
                startActivity(intent);
            }
        });
        Register2500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Premium_Register.this, Premium_Payment.class);
                intent.putExtra("TimeFromPaymentRegister","1 Year");
                startActivity(intent);
            }
        });
    }

    private void linkView() {
        imbBack = findViewById(R.id.imbBack);
        Register300 = findViewById(R.id.lnPrem300);
        Register700 = findViewById(R.id.lnPrem700);
        Register1200 = findViewById(R.id.lnPrem1200);
        Register2500 = findViewById(R.id.lnPrem2500);
    }

}
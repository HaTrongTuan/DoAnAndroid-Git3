package com.example.doanck2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class Premium_SuccessPage extends AppCompatActivity {

    private static int LOADING = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.premium_success_payment);
        new Handler().postDelayed((Runnable) () -> {
            Intent intent;
            intent = new Intent(Premium_SuccessPage.this, PremiumUpdate.class);
            startActivity(intent);
            finish();
        },LOADING);
    }
}

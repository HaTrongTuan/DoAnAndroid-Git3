package com.example.doanck2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Premium_LoadingPage extends AppCompatActivity {
    TextView txtTrans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.premium_loading_payment);
        linkViews();
        setEvents();
    }

    private void setEvents() {
        txtTrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Premium_LoadingPage.this,Premium_SuccessPage.class);
                startActivity(intent);
            }
        });
    }

    private void linkViews() {
        txtTrans = findViewById(R.id.txtChangePremSuccess);
    }
}

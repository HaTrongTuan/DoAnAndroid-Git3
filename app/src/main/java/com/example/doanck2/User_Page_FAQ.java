package com.example.doanck2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class User_Page_FAQ extends AppCompatActivity {

    ImageButton imbBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page_faq);

        linkViews();
        setEvents();
    }

    private void setEvents() {
        imbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    private void linkViews() {
        imbBack =findViewById(R.id.imbBack);
    }

}
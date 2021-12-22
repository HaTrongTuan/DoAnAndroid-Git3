package com.example.doanck2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.DatePicker;

import java.util.Calendar;

public class Profile_Premium extends AppCompatActivity {
    private DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_premium);
        linkview();

    }






    private void linkview() {
        datePicker = findViewById(R.id.datepickerLich);
    }
}
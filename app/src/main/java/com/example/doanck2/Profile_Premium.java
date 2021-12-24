package com.example.doanck2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Profile_Premium extends AppCompatActivity {
    private DatePicker dpCalendar;
    Button btnDangKyLichHoc;
    TextView txtNameGV;
    Calendar calendar;
    String date;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_premium);
        linkview();
        calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int year = calendar.get(Calendar.YEAR);
        int month  = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        this.dpCalendar.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year , int month, int dayOfMonth) {
                date = datePickerChange(  datePicker,   year,   month,   dayOfMonth);

            }
        });

        btnDangKyLichHoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogRegister();
            }
        });

    }
    private String datePickerChange(DatePicker datePicker, int year, int month, int dayOfMonth) {
        Log.d("Date", "Year=" + year + " Month=" + (month + 1) + " day=" + dayOfMonth);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = simpleDateFormat.format(calendar.getTime());
        return date;
    }




    private void DialogRegister() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.calender_time);
        TextView txtDate = dialog.findViewById(R.id.txtDate);
        txtDate.setText(date);

        dialog.show();
        Button btnDangkyTime = dialog.findViewById(R.id.btnDangKyTime);
        btnDangkyTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogConfirmRegister();
            }
        });
    }
    private void DialogConfirmRegister() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_dky);
        Button btnCancel = dialog.findViewById(R.id.btnHuy);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }







    private void linkview() {
        dpCalendar = findViewById(R.id.dpCalendar);
        btnDangKyLichHoc = findViewById(R.id.btnDangKyLichHoc);
        txtNameGV = findViewById(R.id.txtNameGV);



    }
}
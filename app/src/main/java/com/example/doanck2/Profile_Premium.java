package com.example.doanck2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Profile_Premium extends AppCompatActivity {
    private DatePicker dpCalendar;
    Button btnDangKyLichHoc;

    Calendar calendar;
    String date;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_premium);

        bottomNav();
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

    private void bottomNav() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.premium);
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
//        RadioButton radTime = dialog.findViewById(R.id.radTime);
//        RadioButton radTime1 = dialog.findViewById(R.id.radTime1);
//        RadioButton radTime2 = dialog.findViewById(R.id.radTime2);
//        RadioButton radTime3 = dialog.findViewById(R.id.radTime3);
        Button btnDangkyTime = dialog.findViewById(R.id.btnDangKyTime);
        dialog.show();

        btnDangkyTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DialogConfirmRegister();
            }
        });
        ImageButton imbBack = dialog.findViewById(R.id.imbBack);
        imbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
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
        Button btnXnDky = dialog.findViewById(R.id.btnXnDk);
        btnXnDky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Profile_Premium.this, "Bạn đã đăng ký thành công. Hãy vào trang quản lý học vụ để nhận tài liệu từ giảng viên.", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        dialog.show();
    }







    private void linkview() {
        dpCalendar = findViewById(R.id.dpCalendar);
        btnDangKyLichHoc = findViewById(R.id.btnDangKyLichHoc);




    }
}
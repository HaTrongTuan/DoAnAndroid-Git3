package com.example.doanck2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.model.LopHocSapDienRa;

import java.util.ArrayList;

public class Process_coming_Class_Detail extends AppCompatActivity {
    Button btnHuyLopHoc;
    ListView lvHienThiLopHoc;
    ArrayList<LopHocSapDienRa> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process_coming_class_detail);
        btnHuyLopHoc = findViewById(R.id.btnHuyLopHoc);
        lvHienThiLopHoc = findViewById(R.id.lvHienThiLopHoc);
        btnHuyLopHoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogHuyBuoiHoc();
            }
        });
    }

    private void DialogHuyBuoiHoc() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_huybuoihoc);
        dialog.show();
        Button btnXacNhanHuy = dialog.findViewById(R.id.btnXacNhanHuy);
        btnXacNhanHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        Button btnCancelHuy = dialog.findViewById(R.id.btnCancelHuy);
        btnCancelHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
    private void RemoveClass(){

    }
}
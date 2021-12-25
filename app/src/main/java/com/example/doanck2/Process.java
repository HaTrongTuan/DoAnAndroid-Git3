package com.example.doanck2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.adapter.ItemBuoiHocAdapter;
import com.example.adapter.ItemLopHocSapDienRaAdapter;
import com.example.model.Lichsulophoc;
import com.example.model.LopHocSapDienRa;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Process extends AppCompatActivity {
    Spinner spSapxep;
    ArrayList<String> Sapxep;
    ArrayAdapter<String> adapter;
    ArrayList<Lichsulophoc> lichsulophocs;
    ItemBuoiHocAdapter itemBuoiHocAdapter;
    ListView lvHienThiLopHoc;
    Button btnLichSuLopHoc, btnLopHocSapDienRa;
    ArrayList<LopHocSapDienRa> lopHocSapDienRas;
    ItemLopHocSapDienRaAdapter itemLopHocSapDienRaAdapter;
    TextView txtNgay;
    ImageButton imbBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process);
        this.spSapxep = (Spinner) findViewById(R.id.spSapxep);
        linkview();
        bottomNav();
        loadDataSapxep();

        loadDataLichsulophoc();

        btnLichSuLopHoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadDataLichsulophoc();

            }
        });
        btnLopHocSapDienRa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadDataLopHocSapDienRa();


            }
        });





    }

    private void bottomNav() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.process);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.process:

                        return true;
                    case R.id.homepage:
                        startActivity(new Intent(getApplicationContext(),HomePage.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.user:
                        startActivity(new Intent(getApplicationContext(),UserPage.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.premium:
                        startActivity(new Intent(getApplicationContext(),Premium.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.notification:
                        startActivity(new Intent(getApplicationContext(),Notification.class));
                        overridePendingTransition(0,0);
                        return true;

                }

                return false;
            }
        });


    }
    private void linkview() {

        lvHienThiLopHoc = findViewById(R.id.lvHienThiLopHoc);
        btnLichSuLopHoc = findViewById(R.id.btnLichsulophoc);
        btnLopHocSapDienRa = findViewById(R.id.btnLophocsapdienra);
        txtNgay = findViewById(R.id.txtNgay);
        imbBack = findViewById(R.id.imbBack);

    }

    private void loadDataLichsulophoc() {
        lichsulophocs = new ArrayList<>();
        lichsulophocs.add(new Lichsulophoc("Study 1:1: How to introduce yourself", "12:00", "22/12/2021", "Phạm Minh Trọng" ));
        lichsulophocs.add(new Lichsulophoc("Topic: Home and family", "9:00", "17/12/2021", "Phạm Long Thuyên" ));
        lichsulophocs.add(new Lichsulophoc("Topic: Education", "16:00", "10/12/2021", "Hà Trọng Tuấn" ));
        lichsulophocs.add(new Lichsulophoc("Study 1:1: My hometown", "9:00", "24/12/2021", "Nguyễn Minh Trí" ));
        lichsulophocs.add(new Lichsulophoc("Study 1:1: History", "12:00", "6/12/2021", "Nguyễn Minh Trí" ));
        itemBuoiHocAdapter = new ItemBuoiHocAdapter(this, lichsulophocs);
        lvHienThiLopHoc.setAdapter(itemBuoiHocAdapter);
        lvHienThiLopHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Process.this, Process_HistoryClass_Detail.class);
                startActivity(intent);


            }
        });




    }
    private void loadDataLopHocSapDienRa() {
        lopHocSapDienRas = new ArrayList<>();
        lopHocSapDienRas.add(new LopHocSapDienRa("Topic: Animal", "9:00", "6/1/2022", "Nguyễn Minh Trí", "11/16 người" ));
        lopHocSapDienRas.add(new LopHocSapDienRa("Study 1:1: How to introduce my hometown", "12:00", "15/1/2022", "Nguyễn Minh Trí", "1/1 người" ));
        lopHocSapDienRas.add(new LopHocSapDienRa("Topic: Travel", "16:00", "16/1/2022", "Phạm Long Thuyên", "05/16 người" ));
        lopHocSapDienRas.add(new LopHocSapDienRa("Study 1:1: School", "16:00", "22/1/2022", "Phạm Minh Trọng", "1/1 người"));
        lopHocSapDienRas.add(new LopHocSapDienRa("Study 1:1: Technology", "12:00", "26/1/2022", "Hà Trọng Tuấn", "1/1 người" ));
        itemLopHocSapDienRaAdapter = new ItemLopHocSapDienRaAdapter(this, lopHocSapDienRas);
        lvHienThiLopHoc.setAdapter(itemLopHocSapDienRaAdapter);
        lvHienThiLopHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Process.this, Process_coming_Class_Detail.class);
                startActivity(intent);
            }
        });


    }

    private void loadDataSapxep() {
        Sapxep = new ArrayList<>();
        Sapxep.add("Sắp xếp theo mới nhất");
        Sapxep.add("Sắp xếp theo cũ nhất");
        adapter = new ArrayAdapter<String>(Process.this, android.R.layout.simple_spinner_dropdown_item);
        adapter.addAll(Sapxep);
        spSapxep.setAdapter(adapter);
    }
}
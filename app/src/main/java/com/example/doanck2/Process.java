package com.example.doanck2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.adapter.ItemBuoiHocAdapter;
import com.example.model.Lichsulophoc;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Process extends AppCompatActivity {
    Spinner spSapxep;
    ArrayList<String> Sapxep;
    ArrayAdapter<String> adapter;
    ArrayList<Lichsulophoc> lichsulophocs;
    ItemBuoiHocAdapter itemBuoiHocAdapter;
    ListView lvLichsulophoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process);
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
        this.spSapxep = (Spinner) findViewById(R.id.spSapxep);
        loadDataSapxep();
        linkview();
        loadDataLichsulophoc();
    }
    private void linkview() {

        lvLichsulophoc = findViewById(R.id.lvLichsulophoc);
    }

    private void loadDataLichsulophoc() {
        lichsulophocs = new ArrayList<>();
        lichsulophocs.add(new Lichsulophoc("Study 1:1: How to introduce yourself", "18:00", "22/12/2021", "Phạm Minh Trọng" ));
        lichsulophocs.add(new Lichsulophoc("Topic: Home and family", "19:00", "17/12/2021", "Phạm Long Thuyên" ));
        lichsulophocs.add(new Lichsulophoc("Topic: Education", "18:00", "10/12/2021", "Hà Trọng Tuấn" ));
        lichsulophocs.add(new Lichsulophoc("Study 1:1: My hometown", "19:00", "24/12/2021", "Nguyễn Minh Trí" ));
        itemBuoiHocAdapter = new ItemBuoiHocAdapter(this, lichsulophocs);
        lvLichsulophoc.setAdapter(itemBuoiHocAdapter);


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
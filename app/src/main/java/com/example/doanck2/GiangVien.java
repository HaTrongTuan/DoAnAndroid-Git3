package com.example.doanck2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;

import com.example.adapter.DanhMucAdapter;
import com.example.adapter.ItemPaymentAdapter;
import com.example.adapter.ItemTeacherAdapter;
import com.example.model.DanhMuc;
import com.example.model.PremiumPayment;
import com.example.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class GiangVien extends AppCompatActivity {
    ImageButton imbBack;
    RecyclerView rcvGVNoiBat;
    GridView grvGVNormal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giang_vien);

        linkview();
        GiangVienNormal();
        DanhMucNoiBat();
        setEvents();
    }

    private void GiangVienNormal() {
        List<Teacher> teachers = new ArrayList<Teacher>();
        teachers.add( new Teacher( R.drawable.ava2, "Minh Hoàn"));
        teachers.add(new Teacher(R.drawable.ava2,"Nguyễn Minh Long"));
        teachers.add(new Teacher(R.drawable.ava2,"Lê Thị Hồng"));
        teachers.add(new Teacher(R.drawable.ava2,"Văn Minh Hồ"));
        teachers.add(new Teacher(R.drawable.ava2,"Hồ Minh Nghĩa"));
        teachers.add(new Teacher(R.drawable.ava2,"Đinh Minh Lộc"));
        teachers.add(new Teacher(R.drawable.ava2,"Nguyễn Thị Thu"));
        teachers.add(new Teacher(R.drawable.ava2,"Hoàng Kim Trinh"));
        ItemTeacherAdapter adapter = new ItemTeacherAdapter(GiangVien.this, R.layout.item_teacher, teachers);

        grvGVNormal.setAdapter(adapter);

    }

    private void DanhMucNoiBat() {
        List<DanhMuc> danhMucs = new ArrayList<DanhMuc>();
        danhMucs.add( new DanhMuc( R.drawable.ava2, "Minh Hoàn"));
        danhMucs.add(new DanhMuc(R.drawable.ava2,"Nguyễn Minh Long"));
        danhMucs.add(new DanhMuc(R.drawable.ava2,"Lê Thị Hồng"));
        danhMucs.add(new DanhMuc(R.drawable.ava2,"Văn Minh Hồ"));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rcvGVNoiBat.setLayoutManager(layoutManager);
        rcvGVNoiBat.setHasFixedSize(true);
        rcvGVNoiBat.setAdapter(new DanhMucAdapter(this, danhMucs));

    }









    private void setEvents() {
        imbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        grvGVNormal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(GiangVien.this, GiangVienDetail.class);
                startActivity(intent);
            }
        });
    }

    private void linkview() {
        imbBack = findViewById(R.id.imbBack);
        rcvGVNoiBat =findViewById(R.id.rcvGVNoiBat);
        grvGVNormal = findViewById(R.id.grvGVNormal);
    }
}
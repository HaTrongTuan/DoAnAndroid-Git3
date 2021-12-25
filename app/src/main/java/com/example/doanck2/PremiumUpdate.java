package com.example.doanck2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.adapter.DanhMucAdapter;
import com.example.adapter.ItemTeacherAdapter;
import com.example.model.DanhMuc;
import com.example.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class PremiumUpdate extends AppCompatActivity {

    GridView grvPreTeacher;

    TextView txtNameGV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premium_update);

        linkViews();
        loadData();
        grvPreTeacher.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(PremiumUpdate.this, Profile_Premium.class);
                startActivity(intent);

            }
        });

    }

    private void loadData() {
        List<Teacher> teachers = new ArrayList<Teacher>();

        teachers.add(new Teacher(R.drawable.ava2,"Hồ Minh Nghĩa"));
        teachers.add(new Teacher(R.drawable.ava2,"Đinh Minh Lộc"));
        teachers.add(new Teacher(R.drawable.ava2,"Nguyễn Thị Thu"));
        teachers.add(new Teacher(R.drawable.ava2,"Hoàng Kim Trinh"));
        ItemTeacherAdapter adapter = new ItemTeacherAdapter(PremiumUpdate.this, R.layout.item_teacher, teachers);

        grvPreTeacher.setAdapter(adapter);

    }






    private void linkViews() {
        grvPreTeacher = findViewById(R.id.grvPreTeacher);
        txtNameGV = findViewById(R.id.txtNameGV);
    }
}
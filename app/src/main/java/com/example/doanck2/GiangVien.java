package com.example.doanck2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.adapter.ItemTeacherAdapter;
import com.example.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class GiangVien extends AppCompatActivity {
    ImageButton imbBack;
    RecyclerView rcvTeacher, rcvTeacherNormal;
    ItemTeacherAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giang_vien);

        linkview();

        configRecyclerView();
        initData();

        back();
    }

    private void initData() {
        ArrayList<Teacher> demo = new ArrayList<>();
        demo.add(new Teacher(R.drawable.ava,"Hồ Hoàng"));
        demo.add(new Teacher(R.drawable.ava2,"Hoàng Minh"));
        demo.add(new Teacher(R.drawable.avapro5,"Mỹ Lệ"));
        demo.add(new Teacher(R.drawable.avapro,"Văn Minh"));

        adapter = new ItemTeacherAdapter(getApplicationContext(), demo);
        rcvTeacher.setAdapter(adapter);

//        ArrayList<Teacher> normal = new ArrayList<>();
//        demo.add(new Teacher(R.drawable.hinh4,"Minh Hoàn"));
//        demo.add(new Teacher(R.drawable.hinh1,"Nguyễn Minh Long"));
//        demo.add(new Teacher(R.drawable.hinh3,"Lê Thị Hồng"));
//        demo.add(new Teacher(R.drawable.hinh7,"Văn Minh Hồ"));
//        demo.add(new Teacher(R.drawable.avapro3,"Hồ Minh Nghĩa"));
//        demo.add(new Teacher(R.drawable.hinh3,"Đinh Minh Lộc"));
//        demo.add(new Teacher(R.drawable.gl,"Nguyễn Thị Thu"));
//        demo.add(new Teacher(R.drawable.hinh6,"Hoàng Kim Trinh"));
//
//        adapter = new ItemTeacherAdapter(getApplicationContext(), normal);
//        rcvTeacherNormal.setAdapter(adapter);
    }

    private void configRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        rcvTeacher.setLayoutManager(manager);
        DividerItemDecoration decoration = new DividerItemDecoration(this, manager.getOrientation());
        rcvTeacher.addItemDecoration(decoration);
        rcvTeacher.setHasFixedSize(true);

//        LinearLayoutManager manager2 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
//        rcvTeacherNormal.setLayoutManager(manager2);
    }

    private void back() {
        imbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void linkview() {
        imbBack = findViewById(R.id.imbBack);
        rcvTeacher =findViewById(R.id.rcvTeacher);
        rcvTeacherNormal = findViewById(R.id.rcvTeacherNormal);
    }
}
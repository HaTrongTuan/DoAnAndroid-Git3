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
    RecyclerView rcvTeacher;
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
        demo.add(new Teacher(R.drawable.unknownava,"Mỹ Lệ"));

        adapter = new ItemTeacherAdapter(getApplicationContext(), demo);
        rcvTeacher.setAdapter(adapter);
    }

    private void configRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        rcvTeacher.setLayoutManager(manager);
        DividerItemDecoration decoration = new DividerItemDecoration(this, manager.getOrientation());
        rcvTeacher.addItemDecoration(decoration);
        rcvTeacher.setHasFixedSize(true);
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
    }
}
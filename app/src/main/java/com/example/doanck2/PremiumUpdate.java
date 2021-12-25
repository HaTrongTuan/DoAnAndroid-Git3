package com.example.doanck2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageButton;

import com.example.adapter.DanhMucAdapter;
import com.example.model.DanhMuc;
import com.example.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class PremiumUpdate extends AppCompatActivity {

    RecyclerView rcvPreTeacher;
    private DanhMucAdapter danhMucAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premium_update);

        linkViews();
        configRecyclerView();

    }


    private void configRecyclerView() {
        danhMucAdapter = new DanhMucAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rcvPreTeacher.setLayoutManager(linearLayoutManager);

        danhMucAdapter.setData(initData());
        rcvPreTeacher.setAdapter(danhMucAdapter);
    }

    private List<DanhMuc> initData() {
        List<DanhMuc> list = new ArrayList<>();

        List<Teacher> listNoiBat = new ArrayList<>();
        listNoiBat.add(new Teacher(R.drawable.ava,"Hồ Hoàng"));
        listNoiBat.add(new Teacher(R.drawable.ava2,"Hoàng Minh"));
        listNoiBat.add(new Teacher(R.drawable.avapro5,"Mỹ Lệ"));
        listNoiBat.add(new Teacher(R.drawable.avapro,"Văn Minh"));

        list.add(new DanhMuc("",listNoiBat,false));

        return list;
    }

    private void linkViews() {
        rcvPreTeacher = findViewById(R.id.rcvPreTeacher);
    }
}
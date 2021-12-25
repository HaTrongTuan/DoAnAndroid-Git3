package com.example.doanck2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.adapter.DanhMucAdapter;
import com.example.adapter.ItemTeacherAdapter;
import com.example.model.DanhMuc;
import com.example.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class GiangVien extends AppCompatActivity {
    ImageButton imbBack;
    RecyclerView rcvList;

    private DanhMucAdapter danhMucAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giang_vien);

        linkview();

        configRecyclerView();
        back();
    }

    private void configRecyclerView() {

        danhMucAdapter = new DanhMucAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rcvList.setLayoutManager(linearLayoutManager);

        danhMucAdapter.setData(initData());
        rcvList.setHasFixedSize(true);

        rcvList.setAdapter(danhMucAdapter);
    }

    private List<DanhMuc> initData() {



        List<DanhMuc> list = new ArrayList<>();

        List<Teacher> listNoiBat = new ArrayList<>();
        listNoiBat.add(new Teacher(R.drawable.ava,"Hồ Hoàng"));
        listNoiBat.add(new Teacher(R.drawable.ava2,"Hoàng Minh"));
        listNoiBat.add(new Teacher(R.drawable.avapro5,"Mỹ Lệ"));
        listNoiBat.add(new Teacher(R.drawable.avapro,"Văn Minh"));

        List<Teacher> listNormal = new ArrayList<>();
        listNormal.add(new Teacher(R.drawable.hinh4,"Minh Hoàn"));
        listNormal.add(new Teacher(R.drawable.hinh1,"Nguyễn Minh Long"));
        listNormal.add(new Teacher(R.drawable.hinh3,"Lê Thị Hồng"));
        listNormal.add(new Teacher(R.drawable.hinh7,"Văn Minh Hồ"));
        listNormal.add(new Teacher(R.drawable.avapro3,"Hồ Minh Nghĩa"));
        listNormal.add(new Teacher(R.drawable.hinh3,"Đinh Minh Lộc"));
        listNormal.add(new Teacher(R.drawable.gl,"Nguyễn Thị Thu"));
        listNormal.add(new Teacher(R.drawable.hinh6,"Hoàng Kim Trinh"));

        list.add(new DanhMuc("GIÁO VIÊN NỔI BẬT",listNoiBat,true));
        list.add(new DanhMuc("DANH SÁCH GIÁO VIÊN",listNormal,false));

        return list;
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
        rcvList =findViewById(R.id.rcvList);
    }
}
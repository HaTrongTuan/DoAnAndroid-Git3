package com.example.doanck2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.adapter.ItemLeoAdapter;
import com.example.adapter.ItemPaymentAdapter;
import com.example.model.PremiumPayment;

import java.util.ArrayList;
import java.util.List;

public class Leo extends AppCompatActivity {
    ImageButton imbBack;
    RecyclerView rcvLeo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leo);

        linkview();
        initData();
        back();
    }


    private void initData() {

        List<com.example.model.Leo> leos = new ArrayList<com.example.model.Leo>();
        leos.add(new com.example.model.Leo("Quá trình thành lập", "Love English Organization được thành lập bởi 4 sinh viên Khoa HTTT - trường Đại học Kinh tế - Luật vào năm 2019 với mục đích giúp người trẻ, đặc biệt là sinh viên có cơ hội cải thiện kĩ năng nói tiếng Anh.", "Năm 2021, Love English Organization đánh dấu sự có mặt của mình trên Internet bằng ứng dụng học tiếng Anh có tên LEO - góp phần lan tỏa giá trị nhân văn của mình và nhũng giá trị xã hội cho cộng đồng người Việt"));
        leos.add( new com.example.model.Leo("Ban điều hành", "1. Tổng giám đốc: Phạm Long Thuyên \n2. Phó giám đốc: Hà Trọng Tuấn", "3. Trưởng Ban Marketing: Nguyễn Minh Trí \n4. Trưởng Ban Kỹ thuật: Phạm Minh Trọng" ));
        leos.add(new com.example.model.Leo("Thành tích", null, null));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rcvLeo.setLayoutManager(layoutManager);
        rcvLeo.setHasFixedSize(true);
        rcvLeo.setAdapter(new ItemLeoAdapter(this, leos));

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
        rcvLeo = findViewById(R.id.rcvLeo);


    }
}
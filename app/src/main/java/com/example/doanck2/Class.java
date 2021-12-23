package com.example.doanck2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.adapter.ItemBuoiHocAdapter;
import com.example.adapter.ItemClass;
import com.example.model.Lichsulophoc;

import java.util.ArrayList;

public class Class extends AppCompatActivity {

    ImageButton imbBack;
    ArrayList<com.example.model.Class> classes;
    ItemClass itemClass;
    ListView lvClass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);

        linkview();
        back();
        loadData();
    }

    private void loadData() {
        classes = new ArrayList<>();
        classes.add(new com.example.model.Class(R.drawable.example ,"Study 1:1: How to introduce yourself", "14/16 người" , "18:00", "22/12/2021", "Phạm Minh Trọng"));
        classes.add(new com.example.model.Class(R.drawable.hinh1,"Topic: Home and family","11/16 người" ,"19:00", "17/12/2021", "Phạm Long Thuyên" ));
        classes.add(new com.example.model.Class(R.drawable.banner,"Topic: Education","14/16 người" ,"18:00", "10/12/2021", "Hà Trọng Tuấn" ));
        classes.add(new com.example.model.Class(R.drawable.example,"Study 1:1: My hometown","10/16 người" ,"19:00", "24/12/2021", "Nguyễn Minh Trí" ));
        itemClass = new ItemClass(this, classes);
        lvClass.setAdapter(itemClass);
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
        lvClass = findViewById(R.id.lvClass);
    }
}
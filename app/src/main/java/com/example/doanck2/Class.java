package com.example.doanck2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.adapter.ItemClass;
import com.example.model.MClass;

import java.util.ArrayList;

public class Class extends AppCompatActivity {

    ImageButton imbBack;
    ArrayList<MClass> MClasses;
    ItemClass itemClass;
    ListView lvClass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);

        linkview();
        loadData();
        back();

    }

    private void loadData() {
        MClasses = new ArrayList<>();
        MClasses.add(new MClass(R.drawable.example ,"Study 1:1: How to introduce yourself", "14/16 người" , "18:00", "22/12/2021", "Phạm Minh Trọng"));
        MClasses.add(new MClass(R.drawable.hinh1,"Topic: Home and family","11/16 người" ,"19:00", "17/12/2021", "Phạm Long Thuyên" ));
        MClasses.add(new MClass(R.drawable.banner,"Topic: Education","14/16 người" ,"18:00", "10/12/2021", "Hà Trọng Tuấn" ));
        MClasses.add(new MClass(R.drawable.example,"Study 1:1: My hometown","10/16 người" ,"19:00", "24/12/2021", "Nguyễn Minh Trí" ));
        itemClass = new ItemClass(this, MClasses);
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
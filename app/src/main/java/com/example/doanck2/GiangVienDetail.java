package com.example.doanck2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.model.Teacher;

public class GiangVienDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giang_vien_detail);

        linkViews();

        Bundle bundle = getIntent().getExtras();
        if (bundle == null){
            return;
        }

        Teacher teacher = (Teacher) bundle.get("gv_detail");
        TextView txtNameGV = findViewById(R.id.txtNameGV);
        txtNameGV.setText(teacher.getName());
    }

    private void linkViews() {


    }
}
package com.example.doanck2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.example.adapter.ItemBuoiHocAdapter;
import com.example.adapter.ItemNotificationAdapter;
import com.example.model.Lichsulophoc;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Notification extends AppCompatActivity {

    ListView lvNotification;
    ArrayList<com.example.model.Notification> notifications;
    ItemNotificationAdapter notificationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        bottomNav();
        linkView();
        initData();




    }



    private void initData() {
        notifications = new ArrayList<>();
        notifications.add(new com.example.model.Notification("Bạn còn 1 tiếng trước buổi học C11 của giảng viên Trần Thoa"));
        notifications.add(new com.example.model.Notification("Bạn còn 1 ngày trước buổi học D11 của giảng viên Nguyễn Minh Minh"));
        notifications.add(new com.example.model.Notification("Tài khoản Premium của bạn đã được update thành công"));
        notifications.add(new com.example.model.Notification("Cảm ơn bạn đã đánh giá giảng viên. Những feedback của bạn sẽ giúp cho team hoạt động tốt hơn"));
        notifications.add(new com.example.model.Notification("Giảng viên Phạm Minh Trọng đã update tài liệu sau buổi học ngày 28/11/2021. Chúc bạn học tập vui vẻ."));
        notifications.add(new com.example.model.Notification("Giảng viên Phạm Long Thuyên đã update tài liệu sau buổi học ngày 1/11/2021. Chúc bạn học tập vui vẻ."));
        notificationAdapter = new ItemNotificationAdapter(this, notifications);
        lvNotification.setAdapter(notificationAdapter);
    }

    private void linkView() {
        lvNotification = findViewById(R.id.lvNotification);

    }

    private void bottomNav() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.notification);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.process:
                        startActivity(new Intent(getApplicationContext(),Process.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.homepage:
                        startActivity(new Intent(getApplicationContext(),HomePage.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.user:
                        startActivity(new Intent(getApplicationContext(),UserPage.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.premium:
                        startActivity(new Intent(getApplicationContext(),Premium.class));
                        overridePendingTransition(0,0);
                    case R.id.notification:
                        return true;

                }

                return false;
            }
        });
    }
}
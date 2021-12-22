package com.example.doanck2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.adapter.ItemPaymentAdapter;
import com.example.model.PremiumPayment;

import java.util.ArrayList;
import java.util.List;

public class Premium_Payment extends AppCompatActivity {
    RecyclerView recyclerView;
    List<PremiumPayment> premiumPaymentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premium_payment);
        recyclerView = findViewById(R.id.recycleviewPayment);
        initData();

        setRecycleview();
    }

    private void initData() {
        premiumPaymentList = new ArrayList<>();
        premiumPaymentList.add(new PremiumPayment("Thanh toán bằng ngân hàng", false));
    }

    private void setRecycleview() {
        ItemPaymentAdapter itemPaymentAdapter = new ItemPaymentAdapter(premiumPaymentList);
        recyclerView.setAdapter(itemPaymentAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
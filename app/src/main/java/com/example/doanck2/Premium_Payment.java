package com.example.doanck2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.adapter.ItemPaymentAdapter;
import com.example.model.PremiumPayment;

import java.util.ArrayList;
import java.util.List;

public class Premium_Payment extends AppCompatActivity {
    RecyclerView rcvPayment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premium_payment);
        rcvPayment = (RecyclerView) findViewById(R.id.rcvPayment);
        List<PremiumPayment> premiumPayments = new ArrayList<PremiumPayment>();
        premiumPayments.add( new PremiumPayment( true));
        premiumPayments.add(new PremiumPayment( false));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rcvPayment.setLayoutManager(layoutManager);
        rcvPayment.setHasFixedSize(true);
        rcvPayment.setAdapter(new ItemPaymentAdapter(this, premiumPayments));


    }









}
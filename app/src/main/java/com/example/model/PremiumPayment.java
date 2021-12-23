package com.example.model;

import android.widget.LinearLayout;
import android.widget.TextView;

public class PremiumPayment {
    private String Payment;




    public PremiumPayment(String Payment, boolean expanded) {
        this.Payment = Payment;

    }

    public String getPayment() {
        return Payment;
    }

    public void setPayment(String txtPayment) {
        this.Payment = Payment;
    }
}

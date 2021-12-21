package com.example.model;

import android.widget.LinearLayout;
import android.widget.TextView;

public class PremiumPayment {
    private String Payment;
    public boolean expanded;

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public PremiumPayment(String Payment, boolean expanded) {
        this.Payment = Payment;
        this.expanded = expanded;
    }

    public String getPayment() {
        return Payment;
    }

    public void setPayment(String txtPayment) {
        this.Payment = Payment;
    }
}
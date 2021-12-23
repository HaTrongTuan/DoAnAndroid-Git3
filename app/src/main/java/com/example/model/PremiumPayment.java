package com.example.model;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PremiumPayment {

    private boolean LayoutPayment;
    private boolean Expandable;


    public PremiumPayment(boolean layoutPayment) {
        LayoutPayment = layoutPayment;
        Expandable = false;
    }

    public boolean isExpandable() {
        return Expandable;
    }

    public void setExpandable(boolean expandable) {
        Expandable = expandable;
    }

    public boolean isLayoutPayment() {
        return LayoutPayment;
    }

    public void setLayoutPayment(boolean layoutPayment) {
        LayoutPayment = layoutPayment;
    }


}

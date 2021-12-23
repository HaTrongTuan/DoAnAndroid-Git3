package com.example.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanck2.Premium_Payment;
import com.example.doanck2.R;
import com.example.model.PremiumPayment;

import java.util.List;

public class ItemPaymentAdapter extends RecyclerView.Adapter<ItemPaymentAdapter.ViewHolder> {
    Context context;
    List<PremiumPayment> premiumPayments;

    public ItemPaymentAdapter(Context context, List<PremiumPayment> premiumPayments) {
        this.context = context;
        this.premiumPayments = premiumPayments;

    }



    @NonNull
    @Override
    public ItemPaymentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView;
        switch (viewType) {
            case 1:
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.premium_payment_qrcode, parent, false);
                break;
            case 2:
            default:
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.premium_payment_bank, parent, false);
        }

        return new ViewHolder(itemView);
    }

    @Override
    public int getItemViewType(int position) {
        if (premiumPayments.get(position).isLayoutPayment())
        {
            return 1;
        }else {
            return  2;
        }

    }

    @Override
    public int getItemCount() {
        return premiumPayments.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PremiumPayment premiumPayment = premiumPayments.get(position);
        boolean isExpandable = premiumPayments.get(position).isExpandable();
        holder.expandableLayout.setVisibility(isExpandable ? View.GONE : View.VISIBLE);


    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout  linearLayoutPayment, expandableLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            expandableLayout = itemView.findViewById(R.id.expandableLayout);
            linearLayoutPayment = itemView.findViewById(R.id.linearLayoutPayment);
            linearLayoutPayment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PremiumPayment premiumPayment = premiumPayments.get(getAdapterPosition());
                    premiumPayment.setExpandable(!premiumPayment.isExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });



        }
    }
}

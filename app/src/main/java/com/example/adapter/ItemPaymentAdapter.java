package com.example.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
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
    List<PremiumPayment> premiumPaymentList;

    public ItemPaymentAdapter(List<PremiumPayment> premiumPaymentList) {
        this.premiumPaymentList = premiumPaymentList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.premium_payment_qrcode,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PremiumPayment premiumPayment = premiumPaymentList.get(position);
        holder.txtPayment.setText(premiumPayment.getPayment());
        boolean isExpanded = premiumPaymentList.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return 0;
    }


     public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtPayment;
        RelativeLayout expandableLayout;


        public ViewHolder(@NonNull final View itemView){
            super(itemView);
            txtPayment = itemView.findViewById(R.id.txtPayment);
            expandableLayout = itemView.findViewById(R.id.expandedLayout);
            txtPayment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PremiumPayment premiumPayment = premiumPaymentList.get(getAdapterPosition());
                    premiumPayment.setExpanded(!premiumPayment.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });


        }
    }
}

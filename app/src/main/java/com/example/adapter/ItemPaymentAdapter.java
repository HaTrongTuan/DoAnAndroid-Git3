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
    private Context context;
    private List<PremiumPayment> premiumPaymentList;

    public ItemPaymentAdapter(Context context, List<PremiumPayment> premiumPaymentList) {
        this.context = context;
        this.premiumPaymentList = premiumPaymentList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView ;
        switch (viewType){
            case 2:
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.premium_payment_bank, parent, false);
                break;
            case 1:
            default:
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.premium_payment_qrcode,parent,false);
                break;
        }
        return new ViewHolder(itemView);
    }

    @Override
    public int getItemViewType(int position) {
        if(premiumPaymentList.get(position).isLayoutPayment()){
            return 1;
        }
        else {
            return 2;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PremiumPayment premiumPayment = premiumPaymentList.get(position);

       boolean isExpanded = premiumPaymentList.get(position).isExpandable();
        holder.expandableLayout.setVisibility(isExpanded ? View.GONE : View.VISIBLE);

    }

    @Override
    public int getItemCount() {
        return premiumPaymentList.size();
    }


     public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout expandableLayout, linearLayoutPayment;


        public ViewHolder(@NonNull final View itemView){
            super(itemView);
            linearLayoutPayment = itemView.findViewById(R.id.linearLayoutPayment);

            expandableLayout = itemView.findViewById(R.id.expandableLayout);
            linearLayoutPayment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PremiumPayment premiumPayment = premiumPaymentList.get(getAdapterPosition());
                   premiumPayment.setExpandable(!premiumPayment.isExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });


        }
    }
}

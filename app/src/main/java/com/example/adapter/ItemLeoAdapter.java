package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanck2.R;
import com.example.model.Leo;

import java.util.List;

public class ItemLeoAdapter extends RecyclerView.Adapter<ItemLeoAdapter.ViewHolder> {
    private Context context;
    private List<Leo> leoList;

    public ItemLeoAdapter(Context context, List<Leo> leoList) {
        this.context = context;
        this.leoList = leoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.leo_qua_trinh_thanh_lap,parent, false);
        return new ViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Leo leo = leoList.get(position);
        holder.txtLeo.setText(leo.getLeo());
        holder.txtDetailLeo1.setText(leo.getDetailLeo1());
        holder.txtDetailLeo2.setText(leo.getDetailLeo2());
        boolean isExpanded = leoList.get(position).isExpandable();
        holder.expandableLayoutLeo.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return leoList.size();
    }


     public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtLeo, txtDetailLeo1, txtDetailLeo2;
        LinearLayout linearLayoutLeo, expandableLayoutLeo;


        public ViewHolder(@NonNull final View itemView){
            super(itemView);
            txtLeo = itemView.findViewById(R.id.txtLeo);
            txtDetailLeo1 = itemView.findViewById(R.id.txtDetailLeo1);
            txtDetailLeo2 = itemView.findViewById(R.id.txtDetailLeo2);
            expandableLayoutLeo = itemView.findViewById(R.id.expandableLayoutLeo);
            linearLayoutLeo = itemView.findViewById(R.id.linearLayoutLeo);
            linearLayoutLeo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Leo leo = leoList.get(getAdapterPosition());
                   leo.setExpandable(!leo.isExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });


        }
    }
}

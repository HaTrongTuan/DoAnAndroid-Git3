package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanck2.R;
import com.example.model.DanhMuc;
import com.example.model.Teacher;

import java.util.List;

public class DanhMucAdapter extends RecyclerView.Adapter<DanhMucAdapter.ViewHolder> {


    private Context context;
    List<DanhMuc> danhMucs;

    public DanhMucAdapter(Context context, List<DanhMuc> danhMucs) {
        this.context = context;
        this.danhMucs = danhMucs;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;
        itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_teacher, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DanhMuc danhMuc = danhMucs.get(position);
        holder.imvAva.setImageResource(danhMuc.getAva());
        holder.txtNameGV.setText(danhMuc.getNameGV());

    }




    @Override
    public int getItemCount() {

            return danhMucs.size();

    }




    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtNameGV;
        ImageView imvAva;



        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            imvAva = itemView.findViewById(R.id.imvAva);
            txtNameGV = itemView.findViewById(R.id.txtNameGV);

        }
    }



}

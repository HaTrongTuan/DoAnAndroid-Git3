package com.example.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanck2.GiangVienDetail;
import com.example.doanck2.R;
import com.example.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class ItemTeacherAdapter extends RecyclerView.Adapter<ItemTeacherAdapter.ViewHolder> {

    List<Teacher> lteachers;

    public void setData(List<Teacher> teachers){
        this.lteachers = teachers;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View customView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_teacher,parent,false);

        return new ViewHolder(customView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Teacher teacher = lteachers.get(position);

        holder.imvAva.setImageResource(teacher.getAva());
        holder.txtNameGV.setText(teacher.getName());
    }


    @Override
    public int getItemCount() {
        return lteachers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNameGV;
        ImageView imvAva;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Link View
            imvAva = itemView.findViewById(R.id.imvAva);
            txtNameGV = itemView.findViewById(R.id.txtNameGV);
        }
    }
}

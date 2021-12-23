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
import com.example.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class ItemTeacherAdapter extends RecyclerView.Adapter<ItemTeacherAdapter.ViewHolder> {

    Context context;
    ArrayList<Teacher> teachers;

    public ItemTeacherAdapter(Context context, ArrayList<Teacher> teachers) {
        this.context = context;
        this.teachers = teachers;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View customView = inflater.inflate(R.layout.item_teacher, parent, false);

        return new ViewHolder(customView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imvAva.setImageResource(teachers.get(position).getAva());
        holder.txtNameGV.setText(teachers.get(position).getName());
    }


    @Override
    public int getItemCount() {
        return teachers.size();
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

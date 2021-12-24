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
        final Teacher teacher = teachers.get(position);
        if (teacher == null){
            return;
        }

        holder.imvAva.setImageResource(teachers.get(position).getAva());
        holder.txtNameGV.setText(teachers.get(position).getName());

        holder.itemGV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeToDetail(teacher);
            }

            private void changeToDetail(Teacher teacher) {
                Intent intent = new Intent(context, GiangVienDetail.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("gv_detail",teacher);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return teachers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout itemGV;
        TextView txtNameGV;
        ImageView imvAva;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Link View
            itemGV = itemView.findViewById(R.id.itemGv);
            imvAva = itemView.findViewById(R.id.imvAva);
            txtNameGV = itemView.findViewById(R.id.txtNameGV);
        }
    }
}

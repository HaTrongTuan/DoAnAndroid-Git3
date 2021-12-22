package com.example.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanck2.R;
import com.example.model.Teacher;

import java.util.List;

public class ItemTeacherAdapter extends RecyclerView.Adapter<ItemTeacherAdapter.TeacherViewHoler> {

    private List<Teacher> teachers;

    public void setData(List<Teacher> teachers){
        this.teachers = teachers;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TeacherViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_teacher,parent,false);
        return new TeacherViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherViewHoler holder, int position) {
        Teacher teacher =teachers.get(position);
        if(teacher == null){
            return;
        }

        holder.imvAva.setImageResource(teacher.getAva());
        holder.txtNameGV.setText(teacher.getName());
    }

    @Override
    public int getItemCount() {
        if (teachers != null){
            return teachers.size();
        }
        return 0;
    }

    public class TeacherViewHoler extends RecyclerView.ViewHolder {

        private ImageView imvAva;
        private TextView txtNameGV;

        public TeacherViewHoler(@NonNull View itemView) {
            super(itemView);

            imvAva = itemView.findViewById(R.id.imvAva);
            txtNameGV = itemView.findViewById(R.id.txtNameGV);
        }
    }
}

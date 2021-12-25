package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanck2.GiangVienDetail;
import com.example.doanck2.R;
import com.example.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class ItemTeacherAdapter extends BaseAdapter {
    Activity context;
    int item;
    List<Teacher> teachers;

    public ItemTeacherAdapter(Activity context, int item, List<Teacher> teachers) {
        this.context = context;
        this.item = item;
        this.teachers = teachers;
    }



    @Override
    public int getCount() {
        return teachers.size() ;
    }

    @Override
    public Object getItem(int i) {
        return teachers.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder ;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item,null);
            holder.imvAva = view.findViewById(R.id.imvAva);
            holder.txtNameGV = view.findViewById(R.id.txtNameGV);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }
        Teacher teacher = teachers.get(i);
        holder.imvAva.setImageResource(teacher.getAva());
        holder.txtNameGV.setText(teacher.getNameGV());
        return view;

    }

    public class ViewHolder {
        TextView txtNameGV;
        ImageView imvAva;



    }
}

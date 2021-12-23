package com.example.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.doanck2.R;
import com.example.model.MClass;

import java.util.ArrayList;

public class ItemClass extends BaseAdapter {

    private Activity context;
    ArrayList<MClass> MClasses;



    public ItemClass(Activity context, ArrayList<MClass> MClasses){
        this.context = context;
        this.MClasses = MClasses;
    }

    @Override
    public int getCount() {
        return MClasses.size();
    }

    @Override
    public Object getItem(int position) {
        return MClasses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if(view == null){
            //Link item view
            holder = new ViewHolder();
            LayoutInflater inflater = context.getLayoutInflater();
            view = inflater.inflate(R.layout.itemlist_class, null);
            holder.imvThumb = view.findViewById(R.id.imvThumb);
            holder.txtTenbaihoc = view.findViewById(R.id.txtTenbaihoc);
            holder.txtThamGia = view.findViewById(R.id.txtThamGia);
            holder.txtGio= view.findViewById(R.id.txtGio);
            holder.txtNgay = view.findViewById(R.id.txtNgay);
            holder.txtNameGV = view.findViewById(R.id.txtNameGV);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();

        }

        MClass c = MClasses.get(position);
        holder.txtNgay.setText(c.getNgay());
        holder.txtGio.setText(c.getGio());
        holder.txtThamGia.setText(c.getThamgia());
        holder.txtTenbaihoc.setText(c.getTenbaihoc());
        holder.txtNameGV.setText(c.getNameGV());
        holder.imvThumb.setImageResource(c.getThumb());

        return view;
    }

    public static class ViewHolder{
        private TextView txtTenbaihoc, txtThamGia, txtGio, txtNgay, txtNameGV;
        private ImageView imvThumb;
    }
}

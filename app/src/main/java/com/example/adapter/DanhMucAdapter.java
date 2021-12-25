package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanck2.R;
import com.example.model.DanhMuc;

import java.util.List;

public class DanhMucAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static int TYPE_FEATURE = 1;
    public static int TYPE_NORMAL =  2;

    private Context context;
    private List<DanhMuc> danhMucs;

    public DanhMucAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<DanhMuc> danhMucs)
    {
        this.danhMucs = danhMucs;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (TYPE_FEATURE == viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gv_noibat, parent,false);
            return new DanhMucFViewHolder(view);
        }else if (TYPE_NORMAL == viewType){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gv_normal, parent,false);
            return new DanhMucViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        DanhMuc danhMuc = danhMucs.get(position);
        if (danhMuc == null){
            return;
        }
        if (TYPE_FEATURE == holder.getItemViewType()){

            DanhMucAdapter.DanhMucFViewHolder adt = (DanhMucFViewHolder) holder;
            adt.txtDanhMuc.setText(danhMuc.getName());

            ItemTeacherAdapter itemTeacherAdapterF = new ItemTeacherAdapter();
            itemTeacherAdapterF.setData(danhMuc.getTeacher());
            adt.rcvTeacher.setAdapter(itemTeacherAdapterF);

        } else if (TYPE_NORMAL == holder.getItemViewType()){
            DanhMucAdapter.DanhMucViewHolder adt = (DanhMucViewHolder) holder;
            adt.txtDanhMucN.setText(danhMuc.getName());

            ItemTeacherAdapter itemTeacherAdapter = new ItemTeacherAdapter();
            itemTeacherAdapter.setData(danhMuc.getTeacher());
            adt.rcvTeacherNormal.setAdapter(itemTeacherAdapter);
        }
    }

    @Override
    public int getItemCount() {
        if(danhMucs != null){
            return danhMucs.size();
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        DanhMuc danhMuc = danhMucs.get(position);
        if (danhMuc.isFeature()){
            return TYPE_FEATURE;
        }
        else {
            return TYPE_NORMAL;
        }
    }

    public class DanhMucFViewHolder extends RecyclerView.ViewHolder{

        TextView txtDanhMuc;
        RecyclerView rcvTeacher;


        public DanhMucFViewHolder(@NonNull View itemView) {
            super(itemView);

            txtDanhMuc = itemView.findViewById(R.id.txtDanhMuc);
            rcvTeacher = itemView.findViewById(R.id.rcvTeacher);
        }
    }

    public class DanhMucViewHolder extends RecyclerView.ViewHolder {

        TextView txtDanhMucN;
        RecyclerView rcvTeacherNormal;

        public DanhMucViewHolder(@NonNull View itemView) {
            super(itemView);

            txtDanhMucN = itemView.findViewById(R.id.txtDanhMucN);
            rcvTeacherNormal = itemView.findViewById(R.id.rcvTeacherNormal);
        }
    }

}

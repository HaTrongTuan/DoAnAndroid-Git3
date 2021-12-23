package com.example.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanck2.R;
import com.example.model.MNews;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    public static int TYPE_FEATURE = 1;
    public static int TYPE_NORMAL =  2;

    private List<MNews> list;

    public void setData(List<MNews> MNews){
        this.list = MNews;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (TYPE_FEATURE == viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itam_feature_news, parent,false);
            return new NewsFeaturedViewHolder(view);
        }else if (TYPE_NORMAL == viewType){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itam_news, parent,false);
            return new NewsNormalViewHolder(view);

        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MNews nw = list.get(position);
        if (nw == null){
            return;
        }
        if (TYPE_FEATURE == holder.getItemViewType()){
            NewsFeaturedViewHolder newsFeaturedViewHolder = (NewsFeaturedViewHolder) holder;
            newsFeaturedViewHolder.imvThumbF.setImageResource(nw.getCover());
            newsFeaturedViewHolder.txtTittleF.setText(nw.getTittle());
            newsFeaturedViewHolder.txtViewerF.setText(nw.getViewer());
        } else if (TYPE_NORMAL == holder.getItemViewType()){
            NewsNormalViewHolder newsNormalViewHolder = (NewsNormalViewHolder) holder;
            newsNormalViewHolder.imvThumb.setImageResource(nw.getCover());
            newsNormalViewHolder.txtTittle.setText(nw.getTittle());
            newsNormalViewHolder.txtViewer.setText(nw.getViewer());
        }
    }

    @Override
    public int getItemCount() {
        if(list != null){
            return list.size();
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        MNews MNews = list.get(position);
        if(MNews.isFeature()){
            return TYPE_FEATURE;
        }else {
            return TYPE_NORMAL;
        }
    }

    public class NewsFeaturedViewHolder extends RecyclerView.ViewHolder {

        private ImageView imvThumbF;
        private TextView txtViewerF;
        private TextView txtTittleF;

        public NewsFeaturedViewHolder(@NonNull View itemView) {
            super(itemView);

            imvThumbF = itemView.findViewById(R.id.imvNewThumbF);
            txtTittleF = itemView.findViewById(R.id.txtTittleF);
            txtViewerF = itemView.findViewById(R.id.txtViewerF);
        }
    }
    public class NewsNormalViewHolder extends RecyclerView.ViewHolder {

        private ImageView imvThumb;
        private TextView txtViewer;
        private TextView txtTittle;

        public NewsNormalViewHolder(@NonNull View itemView) {
            super(itemView);

            imvThumb = itemView.findViewById(R.id.imvNewThumb);
            txtTittle = itemView.findViewById(R.id.txtTittle);
            txtViewer = itemView.findViewById(R.id.txtViewer);
        }
    }
}

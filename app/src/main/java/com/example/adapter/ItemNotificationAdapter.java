package com.example.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.doanck2.R;
import com.example.model.Lichsulophoc;
import com.example.model.Notification;

import java.util.ArrayList;

public class ItemNotificationAdapter extends BaseAdapter {
    private Activity context;
    ArrayList<Notification> notifications;

    public ItemNotificationAdapter(Activity context, ArrayList<Notification> notifications) {
        this.context = context;
        this.notifications = notifications;
    }

    @Override
    public int getCount() {
        return notifications.size();
    }

    @Override
    public Object getItem(int i) {
        return notifications.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            //Link item view
            holder = new ItemNotificationAdapter.ViewHolder();
            LayoutInflater inflater = context.getLayoutInflater();
            view = inflater.inflate(R.layout.itemlist_notification, null);
            holder.txtNotification = view.findViewById(R.id.txtNotification);
            view.setTag(holder);
        }else {
            holder = (ItemNotificationAdapter.ViewHolder) view.getTag();

        }
        holder.txtNotification.setText(notifications.get(i).getNotification());
        return view;
    }
    public static class ViewHolder {
        TextView txtNotification;


    }
}

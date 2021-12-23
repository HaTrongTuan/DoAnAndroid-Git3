package com.example.doanck2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.adapter.NewsAdapter;
import com.example.model.MNews;

import java.util.ArrayList;
import java.util.List;

public class News extends AppCompatActivity {
    ImageButton imbBack;

    private RecyclerView rcvNews;
    private NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        linkview();
        configRecyclerView();
        back();
    }

    private void configRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvNews.setLayoutManager(linearLayoutManager);

        newsAdapter.setData(getListNews());
        rcvNews.setAdapter(newsAdapter);
    }

    private List<MNews> getListNews() {
        List<MNews> list = new ArrayList<>();
        list.add(new MNews(R.drawable.example, "LEO đang phát triển và hợp tác cùng trung tâm mới tại Vũng Tàu","200",true));
        list.add(new MNews(R.drawable.macdinh, "Sự phát triển của nền ngôn ngữ học tại đất nước Thụy Sỹ","100",false));
        list.add(new MNews(R.drawable.avapro, "Tiến sỹ R.W.Johson cùng những phát ngôn về sự quan trọng trong việc học Tiếng Anh","300",false));
        list.add(new MNews(R.drawable.gl, "Cùng nhau học tiếng Anh với các giáo sư","100",false));
        list.add(new MNews(R.drawable.be, "Ngôn ngữ học tại đất nước Anh Quốc","300",false));
        list.add(new MNews(R.drawable.communication, "Các ca khúc ngoại quốc để học tốt","500",false));
        list.add(new MNews(R.drawable.gl, "Wanna learn English effectively?","600",false));
        list.add(new MNews(R.drawable.hinh6, "Shoking news about ourself","30",false));

        return list;
    }

    private void back() {
        imbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void linkview() {
        imbBack = findViewById(R.id.imbBack);
        rcvNews = findViewById(R.id.rcvNews);
        newsAdapter = new NewsAdapter();
    }
}
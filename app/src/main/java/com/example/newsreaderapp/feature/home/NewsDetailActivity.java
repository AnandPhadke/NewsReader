package com.example.newsreaderapp.feature.home;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.newsreaderapp.R;
import com.example.newsreaderapp.pojo.Article;

public class NewsDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        Intent intent = getIntent();
        Article newsItem = (Article) intent.getParcelableExtra("newsItem");

        ImageView newsDetailImage = findViewById(R.id.newsDetailImage);
        TextView newsDetailContent = findViewById(R.id.newsDetailContent);
        TextView newsDetailUrl = findViewById(R.id.newsDetailUrl);

//        newsDetailImage.setImageResource(newsItem.getImageResource());
        newsDetailContent.setText(newsItem.getDescription());
        newsDetailUrl.setText(newsItem.getUrl());
    }
}

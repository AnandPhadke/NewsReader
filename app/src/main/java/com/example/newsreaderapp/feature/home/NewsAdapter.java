package com.example.newsreaderapp.feature.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsreaderapp.R;
import com.example.newsreaderapp.pojo.Article;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private List<Article> newsList;
    private OnItemClickListener onItemClickListener;

    public NewsAdapter(List<Article> newsList, OnItemClickListener onItemClickListener) {
        this.newsList = newsList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Article newsItem = newsList.get(position);
        holder.bind(newsItem);
        holder.itemView.setOnClickListener(v -> onItemClickListener.onItemClick(newsItem));
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(Article newsItem);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView newsImage;
        private TextView newsTitle;
        private TextView newsDate;
        private TextView newsDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            newsImage = itemView.findViewById(R.id.newsImage);
            newsTitle = itemView.findViewById(R.id.newsTitle);
            newsDate = itemView.findViewById(R.id.newsDate);
            newsDescription = itemView.findViewById(R.id.newsDescription);
        }

        public void bind(Article newsItem) {
            // Bind data to views
//            newsImage.setImageResource(newsItem.getUrlToImage());
            newsTitle.setText(newsItem.getTitle());
            newsDate.setText(newsItem.getPublishedAt());
            newsDescription.setText(newsItem.getDescription());
        }
    }
}

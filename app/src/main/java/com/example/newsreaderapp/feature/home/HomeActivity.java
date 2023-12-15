package com.example.newsreaderapp.feature.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsreaderapp.R;
import com.example.newsreaderapp.pojo.Article;
import com.example.newsreaderapp.pojo.Example;
import com.example.newsreaderapp.shared.dependency_injection.PresenterComponent;
import com.example.newsreaderapp.shared.view.activity.PresentedActivity;

import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends PresentedActivity<HomePresenter> implements IHomeView, NewsAdapter.OnItemClickListener {

    private HomePresenter presenter;
    private RecyclerView recyclerView;
    private ArrayList<Article> newsList;
    private NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        presenter.getNews();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        newsList = new ArrayList<>();
        adapter = new NewsAdapter(newsList, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(Article newsItem) {
        Intent intent = new Intent(this, NewsDetailActivity.class);
        intent.putExtra("newsItem", newsItem);
        startActivity(intent);
    }


    @Override
    protected HomePresenter onCreatePresenter() {
        presenter = new HomePresenter(this);
        return presenter;
    }

    @Override
    protected void injectPresenter(PresenterComponent presenterComponent, HomePresenter presenter) {
//                HomeComponent homeComponent  = null;

        HomeComponent homeComponent = DaggerHomeComponent.builder().
                presenterComponent(presenterComponent).
                homeModule(new HomeModule(this)).build();
        homeComponent.inject(presenter);
    }

    @Override
    public void setTempResult(Example e) {
        Toast.makeText(this,"result  ",Toast.LENGTH_LONG).show();
        Log.v("TAG","result"+ e.toString());
        newsList.addAll(e.getArticles());
        adapter.notifyDataSetChanged();
    }
}

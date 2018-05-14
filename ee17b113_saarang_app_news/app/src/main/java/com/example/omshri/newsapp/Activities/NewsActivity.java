package com.example.omshri.newsapp.Activities;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewParent;
import android.widget.TextView;
import android.widget.Toast;

import com.example.omshri.newsapp.Adapter.NewsPagerAdapter;
import com.example.omshri.newsapp.Objects.NewsList;
import com.example.omshri.newsapp.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class NewsActivity extends FragmentActivity {
    Gson gson;
    NewsPagerAdapter newsPagerAdapter;
    ViewPager viewPager;
    NewsList newsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
        String newsJson = getIntent().getStringExtra("news");
        newsList = gson.fromJson(newsJson,NewsList.class);
        viewPager = findViewById(R.id.viewPager);
        newsPagerAdapter = new NewsPagerAdapter(getSupportFragmentManager(),newsList);
        viewPager.setAdapter(newsPagerAdapter);
    }
}

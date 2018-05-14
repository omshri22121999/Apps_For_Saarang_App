package com.example.omshri.newsapp.Adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.omshri.newsapp.Fragments.NewsFragment;
import com.example.omshri.newsapp.Objects.NewsList;

public class NewsPagerAdapter extends FragmentPagerAdapter{

    NewsList newsList;
    public NewsPagerAdapter(FragmentManager fm,NewsList n) {
        super(fm);
        this.newsList = n;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle  bundle = new Bundle();
        NewsFragment newsFragment = new NewsFragment();
        bundle.putString("heading",newsList.gettitle(position));
        bundle.putString("author",newsList.getauthor(position));
        bundle.putString("img",newsList.geturltoimage(position));
        bundle.putString("desc",newsList.getdescription(position));
        bundle.putString("url",newsList.geturl(position));
        bundle.putString("publish",newsList.getpublishedat(position));
        newsFragment.setArguments(bundle);
        return newsFragment;

    }

    @Override
    public int getCount() {
        return newsList.getTotalResults();
    }
}

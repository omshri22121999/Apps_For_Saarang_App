package com.example.omshri.newsapp.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.omshri.newsapp.R;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {

    TextView heading;
    TextView author;
    ImageView img;
    TextView desc;
    TextView url;
    TextView pub;
    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View news_view = inflater.inflate(R.layout.news_page,container,false);
        heading = (TextView) news_view.findViewById(R.id.news_heading_txt);
        author = (TextView) news_view.findViewById(R.id.news_author_txt);
        desc = (TextView) news_view.findViewById(R.id.news_description_txt);
        url = (TextView) news_view.findViewById(R.id.news_url_txt);
        pub = (TextView) news_view.findViewById(R.id.news_txt_pub);
        img = (ImageView) news_view.findViewById(R.id.news_img);
        Bundle bundle=getArguments();
        heading.setText(bundle.getString("heading"));
        author.setText(bundle.getString("author"));
        desc.setText(bundle.getString("desc"));
        url.setText(bundle.getString("url"));
        pub.setText(bundle.getString("publish"));
        Picasso.get().load(bundle.getString("img")).placeholder(R.drawable.pic_not_loaded).into(img);
        return news_view;
    }

}

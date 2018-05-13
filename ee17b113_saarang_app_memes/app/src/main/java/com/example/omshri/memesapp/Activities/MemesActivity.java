package com.example.omshri.memesapp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.omshri.memesapp.Adapter.MemesAdapter;
import com.example.omshri.memesapp.Objects.MemesList;
import com.example.omshri.memesapp.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

public class MemesActivity extends AppCompatActivity {
    TextView textView;
    Gson gson;
    GsonBuilder gsonBuilder = new GsonBuilder();
    MemesList memesList;
    RecyclerView memeRecycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memes);
        String memesJSON = getIntent().getStringExtra("memes");
        gson = gsonBuilder.create();
        memesList = gson.fromJson(memesJSON,MemesList.class);
        memeRecycler = (RecyclerView) findViewById(R.id.memerecycler);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        memeRecycler.setLayoutManager(mLayoutManager);MemesAdapter memesAdapter = new MemesAdapter(memesList.getMemes());
        memeRecycler.setAdapter(memesAdapter);
        //name.setText(memesList.getName(1));
        /*Picasso.get()
             .load(memesList.getURL(1))
             .placeholder(R.drawable.download)
             .into(image);*/
    }
}

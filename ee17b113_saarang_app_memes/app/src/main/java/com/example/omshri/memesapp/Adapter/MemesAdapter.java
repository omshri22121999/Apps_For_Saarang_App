package com.example.omshri.memesapp.Adapter;


import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.omshri.memesapp.Objects.MemesClass;
import com.example.omshri.memesapp.Objects.MemesList;
import com.example.omshri.memesapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MemesAdapter extends RecyclerView.Adapter<MemesAdapter.MyViewHolder> {
    List<MemesClass> memes;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView memeImage;
        public TextView memeName;
        public MyViewHolder(View itemView) {
            super(itemView);
            memeImage = (ImageView) itemView.findViewById(R.id.memeimage);
            memeName = (TextView) itemView.findViewById(R.id.txt_memename);
        }
    }
    public MemesAdapter(List<MemesClass> memesClasses){
        this.memes=memesClasses;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.memes_view, parent, false);

        return new MyViewHolder(itemView);

    }


    public void onBindViewHolder(MyViewHolder holder, int position) {
        MemesClass meme = memes.get(position);
        holder.memeName.setText(meme.getName());
        holder.memeImage.setMaxHeight(meme.getHeight());
        holder.memeImage.setMaxWidth(meme.getWidth());
        Picasso.get()
                .load(meme.getUrl())
                .into(holder.memeImage);
    }

    @Override
    public int getItemCount() {
        return memes.size();
    }
}

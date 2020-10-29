package com.example.tprecycler;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


public class MyViewHolder extends RecyclerView.ViewHolder
{
    TextView textViewName;
    ImageView imageViewIcon;
    public MyViewHolder(View itemView) {
        super(itemView);
        this.textViewName=itemView.findViewById(R.id.tit);
        this.imageViewIcon=itemView.findViewById(R.id.img);
    }
}


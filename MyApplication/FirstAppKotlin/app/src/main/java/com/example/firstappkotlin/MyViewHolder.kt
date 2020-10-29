package com.example.firstappkotlin
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

{ val color: TextView=itemView.findViewById(R.id.lig)
}
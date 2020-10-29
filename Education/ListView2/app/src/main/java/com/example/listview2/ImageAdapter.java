package com.example.listview2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ImageAdapter extends ArrayAdapter<String> {
    public Integer[] photos;
    public String[] descr;
    public String[] title;
    private Activity  ct;

    public ImageAdapter(Activity context,
                        Integer[]photos,String[] descr,String[]title) {
        super(context, R.layout.ligne);
        this.ct=context;
        this.photos=photos;
        this.descr=descr;
        this.title=title;
    }


    @Override
    public int getCount() {
        return photos.length;
    }

    @NonNull
    @Override
    public View  getView(int position, @Nullable View convertView,
                         @NonNull ViewGroup parent) {
        View r=convertView;
        ViewHolder viewHolder=null;
        if(r==null)
        {
            LayoutInflater  layoutInflater=ct.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.ligne,null,true);
            viewHolder=new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else
        {
            viewHolder= (ViewHolder) r.getTag();
        }
        viewHolder.imgv.setImageResource(photos[position]);
        viewHolder.txtv.setText(descr[position]);
        viewHolder.txtv1.setText(title[position]);
        ct.registerForContextMenu(viewHolder.imgv);
        return r;
    }

    class ViewHolder
    { TextView  txtv;
        TextView txtv1;
        ImageView  imgv;
        public ViewHolder(View v)
        {
            txtv=v.findViewById(R.id.des);
            txtv1=v.findViewById(R.id.tit);
            imgv=v.findViewById(R.id.img);
        }
    }
}
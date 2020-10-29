package com.example.listview2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView list;
    ArrayList <ImageAdapter> tab=new ArrayList<ImageAdapter>();
    Integer[]photos={R.mipmap.image2_round,R.mipmap.image1_round,R.mipmap.e_round};
    String[] title={"titlea","titleb","titlec"};
    String[]
            descr={"descrpa","descrpb","descrpc"};
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageAdapter imga=new ImageAdapter(this,photos,descr,title);
        lv=(ListView)findViewById(R.id.mylist);
        lv.setAdapter(imga);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent in=new Intent(MainActivity.this,Main2Activity.class);
                in.putExtra("title",title[i]);
                in.putExtra("disc",descr[i]);
                in.putExtra("img",photos[i].toString());
                startActivity(in);
              //  Toast.makeText(MainActivity.this,"tilte : "+title[i]+" descrition : "+descr[i],Toast.LENGTH_LONG).show();
            }
        });
    }
}

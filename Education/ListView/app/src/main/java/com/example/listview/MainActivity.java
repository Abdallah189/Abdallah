package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView list;
ArrayList<String> tab=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=(ListView) findViewById(R.id.mylist);
        tab.add("abd");
        tab.add("khaled");
        tab.add("rafik");
        tab.add("khaled");
        tab.add("abd");
        tab.add("khaled");
        tab.add("rafik");
        tab.add("khaled");
        ArrayAdapter<String> listAd=new ArrayAdapter(MainActivity.this,android.R.layout.activity_list_item,tab);
        list.setAdapter(listAd);
    }
}

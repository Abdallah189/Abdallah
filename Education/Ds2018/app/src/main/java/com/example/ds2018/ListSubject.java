package com.example.ds2018;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListSubject extends AppCompatActivity {
    ListView listeSubject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_subject);
        listeSubject=(ListView)findViewById(R.id.listeSubject);
       final String[] Subjects={"Sujet1","Sujet2","Sujet3",
                "Sujet4","Sujet5","Sujet6"};

        ArrayAdapter<String> ar=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Subjects);
        listeSubject.setAdapter(ar);
        listeSubject.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(ListSubject.this,Details.class);
                intent.putExtra("Subject",Subjects[i]);
                startActivity(intent);
            }
        });
    }
}

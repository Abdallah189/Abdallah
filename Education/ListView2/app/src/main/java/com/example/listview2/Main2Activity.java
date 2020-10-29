package com.example.listview2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
 TextView txt;
 ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt=(TextView)findViewById(R.id.View);
        img=(ImageView)findViewById(R.id.imageView);
        img.setImageResource(Integer.parseInt(getIntent().getStringExtra("img")));
       // img.setImageURI();
        txt.setText("Titre "+getIntent().getStringExtra("title")+" \n Déscription :" +getIntent().getStringExtra("disc"));
    }
}

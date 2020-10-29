package com.example.ds2018;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Details extends AppCompatActivity {
    TextView detail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent intent=getIntent();
        String Name_Sujet=intent.getStringExtra("Subject");
        detail=(TextView)findViewById(R.id.detail);
        detail.setText("Subject \n"+Name_Sujet);
    }
}

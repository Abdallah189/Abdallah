package com.example.tprecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rc;
    Button btn;
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.button3);
        final ArrayList <DataModel> dataModels;
         final String[] nameArray={"Tunis","Bizerte","Kairouan","Zarzis"};
         final Integer[] images={R.mipmap.img1_round,R.mipmap.img3_round,R.mipmap.img1_round,R.mipmap.img2_round};
        dataModels=new ArrayList<DataModel>();
        Toast.makeText(this," "+nameArray.length,Toast.LENGTH_LONG).show();
        for(int i=0;i<nameArray.length;i++)
        {
           dataModels.add(new DataModel(nameArray[i],images[i]));
       }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataModels.add(new DataModel(nameArray[2],images[2]));
                adapter.notifyDataSetChanged();
            }
        });

        recyclerView=findViewById(R.id.list);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new CustomsAdapter(dataModels);
        recyclerView.setAdapter(adapter);
    }
}

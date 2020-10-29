package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
TextView txt;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt=(TextView)findViewById(R.id.t1);
        btn=(Button)findViewById(R.id.bt25) ;
        String login=getIntent().getStringExtra("login");
        String psw=getIntent().getStringExtra("psw");
        txt.setText("Login :"+login+" Mot de passe :"+psw);
       btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent nt=new Intent(Main2Activity.this,MainActivity.class);
//
//                startActivity(nt);
                Intent repl=new Intent();
                setResult(RESULT_OK,repl);
                finish();
            }
        });
        //Toast.makeText(Main2Activity.this,"login"+login+" PSW :"+psw,Toast.LENGTH_SHORT).show();
    }

}

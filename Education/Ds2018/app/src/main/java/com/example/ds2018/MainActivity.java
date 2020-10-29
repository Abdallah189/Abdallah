package com.example.ds2018;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     EditText Nom,Prenom,Email,Tel,Login,MDP;
     Button btnAuller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Nom=(EditText)findViewById(R.id.nom);
        Prenom=(EditText)findViewById(R.id.prenom);
        Email=(EditText)findViewById(R.id.email);
        Tel=(EditText)findViewById(R.id.tel);
        Login=(EditText)findViewById(R.id.login);
        MDP=(EditText)findViewById(R.id.mdp);
        btnAuller=(Button)findViewById(R.id.btnanuler);
        btnAuller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog;
                alertDialog =new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Attention");
                alertDialog.setMessage("Voulez Vous Vraiment remetrre a zero les champs");
                alertDialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Nom.setText("");
                        Prenom.setText("");
                        Email.setText("");
                        Tel.setText("");
                        Login.setText("");
                        MDP.setText("");
                        dialogInterface.cancel();
                    }
                });
                alertDialog.setNegativeButton( "Non", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
               alertDialog.create().show();
            }
        });
    }

    public void valideClick(View view) {
        SendMail email=new SendMail(this,"lahbib.3abdallah98@gmail.com","sfsdf","sdfs");
        email.execute();
//        Toast.makeText(MainActivity.this," "+Email.getText().toString().equals(""),Toast.LENGTH_LONG).show();
//        if(Nom.getText().toString().isEmpty()||Prenom.getText().toString().equals("")||Email.getText().toString().equals("")||Tel.getText().toString().isEmpty()||Login.getText().toString().isEmpty()||MDP.getText().toString().isEmpty()){
//            AlertDialog alert;
//            alert=new AlertDialog.Builder(this).create();
//            alert.setTitle("Attention");
//            alert.setMessage("Tous les champs doivent être remplis");
//            alert.setButton(AlertDialog.BUTTON_POSITIVE, "Ok", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    dialogInterface.cancel();
//                }
//            });
//            alert.show();
//        }
//        else{
//            Intent inta=new Intent(this,ListSubject.class);
//            startActivity(inta);
//        }
    }

}

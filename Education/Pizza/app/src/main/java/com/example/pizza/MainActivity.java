package com.example.pizza;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  Button btn;
  RadioButton rd1,rd2,rd3,rd21,rd22;
  RadioGroup rdgr1;
  EditText nom,prenom;
  String type,type2,ext1,ext2,ext3,ext4;
  CheckBox c1,c2,c3,c4;
  boolean test,test2,test3,test4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.button);
        findCheck();
        findradio();
        nom=(EditText)findViewById(R.id.nom);
        prenom=(EditText)findViewById(R.id.prenom);
        test=true;
        test2=true;
        test3=true;
        test4=true;
        rdgr1 = (RadioGroup)findViewById(R.id.rdgrp);
        final int radioId = rdgr1.getCheckedRadioButtonId();
        final RadioButton rdChrc=(RadioButton)findViewById(radioId);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nom.getText().toString().isEmpty()){
                    test3=false;
                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("Attention");
                    alertDialog.setMessage("Entrer Voutre Nom");
                    alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    alertDialog.show();
                }else {
                    test3=true;
                }
                if(prenom.getText().toString().isEmpty()){
                    test4=false;
                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("Attention");
                    alertDialog.setMessage("Entrer Votre Prenom");
                    alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    alertDialog.show();
                }else {
                    Toast.makeText(MainActivity.this,"yes",Toast.LENGTH_LONG);
                    test4=true;
                }
                if (rd1.isChecked()){
                    test=true;
                    type="Cheese";
                  //  Toast.makeText(MainActivity.this,"yes",Toast.LENGTH_LONG).show();
                }else if (rd2.isChecked()){
                    test=true;
                    type="2 X Cheese";
                }else if (rd3.isChecked()){
                    test=true;
                    type="None";
                }else{
                    test=false;
                  AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                  alertDialog.setTitle("Attention");
                  alertDialog.setMessage("Veillez vous sélectionner un Type");
                  alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "OK", new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialogInterface, int i) {
                          dialogInterface.dismiss();
                      }
                  });
                  alertDialog.show();
                }
                    if (rd21.isChecked()){
                        test2=true;
                        type2="Square";
                       // Toast.makeText(MainActivity.this,"yes",Toast.LENGTH_LONG).show();
                    }else if (rd22.isChecked()){
                        test2=true;
                        type2="Round";
                    }
                    else{
                        test2=false;
                        AlertDialog alertDialog2 = new AlertDialog.Builder(MainActivity.this).create();
                        alertDialog2.setTitle("Attention");
                        alertDialog2.setMessage("Veillez vous sélectionner un 2éme Type");
                        alertDialog2.setButton(AlertDialog.BUTTON_NEGATIVE, "OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        alertDialog2.show();
              }
                if (test && test2 && test3 && test4){
                if (c1.isChecked()){
                 ext1="Pepperroni\n";
                 }else{
                    ext1="";
                }
                if (c2.isChecked()){
                    ext2+="Mush Rooms\n";
                }else{
                    ext2="";
                }
                 if (c3.isChecked()){
                    ext3="Veggis\n";
                }else{
                    ext3="";
                }
                 if (c4.isChecked()){
                    ext4="Anchoise\n";
                 }else{
                     ext4="";
                }

                AlertDialog alertDialog3 = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog3.setTitle("Confirmation de commande");
                alertDialog3.setMessage("etes vous sur de votre commande \n"+type+"\n"+type2+"\n"+ext1+ext2+ext3+ext4);
                alertDialog3.setButton(AlertDialog.BUTTON_POSITIVE, "Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try{
//                                    SmsManager smgr = SmsManager.getDefault();
//                                    smgr.sendTextMessage("51945",null,"",null,null);
                            Intent sInt = new Intent(Intent.ACTION_VIEW);
                            sInt.putExtra("address", "51794635");
                            sInt.putExtra("sms_body","commande  \n"+type+"\n"+type2+"\n"+ext1+ext2+ext3+ext4);
                            sInt.setType("vnd.android-dir/mms-sms");
                            Toast.makeText(MainActivity.this, "Message envoyez avec sucess"+i, Toast.LENGTH_SHORT).show();
                        }
                        catch(Exception e){
                            Toast.makeText(MainActivity.this, "SMS Failed to Send, Please try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                alertDialog3.setButton(AlertDialog.BUTTON_NEGATIVE, "Non", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"hi"+i,Toast.LENGTH_LONG).show();
                        dialogInterface.dismiss();
                    }
                });
                alertDialog3.show();
            }
            }
        });
    }

    private void findCheck() {
        c1=(CheckBox)findViewById(R.id.checkBox);
        c2=(CheckBox)findViewById(R.id.checkBox3);
        c3=(CheckBox)findViewById(R.id.checkBox1);
        c4=(CheckBox)findViewById(R.id.checkBox2);
        c4=(CheckBox)findViewById(R.id.checkBox2);
    }
        private void findradio() {
            rd1=(RadioButton) findViewById(R.id.rd1);
            rd2=(RadioButton) findViewById(R.id.rd2);
            rd3=(RadioButton) findViewById(R.id.rd3);
            rd21=(RadioButton) findViewById(R.id.rd22);
            rd22=(RadioButton) findViewById(R.id.rd23);
        }

    public void clickmee(View view) {
        Toast.makeText(this,"yes",Toast.LENGTH_LONG).show();
    }
}

package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
 Button btn;
 EditText nom,psw,edate,eTime;
 int year,month,day,hour,min;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

     @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1 :
                Toast.makeText(MainActivity.this,"Item 1 selected",Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                Toast.makeText(MainActivity.this,"Item 2 selected",Toast.LENGTH_SHORT).show();
                break;
            case R.id.item3:
                Intent bus=new Intent(MainActivity.this,Main2Activity.class);
                bus.putExtra("login",nom.getText().toString());
                bus.putExtra("psw",psw.getText().toString());
              //  startActivity(bus);
                startActivityForResult(bus,1);

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.btn1);
        nom=(EditText)findViewById(R.id.editDate);
        psw=(EditText)findViewById(R.id.editText2);
        edate=(EditText)findViewById(R.id.editDate);
        eTime=(EditText)findViewById(R.id.editTime);


         Calendar cl=Calendar.getInstance();
         year=cl.get(Calendar.YEAR);
         month=cl.get(Calendar.MONTH)+1;
         day=cl.get(Calendar.DAY_OF_MONTH);
        edate.setText(year+"/"+month+"/"+day);
        edate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowDtaeDilog();
            }
        });

        hour=cl.get(Calendar.HOUR);
        min=cl.get(Calendar.MINUTE);
        eTime.setText(hour+":"+min);
        eTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowTimeDialog();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bus=new Intent(MainActivity.this,Main2Activity.class);
                bus.putExtra("login",nom.getText().toString());
                bus.putExtra("psw",psw.getText().toString());
                startActivity(bus);
            }
        });
    }

    private void ShowTimeDialog() {
        TimePickerDialog.OnTimeSetListener lisnner=new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                eTime.setText(i+":"+i1);
            }
        };

        TimePickerDialog timer=new TimePickerDialog(this,lisnner,hour,min,true);
        timer.show();
    }

    private void ShowDtaeDilog() {
        DatePickerDialog.OnDateSetListener lisnner=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                edate.setText(i+"/"+i1+1+"/"+i2);
            }
        };
        DatePickerDialog datepicker=new DatePickerDialog(this,lisnner,year,month,day);
        datepicker.show();
    }
}

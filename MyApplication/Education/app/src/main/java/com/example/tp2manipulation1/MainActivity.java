package com.example.tp2manipulation1;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox chkAndro;
    CheckBox chkMicro;
    Button btnAffich;
    RadioGroup radSpecialityType;
    RadioButton radDSI;
    RadioButton radRSI;
    RadioButton radSEM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        chkAndro = (CheckBox) findViewById(R.id.checkBox);
        chkMicro = (CheckBox)findViewById(R.id.checkBox1);
        btnAffich = (Button) findViewById(R.id.button);
        radSpecialityType = (RadioGroup)findViewById(R.id.rdgrp);
        radDSI = (RadioButton) findViewById(R.id.rd1);
        radRSI = (RadioButton) findViewById(R.id.rd2);
        radSEM = (RadioButton) findViewById(R.id.rd3);
        btnAffich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = "Spécialité ";
                String option=" Club ";
                if (chkAndro.isChecked())
                    option+=" Android ";
                if (chkMicro.isChecked())
                    option+= "Microsoft";
               int radioId = radSpecialityType.getCheckedRadioButtonId();
               RadioButton rdChrc=(RadioButton)findViewById(radioId);
                if (radDSI.getId()==radioId)
                    msg +=" DSI";
                if (radSEM.isChecked())
                    msg +=" SEM";
                if (radRSI.isChecked())
                    msg +=" RSI";
                msg += rdChrc.getText();
                Toast.makeText(MainActivity.this,msg + option,Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}

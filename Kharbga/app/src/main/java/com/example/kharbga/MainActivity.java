package com.example.kharbga;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    Bitmap bmp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


// try {
//     bg=(ConstraintLayout)findViewById(R.id.bg);
//     bg.setBackgroundResource(R.drawable.bg);
// }catch (RuntimeException e){
//     e.printStackTrace();
// }
    }
}

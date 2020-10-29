package com.example.firstappkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        welcomeMessage.text = "Hello Kotlin!"

        val clickListener = View.OnClickListener {
            welcomeMessage.text = "Hello fuc!"
            val intent = Intent(applicationContext, Main3Activity::class.java)
            startActivity(intent)

        }
        button.setOnClickListener(clickListener)

    }
}

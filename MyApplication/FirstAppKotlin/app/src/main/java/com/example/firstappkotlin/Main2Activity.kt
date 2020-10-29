package com.example.firstappkotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Main2Activity : AppCompatActivity() {

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val recycler: RecyclerView = findViewById(R.id.recycler2)
        recycler.layoutManager = GridLayoutManager(this,2)
        val Colorstab:Array<String> = arrayOf("1","2","3","4","5","6")
        val adapterCustm=AdapterCustm(this,Colorstab)
        recycler.adapter=adapterCustm
    }
}

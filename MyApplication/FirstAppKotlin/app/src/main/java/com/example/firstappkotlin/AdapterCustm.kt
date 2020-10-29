package com.example.firstappkotlin
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

public class AdapterCustm(context:Context,Colors:Array<String>): RecyclerView.Adapter<MyViewHolder>() {
    private var Colors:Array<String> = Colors
    private var ct: Context = context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.ligne, parent, false))
    }

    override fun getItemCount(): Int {
        //  TODO("size") //To change body of created functions use File | Settings | File Templates.
        var taille:Int = Colors.size
        return taille
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        holder.color.setText(Colors[position])

    }
}

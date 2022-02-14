package com.example.homeproject.api

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homeproject.R

class MyAdapter( private val data: List<Explore>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>()  {

    class MyViewHolder(private val view: View): RecyclerView.ViewHolder(view){

        fun bind(property: Explore){
            val title = view.findViewById<TextView>(R.id.tvTitle)
            val imageView = view.findViewById<ImageView>(R.id.imageView)

            title.text = property.name
            Glide.with(view.context).load(property.image).centerCrop().into(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position])
    }


}
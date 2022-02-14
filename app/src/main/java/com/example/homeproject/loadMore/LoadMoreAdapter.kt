package com.example.homeproject.loadMore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.homeproject.R

class LoadMoreAdapter(val data:List<Data>):RecyclerView.Adapter<LoadMoreAdapter.ViewHolder>() {
    class ViewHolder(val view:View):RecyclerView.ViewHolder(view) {
        fun bind(property:Data){
            val imageView:ImageView=view.findViewById(R.id.icon)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.load_content,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
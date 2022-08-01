package com.example.homeproject.diffutil

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.homeproject.R
import org.w3c.dom.Text

class DiffAdapter(val context: Context,val myList: ArrayList<DiffModel>):RecyclerView.Adapter<DiffAdapter.ViewHolder>() {
    class ViewHolder(val view:View):RecyclerView.ViewHolder(view) {
        val name=view.findViewById<TextView>(R.id.tvTitle)
        val friendsCount=view.findViewById<TextView>(R.id.count)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.diff_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text=myList[position].name
        holder.friendsCount.text=(" "+myList[position].friendsCount)
    }

    override fun getItemCount(): Int {
       return myList.size
    }
    fun dispatch(newList: List<DiffModel>) {
        val personDiffCallback= DiffCallback(newList,myList)
       val diffResult: DiffUtil.DiffResult =DiffUtil.calculateDiff(personDiffCallback)
        myList.clear()
        myList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)

    }


}
package com.example.homeproject

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MultiDeleteAdapter(private val myList: MutableList<MultiDeleteModel>
, private val showMenuDelete:(Boolean)->Unit): RecyclerView.Adapter<MultiDeleteAdapter.ViewHolder>() {

    private var isEnable=false
    private val itemSelectedList= mutableListOf<Int>()

    class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView) {
       val textView: TextView =ItemView.findViewById(R.id.numberItems)
        val imageView: ImageView =ItemView.findViewById(R.id.imgBtn)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.multi_delete_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val multiDeleteModel:MultiDeleteModel=myList[position]
        holder.textView.text=multiDeleteModel.fruits
        holder.imageView.visibility= View.GONE

        holder.textView.setOnLongClickListener {
            selectItem(holder,multiDeleteModel,position)
            true
        }
        holder.textView.setOnClickListener {
            if (itemSelectedList.contains(position)){
                itemSelectedList.removeAt(position)
                holder.imageView.visibility=View.GONE
                multiDeleteModel.selected=false
                if (itemSelectedList.isEmpty()){
                    showMenuDelete(false)
                    isEnable=false
                }

            }else if (isEnable){
                selectItem(holder, multiDeleteModel, position)
            }
        }
    }

    private fun selectItem(holder: MultiDeleteAdapter.ViewHolder, multiDeleteModel: MultiDeleteModel, position: Int) {
        isEnable=true
        itemSelectedList.add(position)
        multiDeleteModel.selected=true
        showMenuDelete(true)
        holder.imageView.visibility=View.VISIBLE
    }
    override fun getItemCount(): Int {
        return myList.size
    }
    @SuppressLint("NotifyDataSetChanged")
    fun deleteSelectedItem(){
        if (itemSelectedList.isNotEmpty()){
            myList.removeAll { multiDeleteModel -> multiDeleteModel.selected }
        isEnable=false
        itemSelectedList.clear()
        }
        notifyDataSetChanged()
    }
}
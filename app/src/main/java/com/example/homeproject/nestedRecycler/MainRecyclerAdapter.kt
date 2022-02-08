package com.example.homeproject.nestedRecycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homeproject.R

class MainRecyclerAdapter(private val context: Context,private val allCategory: List<AllCategory>):
    RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder>() {
    class ViewHolder(ItemView:View):RecyclerView.ViewHolder(ItemView){
         var categoryTittle: TextView = itemView.findViewById(R.id.cat_tittle)
        var itemRecyclerView:RecyclerView = itemView.findViewById(R.id.cat_item_recycler)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.main_recycler_row_item,parent,false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int {
        return allCategory.size
    }
//RecyclerView

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.categoryTittle.text=allCategory[position].categoryTittle
        setCatItemRecycler(holder.itemRecyclerView,allCategory[position].categoryItem)
    }
    private fun setCatItemRecycler(recyclerView: RecyclerView,categoryItem:List<CategoryItem>){
        val itemRecyclerAdapter=CategoryItemAdapter(context,categoryItem)
        recyclerView.layoutManager=GridLayoutManager(context,2,RecyclerView.HORIZONTAL,false)
        recyclerView.adapter=itemRecyclerAdapter
    }
}
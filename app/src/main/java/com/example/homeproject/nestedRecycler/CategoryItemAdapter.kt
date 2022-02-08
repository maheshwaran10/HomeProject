package com.example.homeproject.nestedRecycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.homeproject.R

class CategoryItemAdapter(private val context: Context,private val categoryItem:List<CategoryItem>):RecyclerView.Adapter<CategoryItemAdapter.ViewHolder>() {
    class ViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView) {
         val itemImage:ImageView = ItemView.findViewById(R.id.item_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.cat_row_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.itemImage.setImageResource(categoryItem[position].ImageUrl)
    }

    override fun getItemCount(): Int {
       return categoryItem.size
    }
}
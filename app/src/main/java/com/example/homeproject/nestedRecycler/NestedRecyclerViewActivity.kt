package com.example.homeproject.nestedRecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homeproject.R

class NestedRecyclerViewActivity : AppCompatActivity() {

    lateinit var recyclerView:RecyclerView
    lateinit var mainRecyclerAdapter:MainRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nested_recycler_view)
        recyclerView=findViewById(R.id.nestedRecycler)

        val category:MutableList<CategoryItem> = ArrayList()
        category.add(CategoryItem(1,R.drawable.tajmahal))
        category.add(CategoryItem(2,R.drawable.tajmahal))
        category.add(CategoryItem(3,R.drawable.tajmahal))
        category.add(CategoryItem(4,R.drawable.tajmahal))
        category.add(CategoryItem(5,R.drawable.tajmahal))
        category.add(CategoryItem(6,R.drawable.tajmahal))
        category.add(CategoryItem(7,R.drawable.tajmahal))

        val category1:MutableList<CategoryItem> = ArrayList()
        category1.add(CategoryItem(1,R.drawable.tajmahal))
        category1.add(CategoryItem(2,R.drawable.tajmahal))
        category1.add(CategoryItem(3,R.drawable.tajmahal))
        category1.add(CategoryItem(4,R.drawable.tajmahal))
        category1.add(CategoryItem(5,R.drawable.tajmahal))
        category1.add(CategoryItem(6,R.drawable.tajmahal))
        category1.add(CategoryItem(7,R.drawable.tajmahal))

        val category2:MutableList<CategoryItem> = ArrayList()
        category2.add(CategoryItem(1,R.drawable.tajmahal))
        category2.add(CategoryItem(2,R.drawable.tajmahal))
        category2.add(CategoryItem(3,R.drawable.tajmahal))
        category2.add(CategoryItem(4,R.drawable.tajmahal))
        category2.add(CategoryItem(5,R.drawable.tajmahal))
        category2.add(CategoryItem(6,R.drawable.tajmahal))
        category2.add(CategoryItem(7,R.drawable.tajmahal))


        val category3:MutableList<CategoryItem> = ArrayList()
        category3.add(CategoryItem(1,R.drawable.tajmahal))
        category3.add(CategoryItem(2,R.drawable.tajmahal))
        category3.add(CategoryItem(3,R.drawable.tajmahal))
        category3.add(CategoryItem(4,R.drawable.tajmahal))
        category3.add(CategoryItem(5,R.drawable.tajmahal))
        category3.add(CategoryItem(6,R.drawable.tajmahal))
        category3.add(CategoryItem(7,R.drawable.tajmahal))


        val category4:MutableList<CategoryItem> = ArrayList()
        category4.add(CategoryItem(1,R.drawable.tajmahal))
        category4.add(CategoryItem(2,R.drawable.tajmahal))
        category4.add(CategoryItem(3,R.drawable.tajmahal))
        category4.add(CategoryItem(4,R.drawable.tajmahal))
        category4.add(CategoryItem(5,R.drawable.tajmahal))
        category4.add(CategoryItem(6,R.drawable.tajmahal))
        category4.add(CategoryItem(7,R.drawable.tajmahal))

        val allCategory:MutableList<AllCategory> = ArrayList()
        allCategory.add(AllCategory("HollyWood",category))
        allCategory.add(AllCategory("Best of Oscars",category1))
        allCategory.add(AllCategory("Movies Dubbed in hindi",category2))
        allCategory.add(AllCategory("Category 4th",category3))
        allCategory.add(AllCategory("Category 5th",category4))
        setMainCategoryRecycler(allCategory)


    }

    private fun setMainCategoryRecycler(allCategory: List<AllCategory>){
        val layoutManager:RecyclerView.LayoutManager=LinearLayoutManager(this)
        recyclerView.layoutManager=layoutManager
        mainRecyclerAdapter= MainRecyclerAdapter(this,allCategory)
        recyclerView.adapter=mainRecyclerAdapter
    }
}
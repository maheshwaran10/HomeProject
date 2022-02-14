package com.example.homeproject.loadMore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homeproject.R

class LoadMoreActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    val list:MutableList<LoadMoreData> = mutableListOf()
    lateinit var layoutManager:RecyclerView.LayoutManager
    lateinit var toolbar: Toolbar
    lateinit var progressBar: ProgressBar
    var visibleItemCount:Int=0
    var pastVisibleItemCount:Int=0
    var loading:Boolean=false
    var pageId:Int=1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load_more)

        toolbar=findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        progressBar=findViewById(R.id.progressbar)
        recyclerView=findViewById(R.id.recyclerView)
        layoutManager=LinearLayoutManager(this)
        recyclerView.layoutManager=layoutManager
        recyclerView.setHasFixedSize(true)

    }
}
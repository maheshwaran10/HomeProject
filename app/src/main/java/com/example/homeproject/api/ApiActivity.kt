package com.example.homeproject.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homeproject.R
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var manager: RecyclerView.LayoutManager
    lateinit var imageView: ImageView
    lateinit var textView: TextView
    lateinit var textView2: TextView
    lateinit var progressBar: ProgressBar
    lateinit var myAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api)
        textView=findViewById(R.id.unique)
        imageView=findViewById(R.id.tajmahal)
        progressBar=findViewById(R.id.progress)
//        recyclerView=findViewById(R.id.explore_makent)
        manager = LinearLayoutManager(this)
        getAllData()
    }

    private fun getAllData() {
        Api.retrofitService.getAllData().enqueue(object : Callback<MakentData?> {
            override fun onResponse(call: Call<MakentData?>, response: Response<MakentData?>) {
               if (response.isSuccessful){
                   progressBar.isVisible=false
                   val modelProperties=response.body() as MakentData
                   Picasso.get().load(modelProperties.mobile_banner_image).into(imageView)
                   textView.text=modelProperties.mobile_banner_content
//                   recyclerView.apply {
//                       myAdapter=MyAdapter(modelProperties.Explore_list)
//                       layoutManager=manager
//                       adapter=myAdapter
//
//                   }

               }
            }

            override fun onFailure(call: Call<MakentData?>, t: Throwable) {
                Toast.makeText(this@ApiActivity,"something went wrong $t",Toast.LENGTH_SHORT).show()
            }
        })
    }
}
package com.example.homeproject.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import com.example.homeproject.R
import com.example.homeproject.makent.ApiCall
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetDataActivity : AppCompatActivity() {
    lateinit var imageView: ImageView
    lateinit var textView: TextView
    lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_data)
        imageView=findViewById(R.id.sampleImage)
        textView=findViewById(R.id.sampleText)
        progressBar=findViewById(R.id.sampleProgress)
        getContent()


    }

    private fun getContent() {
        ApiCall.retrofitSerVice.getInterface().enqueue(object : Callback<GetData?> {
            override fun onResponse(call: Call<GetData?>, response: Response<GetData?>) {
                if (response.isSuccessful){
                    progressBar.isVisible=false
                    val modelProperties=response.body() as GetData
                    Picasso.get().load(modelProperties.mobileBannerImage).into(imageView)
                    textView.text=modelProperties.mobileBannerContent
                }
            }

            override fun onFailure(call: Call<GetData?>, t: Throwable) {
                t.printStackTrace()

            }
        })
    }
}
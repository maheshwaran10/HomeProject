package com.example.homeproject.makent

import com.example.homeproject.sample.GetData
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BaseUrl = "https://makent.trioangledemo.com"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BaseUrl)
    .build()

interface ApiInterface {
    @GET("/api/home")
    fun getInterface(): Call<GetData>
}

object ApiCall {
    val retrofitSerVice: ApiInterface by lazy {
        retrofit.create(ApiInterface::class.java)
    }
}



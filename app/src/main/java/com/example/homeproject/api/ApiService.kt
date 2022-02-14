package com.example.homeproject.api

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://makent.trioangledemo.com"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface ApiService {

    @GET("/api/home")
    fun getAllData(): Call<MakentData>

}

object Api {
    val retrofitService: ApiService by lazy { retrofit.create(ApiService::class.java) }
}
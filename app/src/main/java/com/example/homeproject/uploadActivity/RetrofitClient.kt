package com.example.homeproject.uploadActivity

import retrofit2.Retrofit

object RetrofitClient {
    private var base_url=""
    private var retrofit:Retrofit?=null
    fun getClient:Retrofit{
        if (retrofit==null){
            retrofit=Retrofit.Builder()
                .baseUrl(baseUrl)

        }
    }
}
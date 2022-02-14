package com.example.homeproject.loadMore

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {
    companion object{
        var retrofit:Retrofit?=null
        private const val baseUrl="https://makent.trioangledemo.com/api/"

        fun getClient():Retrofit?{
            if (retrofit==null){
                var loggingInterceptor:HttpLoggingInterceptor = HttpLoggingInterceptor()
                var builder:OkHttpClient.Builder=OkHttpClient.Builder()
                builder.readTimeout(80,TimeUnit.SECONDS)
                builder.writeTimeout(90,TimeUnit.SECONDS)
                var gson:Gson=GsonBuilder().setLenient().create()
                retrofit=Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(builder.build())
                    .build()

            }
            return retrofit

        }
    }
}
package com.example.homeproject.uploadImage

import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.Retrofit




class AppConfig {

    var BASE_URL = "http://unitypuzzlegame.com/"

    fun getRetrofit(): Retrofit? {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
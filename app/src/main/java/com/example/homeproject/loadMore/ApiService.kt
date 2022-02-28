package com.example.homeproject.loadMore

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("explore")
    fun getContentList(
        @Query("page")page:String,
        @Query("token")token:String
    ):Call<List<LoadMoreData>>

}
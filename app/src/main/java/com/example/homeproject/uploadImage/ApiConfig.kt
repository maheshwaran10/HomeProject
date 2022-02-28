package com.example.homeproject.uploadImage

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Header

import retrofit2.http.PartMap

import retrofit2.http.POST

import retrofit2.http.Multipart
import java.util.HashMap

private const val BASE_URL = "http://unitypuzzlegame.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


interface ApiConfig {

    @Multipart
    @POST("images/upload_image.php")
    fun upload(
        @Header("Authorization") authorization: String?,
        @PartMap map: HashMap<String, RequestBody>
    ): Call<ServerResponse?>?
}
object Api {
    val retrofitService: ApiConfig by lazy {retrofit.create(ApiConfig::class.java) }
}
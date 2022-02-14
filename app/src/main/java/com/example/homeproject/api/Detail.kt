package com.example.homeproject.api

data class Detail(
    val bed_count: Int,
    val category: Int,
    val category_name: String,
    val city_name: String,
    val country_name: String,
    val currency_code: String,
    val currency_symbol: String,
    val id: Int,
    val instant_book: String,
    val is_covid_verified: Int,
    val is_wishlist: String,
    val latitude: String,
    val longitude: String,
    val name: String,
    val photo_name: List<String>,
    val price: Int,
    val rating: String,
    val reviews_count: Int,
    val type: String
)
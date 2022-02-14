package com.example.homeproject.loadMore

import com.google.gson.annotations.SerializedName


data class Data(

    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("room_type")
    var roomType: String? = null,

    @SerializedName("bed_count")
    var bedCount: Int? = null,

    @SerializedName("price")
    var price: String? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("photo_name")
    var photoName: ArrayList<String> = arrayListOf(),

    @SerializedName("rating")
    var rating: String? = null,

    @SerializedName("reviews_count")
    var reviewsCount: Int? = null,

    @SerializedName("instant_book")
    var instantBook: String? = null,

    @SerializedName("latitude")
    var latitude: String? = null,

    @SerializedName("longitude")
    var longitude: String? = null,

    @SerializedName("is_wishlist")
    var isWishlist: String? = null,

    @SerializedName("country_name")
    var countryName: String? = null,

    @SerializedName("city_name")
    var cityName: String? = null,

    @SerializedName("currency_code")
    var currencyCode: String? = null,

    @SerializedName("currency_symbol")
    var currencySymbol: String? = null,

    @SerializedName("is_covid_verified")
    var isCovidVerified: Int? = null

)
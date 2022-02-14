package com.example.homeproject.loadMore

import com.google.gson.annotations.SerializedName


data class LoadMoreData(

    @SerializedName("success_message")
    var successMessage: String? = null,

    @SerializedName("status_code")
    var statusCode: String? = null,

    @SerializedName("total_page")
    var totalPage: Int? = null,

    @SerializedName("min_price")
    var minPrice: String? = null,

    @SerializedName("max_price")
    var maxPrice: String? = null,

    @SerializedName("data")
    var data: ArrayList<Data> = arrayListOf()

)
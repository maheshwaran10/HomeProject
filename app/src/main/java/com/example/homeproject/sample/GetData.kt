package com.example.homeproject.sample

import com.google.gson.annotations.SerializedName

data class GetData(
    @SerializedName("success_message")
    var successMessage: String? = null,

    @SerializedName("status_code")
    var statusCode: String? = null,

    @SerializedName("mobile_banner_image")
    var mobileBannerImage: String? = null,

    @SerializedName("mobile_banner_content")
    var mobileBannerContent: String? = null,

    @SerializedName("unread_count")
    var unreadCount: Int? = null,

    @SerializedName("total_page")
    var totalPage: Int? = null,

)

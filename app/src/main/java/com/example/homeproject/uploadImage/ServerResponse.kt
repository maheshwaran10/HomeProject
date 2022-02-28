package com.example.homeproject.uploadImage

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ServerResponse(

    @SerializedName("status_code")
    @Expose
    var statusCode: String? = null,

    @SerializedName("status_message")
    @Expose
    var statusMessage: String? = null

)

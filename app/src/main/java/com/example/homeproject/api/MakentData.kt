package com.example.homeproject.api

data class MakentData(

    val mobile_banner_content: String,
    val mobile_banner_image: String,
    val status_code: String,
    val success_message: String,
    val total_page: Int,
    val unread_count: Int,
//    val Explore_list: List<Explore>,
    val Lists: List<Lists>
)
package com.example.gamenewsapp.data

import com.google.gson.annotations.SerializedName

data class News (
    val title: String,
    val type: NewsType,
    @SerializedName("img")
    val image: String?,
    @SerializedName("click_url")
    val clickUrl: String,
    val time: String,
    val top: Int
)
package com.example.gamenewsapp.data

import com.google.gson.annotations.SerializedName

enum class NewsType {
    @SerializedName("strories")
    STORIES,
    @SerializedName("video")
    VIDEO,
    @SerializedName("favourites")
    FAVOURITES
}
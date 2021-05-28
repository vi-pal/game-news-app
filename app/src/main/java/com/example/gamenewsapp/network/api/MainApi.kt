package com.example.gamenewsapp.network.api

import com.example.gamenewsapp.data.News
import retrofit2.http.GET
import retrofit2.http.Query

interface MainApi {
    @GET("/")
    suspend fun requestNews(
        @Query("page")
        offset: Int
    ): List<News>
}
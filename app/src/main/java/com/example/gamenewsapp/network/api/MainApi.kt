package com.example.gamenewsapp.network.api

import com.example.gamenewsapp.base.BaseResponse
import com.example.gamenewsapp.data.News
import retrofit2.http.GET

interface MainApi {
    @GET("")
    suspend fun requestNews(): BaseResponse<List<News>>
}
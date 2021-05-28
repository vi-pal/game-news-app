package com.example.gamenewsapp.data.repositories

import com.example.gamenewsapp.data.News
import com.example.gamenewsapp.network.BaseError
import com.example.gamenewsapp.network.Either

interface NewsRepository {
    suspend fun requestNews(offset: Int): Either<BaseError, List<News>?>
}
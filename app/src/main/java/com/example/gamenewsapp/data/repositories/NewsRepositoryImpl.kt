package com.example.gamenewsapp.data.repositories

import com.example.gamenewsapp.data.News
import com.example.gamenewsapp.network.BaseError
import com.example.gamenewsapp.network.Either
import com.example.gamenewsapp.network.api.MainApi
import com.example.gamenewsapp.network.proceedResponse

class NewsRepositoryImpl(private val api: MainApi) : NewsRepository {
    override suspend fun requestNews(offset: Int): Either<BaseError, List<News>?> {
        return proceedResponse {
            val response = api.requestNews(offset)
            Either.Success(response)
        }
    }
}
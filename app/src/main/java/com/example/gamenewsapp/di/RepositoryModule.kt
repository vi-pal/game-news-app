package com.example.gamenewsapp.di

import com.example.gamenewsapp.data.repositories.NewsRepository
import com.example.gamenewsapp.data.repositories.NewsRepositoryImpl
import org.koin.dsl.module

object RepositoryModule {
    val module = module {
        single<NewsRepository> { NewsRepositoryImpl(get()) }
    }
}
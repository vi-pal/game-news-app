package com.example.gamenewsapp.di

import com.example.gamenewsapp.presentation.viewmodels.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ViewModelModule {
    val module = module {
        viewModel { NewsViewModel(get()) }
    }
}
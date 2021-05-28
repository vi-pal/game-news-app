package com.example.gamenewsapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.gamenewsapp.base.BaseViewModel
import com.example.gamenewsapp.data.News
import com.example.gamenewsapp.data.repositories.NewsRepository

class NewsViewModel(private val repository: NewsRepository) : BaseViewModel() {

    private val _news: MutableLiveData<List<News>> = MutableLiveData()

    fun requestNews() {
        doOnBackground {
            repository.requestNews().either({

            }){
                _news.postValue(it)
            }
        }
    }
    val news: LiveData<List<News>> get() = _news
}
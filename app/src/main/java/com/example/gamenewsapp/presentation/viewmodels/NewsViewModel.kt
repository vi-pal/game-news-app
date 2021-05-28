package com.example.gamenewsapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.gamenewsapp.base.BaseViewModel
import com.example.gamenewsapp.data.News
import com.example.gamenewsapp.data.NewsType.*
import com.example.gamenewsapp.data.repositories.NewsRepository
import com.example.gamenewsapp.presentation.adapters.AdapterScrollListener

class NewsViewModel(private val repository: NewsRepository) : BaseViewModel(),
    AdapterScrollListener.OnLoadItemsListener {

    private val _data: MutableLiveData<List<News>> = MutableLiveData()

    private val _stories: MutableLiveData<List<News>> = MutableLiveData()
    private val _videos: MutableLiveData<List<News>> = MutableLiveData()
    private val _favourites: MutableLiveData<List<News>> = MutableLiveData()

    private val _storiesTop: MutableLiveData<List<News>> = MutableLiveData()

    fun requestNews(offset: Int) {
        doOnBackground {
            var tempStories = mutableListOf<News>()
            repository.requestNews(offset).either { list ->
                list?.forEach {
                    when (it.type) {
                        STORIES -> tempStories.add(it)
                        FAVOURITES -> tempStories.add(it)
                        VIDEO -> tempStories.add(it)
                    }
                }
                _stories.let {
                    tempStories.addAll(0, it.value ?: listOf())
                    it.postValue(tempStories)
                }
            }
        }
    }

    val data: LiveData<List<News>> get() = _data
    val stories: LiveData<List<News>> get() = _stories

    override fun onAdapterScrolled(offset: Int) {
        requestNews(offset)
    }
}
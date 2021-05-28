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

    fun requestNews(offset: Int) {
        doOnBackground {
            val tempStories = mutableListOf<News>()
            val tempVideos = mutableListOf<News>()
            val tempFavourites = mutableListOf<News>()

            repository.requestNews(offset).either { list ->
                list?.forEach {
                    when (it.type) {
                        STORIES -> tempStories.add(it)
                        VIDEO -> tempVideos.add(it)
                        FAVOURITES -> tempFavourites.add(it)
                    }
                }
                _stories.let {
                    tempStories.addAll(0, it.value ?: listOf())
                    it.postValue(tempStories)
                }
                _videos.let {
                    tempVideos.addAll(0, it.value ?: listOf())
                    it.postValue(tempVideos)
                }
                _favourites.let {
                    tempFavourites.addAll(0, it.value ?: listOf())
                    it.postValue(tempFavourites)
                }
            }
        }
    }

    val data: LiveData<List<News>> get() = _data

    val stories: LiveData<List<News>> get() = _stories
    val videos: LiveData<List<News>> get() = _videos
    val favourites: LiveData<List<News>> get() = _favourites


    override fun onAdapterScrolled(offset: Int) {
        requestNews(offset)
    }
}
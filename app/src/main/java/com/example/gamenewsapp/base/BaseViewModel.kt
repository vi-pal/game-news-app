package com.example.gamenewsapp.base

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : ViewModel() {

    private val _isLoading = MutableLiveData(false)
    var isLoading: LiveData<Boolean> = _isLoading


    fun <P> doOnBackground(
        showPreloader: Boolean = false,
        doOnAsyncBlock: suspend CoroutineScope.() -> P
    ) {
        setLoading(true)
        try {
            doOnUI {

            }
            doCoroutineWork(doOnAsyncBlock, Dispatchers.IO) {
                if (showPreloader) setLoading(false)
            }
        } catch (e: Exception) {
            Log.e("BaseViewModel", e.localizedMessage)
        }
        setLoading(false)
    }

    fun setLoading(loading: Boolean) {
        _isLoading.value = loading
    }

    fun <P> doOnUI(doOnAsyncBlock: suspend CoroutineScope.() -> P) {
        doCoroutineWork(doOnAsyncBlock, Dispatchers.Main) {}
    }

    private inline fun <P> doCoroutineWork(
        crossinline doOnAsyncBlock: suspend CoroutineScope.() -> P,
        context: CoroutineContext,
        crossinline doOnCompleteblock: suspend () -> Unit
    ) {
        viewModelScope.launch(context) {
            doOnAsyncBlock.invoke(this)
            doOnCompleteblock.invoke()
        }
    }
}
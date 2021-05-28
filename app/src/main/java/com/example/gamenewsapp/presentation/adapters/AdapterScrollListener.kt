package com.example.gamenewsapp.presentation.adapters

import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

open class AdapterScrollListener(
    val listener: OnLoadItemsListener
) : RecyclerView.OnScrollListener() {

    private var offset: Int = 1
    private var lastFirstVisibleItem: Int = 0

    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        super.onScrollStateChanged(recyclerView, newState)
        val firstVisibleItem =
            (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
        if (isLastItemVisible(recyclerView) && !listener.isLoading.value!!) {
            offset++
            listener.onAdapterScrolled(offset)
        }
        lastFirstVisibleItem = firstVisibleItem
    }

    private fun isLastItemVisible(recyclerView: RecyclerView): Boolean {
        val layoutManager = recyclerView.layoutManager as LinearLayoutManager
        val lastPositionVisible = layoutManager.findLastCompletelyVisibleItemPosition()
        val itemCount = recyclerView.adapter?.itemCount ?: 0
        return lastPositionVisible + 1 >= itemCount
    }

    interface OnLoadItemsListener {
        val isLoading: LiveData<Boolean>

        fun onAdapterScrolled(offset: Int)
    }
}
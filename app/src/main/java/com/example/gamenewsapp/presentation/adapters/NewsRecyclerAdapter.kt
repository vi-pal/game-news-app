package com.example.gamenewsapp.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gamenewsapp.data.News
import com.example.gamenewsapp.databinding.ItemNewsBinding

class NewsRecyclerAdapter(private val context: Context, private var data: List<News>): RecyclerView.Adapter<NewsRecyclerAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemNewsBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNewsBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context)
            .load(holder)
    }
}
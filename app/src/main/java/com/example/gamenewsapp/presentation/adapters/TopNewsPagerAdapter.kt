package com.example.gamenewsapp.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gamenewsapp.data.News
import com.example.gamenewsapp.databinding.ItemImageCardBinding

class TopNewsPagerAdapter(private val context: Context, private val topNews: List<News>): RecyclerView.Adapter<TopNewsPagerAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemImageCardBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TopNewsPagerAdapter.ViewHolder {
        val binding = ItemImageCardBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = topNews.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvTitle.text = topNews[position].title
        holder.binding.tvLink.text = topNews[position].clickUrl
        holder.binding.tvTime.text = topNews[position].time
        Glide.with(context)
            .load(topNews[position].image)
            .into(holder.binding.ivBackground)
    }
}
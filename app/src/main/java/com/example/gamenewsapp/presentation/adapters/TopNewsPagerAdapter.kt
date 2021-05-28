package com.example.gamenewsapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gamenewsapp.data.News
import com.example.gamenewsapp.databinding.ItemImageCardBinding
import com.squareup.picasso.Picasso

class TopNewsPagerAdapter(): RecyclerView.Adapter<TopNewsPagerAdapter.ViewHolder>() {

    private var topNews: List<News> = listOf()

    inner class ViewHolder(val binding: ItemImageCardBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TopNewsPagerAdapter.ViewHolder {
        return ViewHolder(ItemImageCardBinding
            .inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = topNews.size

    fun update(data: List<News>) {
        topNews = data
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvTitle.text = topNews[position].title
        holder.binding.tvLink.text = topNews[position].clickUrl
        holder.binding.tvTime.text = topNews[position].time
        Picasso.get()
            .load(topNews[position].image)
            .fit()
            .centerCrop()
            .into(holder.binding.ivBackground)
    }
}
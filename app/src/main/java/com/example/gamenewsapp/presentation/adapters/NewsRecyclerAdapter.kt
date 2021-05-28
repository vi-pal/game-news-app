package com.example.gamenewsapp.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gamenewsapp.data.News
import com.example.gamenewsapp.databinding.ItemNewsBinding
import com.example.gamenewsapp.presentation.adapters.NewsRecyclerAdapter.ViewHolder
import com.squareup.picasso.Picasso

class NewsRecyclerAdapter() : RecyclerView.Adapter<ViewHolder>() {

    private var data: MutableList<News> = mutableListOf()

    inner class ViewHolder(val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNewsBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }
    fun update(data: MutableList<News>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (data[position].image != null) {
            holder.binding.ivImage.visibility = View.VISIBLE
            Picasso.get()
                .load(data[position].image)
                .fit()
                .centerCrop()
                .into(holder.binding.ivImage)
        } else holder.binding.ivImage.visibility = View.GONE
        holder.binding.tvLink.text = data[position].clickUrl
        holder.binding.tvTitle.text = data[position].title
        holder.binding.tvTime.text = data[position].time
    }
}
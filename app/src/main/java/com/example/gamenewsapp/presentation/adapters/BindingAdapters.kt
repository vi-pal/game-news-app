package com.example.gamenewsapp.presentation.adapters

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("app:setImageViewIfNotNull")
fun setImageViewIfNotNull(view: ImageView, url: String?) {
    if (!url.isNullOrEmpty()) {
        view.visibility = View.VISIBLE
        Picasso.get()
            .load(url)
            .fit()
            .centerCrop()
            .into(view)
    } else view.visibility = View.GONE
}
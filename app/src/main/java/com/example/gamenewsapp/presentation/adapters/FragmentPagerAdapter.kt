package com.example.gamenewsapp.presentation.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.gamenewsapp.data.News
import com.example.gamenewsapp.data.NewsType
import com.example.gamenewsapp.presentation.fragments.ContentFragment

class FragmentPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle, val data: List<News>): FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ContentFragment(NewsType.STORIES)
            1 -> ContentFragment(NewsType.VIDEO)
            2 -> ContentFragment(NewsType.FAVOURITES)
            else -> Fragment()
        }
    }
}
package com.example.gamenewsapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.gamenewsapp.base.BaseFragment
import com.example.gamenewsapp.data.News
import com.example.gamenewsapp.data.NewsType
import com.example.gamenewsapp.databinding.FragmentContentBinding
import com.example.gamenewsapp.presentation.adapters.AdapterScrollListener
import com.example.gamenewsapp.presentation.adapters.NewsRecyclerAdapter
import com.example.gamenewsapp.presentation.adapters.TopNewsPagerAdapter
import com.example.gamenewsapp.presentation.viewmodels.NewsViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ContentFragment(private val type: NewsType) : BaseFragment() {

    override val viewModel: NewsViewModel by sharedViewModel()
    private lateinit var binding: FragmentContentBinding

    private val mAdapter = NewsRecyclerAdapter()
    private val mAdapterPager = TopNewsPagerAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentContentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun initViews() {
        initAdapters()
    }

    private fun initAdapters() {
        binding.rvNews.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context)
            val listener = AdapterScrollListener(viewModel)
            addOnScrollListener(listener)
        }
        mAdapterPager.registerAdapterDataObserver(binding.indicator.adapterDataObserver)
        binding.vpContainer.apply {
            adapter = mAdapterPager
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }
        binding.indicator.setViewPager(binding.vpContainer)
    }

    override fun initData() {
        viewModel.requestNews(0)
    }

    override fun subscribeUi() {
        when (type) {
            NewsType.STORIES -> {
                viewModel.stories.observe(viewLifecycleOwner, Observer {
                    mAdapter.update(it.toMutableList())
                    mAdapterPager.update(selectTop(it))
                })
            }
            NewsType.VIDEO -> {
                viewModel.videos.observe(viewLifecycleOwner, Observer {
                    mAdapter.update(it.toMutableList())
                    mAdapterPager.update(selectTop(it))
                })
            }
            NewsType.FAVOURITES -> {
                viewModel.favourites.observe(viewLifecycleOwner, Observer {
                    mAdapter.update(it.toMutableList())
                    mAdapterPager.update(selectTop(it))
                })
            }
        }
    }

    private fun selectTop(list: List<News>): MutableList<News> {
        val temp = mutableListOf<News>()
        list.forEach {
            if (it.top == 1) {
                temp.add(it)
            }
        }
        return temp
    }

}
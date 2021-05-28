package com.example.gamenewsapp.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.gamenewsapp.base.BaseFragment
import com.example.gamenewsapp.databinding.FragmentStoriesBinding
import com.example.gamenewsapp.presentation.adapters.AdapterScrollListener
import com.example.gamenewsapp.presentation.adapters.NewsRecyclerAdapter
import com.example.gamenewsapp.presentation.adapters.TopNewsPagerAdapter
import com.example.gamenewsapp.presentation.viewmodels.NewsViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class StoriesFragment : BaseFragment() {

    override val viewModel: NewsViewModel by sharedViewModel()
    private lateinit var binding: FragmentStoriesBinding

    private val mAdapter = NewsRecyclerAdapter()
    private val mAdapterPager = TopNewsPagerAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentStoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun initViews() {
        initAdapter()
    }

    private fun initAdapter() {
        binding.rvNews.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context)
            val listener = AdapterScrollListener(viewModel)
            addOnScrollListener(listener)
            listener.listener.isLoading.observe(viewLifecycleOwner, Observer {
                Log.d("LOADING", it.toString())
            })

        }

        binding.vpContainer.apply {
            adapter = mAdapterPager
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }
    }

    override fun initData() {
        viewModel.requestNews(0)
    }

    override fun subscribeUi() {
        viewModel.stories.observe(viewLifecycleOwner, Observer {
            mAdapter.update(it.toMutableList())
            mAdapterPager.update(it)
        })
    }

}
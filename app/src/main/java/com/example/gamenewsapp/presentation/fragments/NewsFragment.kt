package com.example.gamenewsapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.gamenewsapp.base.BaseFragment
import com.example.gamenewsapp.databinding.FragmentNewsBinding
import com.example.gamenewsapp.presentation.adapters.FragmentPagerAdapter
import com.example.gamenewsapp.presentation.viewmodels.NewsViewModel
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class NewsFragment() : BaseFragment() {

    override val viewModel: NewsViewModel by sharedViewModel()
    private lateinit var binding: FragmentNewsBinding

    private lateinit var adapter: FragmentPagerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun initViews() {
        binding.vpContainerNews
        binding.tlNews

        adapter = FragmentPagerAdapter(requireActivity().supportFragmentManager, lifecycle, listOf())

        binding.vpContainerNews.adapter = adapter

        TabLayoutMediator(binding.tlNews, binding.vpContainerNews) { tab, position ->
            when (position) {
                0 -> tab.text = "Stories"
                1 -> tab.text = "Video"
                2 -> tab.text = "Favourites"
            }
        }.attach()
    }

    override fun initData() {
        // TODO
    }

    override fun subscribeUi() {
        viewModel.data.observe(viewLifecycleOwner, Observer {

        })
    }
}
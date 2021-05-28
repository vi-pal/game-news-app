package com.example.gamenewsapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gamenewsapp.base.BaseFragment
import com.example.gamenewsapp.base.BaseViewModel
import com.example.gamenewsapp.databinding.FragmentNewsBinding
import com.example.gamenewsapp.presentation.adapters.NewsPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.android.ext.android.bind

class NewsFragment() : BaseFragment<FragmentNewsBinding>() {

    override lateinit var viewModel: BaseViewModel
    override lateinit var binding: FragmentNewsBinding

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

        val adapter = NewsPagerAdapter(requireActivity().supportFragmentManager, lifecycle)
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
        // TODO
    }
}
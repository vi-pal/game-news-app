package com.example.gamenewsapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.example.gamenewsapp.base.BaseFragment
import com.example.gamenewsapp.databinding.FragmentVideoBinding
import com.example.gamenewsapp.presentation.adapters.TopNewsPagerAdapter
import com.example.gamenewsapp.presentation.viewmodels.NewsViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class VideoFragment() : BaseFragment() {

    override val viewModel: NewsViewModel by sharedViewModel()
    private lateinit var binding: FragmentVideoBinding

    private val mAdapterPager = TopNewsPagerAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVideoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun initViews() {
    }

    private fun initAdapter() {

    }
    override fun initData() {
        viewModel.requestNews(0)
    }
    override fun subscribeUi() {
        initAdapter()

        viewModel.stories.observe(viewLifecycleOwner, Observer {
            mAdapterPager.update(it)
        })

    }

}

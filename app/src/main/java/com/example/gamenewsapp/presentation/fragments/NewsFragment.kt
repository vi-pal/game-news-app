package com.example.gamenewsapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gamenewsapp.base.BaseFragment
import com.example.gamenewsapp.base.BaseViewModel
import com.example.gamenewsapp.databinding.FragmentNewsBinding

class NewsFragment(

    override val viewModel: BaseViewModel,
    override var binding: FragmentNewsBinding

) : BaseFragment<FragmentNewsBinding>() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun initViews() {
        TODO("Not yet implemented")
    }

    override fun initData() {
        TODO("Not yet implemented")
    }

    override fun subscribeUi() {
        TODO("Not yet implemented")
    }
}
package com.example.gamenewsapp.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<B : ViewBinding> : Fragment() {

    protected abstract val viewModel: BaseViewModel
    protected abstract var binding: B

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initViews()
        subscribeUi()
    }

    protected abstract fun initViews()
    protected abstract fun initData()
    protected abstract fun subscribeUi()

}
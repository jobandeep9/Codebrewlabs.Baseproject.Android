package com.codebrewlabs.base_application.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import dagger.android.support.DaggerFragment

abstract class BaseFragment<T : ViewDataBinding> : Fragment(){

    private var rootView: View? = null
    protected lateinit var binding: T

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (rootView == null) {
            binding = initViewDataBinding(inflater,container)
            rootView = binding.root
            initialiseItems()
            setListeners()
            setData()
        }
        return rootView
    }


    abstract fun initialiseItems()

    abstract fun setListeners()

    abstract fun setData()

    abstract fun initViewDataBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): T

}
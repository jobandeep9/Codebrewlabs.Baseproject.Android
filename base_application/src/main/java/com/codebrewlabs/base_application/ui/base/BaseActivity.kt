package com.codebrewlabs.base_application.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {

    protected lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = initViewDataBinding()
        initialiseItems()
        setListeners()
        setData()
    }
    abstract fun initialiseItems()

    abstract fun setListeners()

    abstract fun setData()

    abstract fun initViewDataBinding(): T

}
package com.baseapplication.ui.main

import androidx.databinding.DataBindingUtil
import com.baseapplication.R
import com.baseapplication.databinding.ActivityLaunchBinding
import com.codebrewlabs.base_application.utils.base.BaseActivity
import com.codebrewlabs.base_application.utils.LaunchUtil

class LaunchActivity : BaseActivity<ActivityLaunchBinding>() {

    override fun initialiseItems() {
        LaunchUtil.launchBaseApp(this)
    }

    override fun setListeners() {
    }

    override fun setData() {
    }

    override fun initViewDataBinding(): ActivityLaunchBinding {
        return DataBindingUtil.setContentView(this, R.layout.activity_launch)
    }
}

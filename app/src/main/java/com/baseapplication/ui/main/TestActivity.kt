package com.baseapplication.ui.main

import android.content.Intent
import androidx.databinding.DataBindingUtil
import com.baseapplication.R
import com.baseapplication.databinding.ActivityTestBinding
import com.codebrewlabs.base_application.ui.base.BaseActivity

class TestActivity : BaseActivity<ActivityTestBinding>() {

    override fun initialiseItems() {

        try {
            val intent = Intent(
                this,
                Class.forName("com.codebrewlabs.base_application.ui.loginsignup.SignUpActivity")
            )
            startActivity(intent)
        } catch (e: ClassNotFoundException) {
            print(e.message)
        }
    }

    override fun setListeners() {
    }

    override fun setData() {
    }

    override fun initViewDataBinding(): ActivityTestBinding {
        return DataBindingUtil.setContentView(this, R.layout.activity_test)
    }
}

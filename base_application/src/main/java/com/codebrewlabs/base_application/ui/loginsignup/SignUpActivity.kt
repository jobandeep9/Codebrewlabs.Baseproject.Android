package com.codebrewlabs.base_application.ui.loginsignup

import androidx.databinding.DataBindingUtil
import com.codebrewlabs.base_application.R
import com.codebrewlabs.base_application.databinding.ActivityContainerBinding
import com.codebrewlabs.base_application.utils.base.BaseActivity
import com.codebrewlabs.base_application.ui.loginsignup.welcome.WelcomeFragment
import com.codebrewlabs.base_application.utils.addFragment

class SignUpActivity : BaseActivity<ActivityContainerBinding>() {

    override fun initialiseItems() {
//        LocaleHelper.setLocale(this, userRepository.getUserLanguage(), prefsManager)
        addFragment(supportFragmentManager, WelcomeFragment(), R.id.container)
    }

    override fun setListeners() {
    }

    override fun setData() {
    }

    override fun initViewDataBinding(): ActivityContainerBinding {
        return DataBindingUtil.setContentView(this, R.layout.activity_container)
    }

}

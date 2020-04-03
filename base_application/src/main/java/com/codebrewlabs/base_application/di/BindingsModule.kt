package com.codebrewlabs.base_application.di

import com.codebrewlabs.base_application.ui.SplashActivity
import com.codebrewlabs.base_application.utils.base.BaseActivity
import com.codebrewlabs.base_application.ui.loginsignup.LoginFragment
import com.codebrewlabs.base_application.ui.loginsignup.SignUpActivity
import com.codebrewlabs.base_application.ui.loginsignup.SignUpFragment
import com.codebrewlabs.base_application.ui.loginsignup.welcome.WelcomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BindingsModule {

    @ContributesAndroidInjector
    abstract fun splashActivity(): SplashActivity

    @ContributesAndroidInjector
    abstract fun signUpActivity(): SignUpActivity

    @ContributesAndroidInjector
    abstract fun welcomeFragment(): WelcomeFragment

    @ContributesAndroidInjector
    abstract fun signUpFragment(): SignUpFragment


    @ContributesAndroidInjector
    abstract fun loginFragment(): LoginFragment


}
package com.codebrewlabs.base_application.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.codebrewlabs.base_application.ui.EnterPhoneViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class ViewModelsModule {

    @Module
    companion object {

        @Provides
        @Singleton
        @JvmStatic
        fun viewModelProviderFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory =
            factory
    }

    @Binds
    @IntoMap
    @ViewModelKey(EnterPhoneViewModel::class)
    abstract fun bindSplashViewModel(viewModel: EnterPhoneViewModel): ViewModel

}
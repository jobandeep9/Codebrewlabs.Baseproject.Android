package com.codebrewlabs.base_application.di

import com.codebrewlabs.base_application.utils.base.BaseAppApplication
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    BindingsModule::class,
    ServiceBuilderModule::class,
    NetworkModule::class,
    ViewModelsModule::class
])
@Singleton
interface AppComponent : AndroidInjector<BaseAppApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<BaseAppApplication>()
}
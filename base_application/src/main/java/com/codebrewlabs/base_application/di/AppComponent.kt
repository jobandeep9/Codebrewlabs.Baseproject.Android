package com.codebrewlabs.base_application.di

import com.codebrewlabs.base_application.AppApplication
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
interface AppComponent : AndroidInjector<AppApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<AppApplication>()
}
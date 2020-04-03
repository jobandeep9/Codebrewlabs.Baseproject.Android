package com.codebrewlabs.base_application.di

import com.codebrewlabs.base_application.pushNotifications.MessagingService
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ServiceBuilderModule {

    @ContributesAndroidInjector
    abstract fun messagingService(): MessagingService

}
package com.codebrewlabs.base_application

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.codebrewlabs.base_application.data.repos.UserRepository
import com.codebrewlabs.base_application.di.DaggerAppComponent
import com.codebrewlabs.base_application.utils.PrefsManager
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Inject


class AppApplication : DaggerApplication() {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var userRepository: UserRepository

    @Inject
    lateinit var prefsManager: PrefsManager


    override fun onCreate() {
        super.onCreate()

        /*if (Config.baseURL != Config.BASE_URL_DEV && Config.baseURL != Config.BASE_URL_LOCAL)
            Fabric.with(this, Crashlytics())*/

        setsApplication(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder().create(this)

    companion object {

        /**
         * The service to be launched for the incoming call.
         */

        private var callServiceClass: Class<*>? = null

        private var isApplication: Application? = null

        fun getCallServiceClass(): Class<*>? {
            return callServiceClass
        }

        fun setCallServiceClass(callServiceClass: Class<*>) {
            Companion.callServiceClass = callServiceClass
        }


        fun setsApplication(sApplication: Application) {
            isApplication = sApplication
        }
    }
}
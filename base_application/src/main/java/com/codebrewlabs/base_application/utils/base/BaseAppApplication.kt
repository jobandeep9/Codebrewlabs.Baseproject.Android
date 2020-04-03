package com.codebrewlabs.base_application.utils.base

import android.app.Activity
import android.app.Application
import android.os.Bundle


abstract class BaseAppApplication : Application(), Application.ActivityLifecycleCallbacks {

    init {
        this.registerActivityLifecycleCallbacks(this)
    }

    override fun onCreate() {
        super.onCreate()
        ourInstance = this
        initialiseImportantThings()
    }

    abstract fun initialiseImportantThings()


    override fun onActivityPaused(activity: Activity) {

    }

    override fun onActivityStarted(activity: Activity) {
    }

    override fun onActivityDestroyed(activity: Activity) {
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
    }

    override fun onActivityStopped(activity: Activity) {
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
    }

    override fun onActivityResumed(activity: Activity) {
    }

    companion object {
        private lateinit var ourInstance: BaseAppApplication

        fun getAppContext(): BaseAppApplication {
            return ourInstance
        }
    }

}
package com.baseapplication

import android.app.Application


class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        /*if (Config.baseURL != Config.BASE_URL_DEV && Config.baseURL != Config.BASE_URL_LOCAL)
            Fabric.with(this, Crashlytics())*/

        setsApplication(this)
    }
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
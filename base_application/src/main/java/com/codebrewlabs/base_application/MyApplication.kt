package com.codebrewlabs.base_application

import android.app.Activity
import com.codebrewlabs.base_application.utils.base.BaseAppApplication
import com.codebrewlabs.base_application.utils.CurrentSession
import com.codebrewlabs.base_application.utils.SharedPrefUtils

open class MyApplication : BaseAppApplication() {

    override fun initialiseImportantThings() {
        SharedPrefUtils.initiate(this)
        CurrentSession.initiateCurrentSession()
    }

    override fun onActivityPaused(activity: Activity) {
        CurrentSession.cI.saveDataLocally()
        super.onActivityPaused(activity)
    }

}
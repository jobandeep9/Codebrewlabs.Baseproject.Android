package com.codebrewlabs.base_application.utils

import com.codebrewlabs.base_application.data.models.responses.UserData
import com.codebrewlabs.base_application.pushNotifications.MessagingService
import com.codebrewlabs.base_application.utils.base.BaseCurrentSession

/**
 * This is the singleton class which will have instance through out the application.
 * We can use this class for accessing the app persistence data according to our needs.
 * Also we can access data stored on device shared preference from this class using method "getLocalData()".
 * **/

class CurrentSession private constructor(
    localData: LocalData,
    localDataClass: Class<LocalData>
) : BaseCurrentSession<LocalData>(localData, localDataClass) {

    lateinit var messagingService: MessagingService

    init {
//        messagingService = MessagingService(UserRepository(MyApplication(),WebService()))
    }


    fun getUserData(): UserData? {
        return localData?.userData
    }


    companion object {
        val cI: CurrentSession
            get() {
                if (i == null) {
                    initiateCurrentSession()
                }
                return i as CurrentSession
            }

        fun initiateCurrentSession() {
            if (i == null) {
                CurrentSession(LocalData(), LocalData::class.java)
            }
        }
    }
}
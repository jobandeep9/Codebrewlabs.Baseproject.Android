package com.codebrewlabs.base_application.data.repos

import android.content.Context
import android.net.ConnectivityManager
import androidx.lifecycle.MutableLiveData
import com.codebrewlabs.base_application.AppApplication
import com.codebrewlabs.base_application.data.models.responses.UserData
import com.codebrewlabs.base_application.utils.PUSH_DATA
import com.codebrewlabs.base_application.utils.PrefsManager
import com.codebrewlabs.base_application.utils.USER_DATA
import com.codebrewlabs.base_application.utils.USER_LANGUAGE
import com.codebrewlabs.base_application.data.apis.WebService
import com.codebrewlabs.base_application.data.models.PushData
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class UserRepository @Inject constructor(
    private val app: AppApplication,
    private val prefsManager: PrefsManager, private val webService: WebService
) {

    val groupCreatedCall = MutableLiveData<String>()
    val loginGuestUser = MutableLiveData<String>()
    val groupExitResponse = MutableLiveData<Pair<Boolean, String>>()
    val pushData = MutableLiveData<PushData>()
    val isNewNotification = MutableLiveData<Boolean>()


    fun isNetworkConnected(): Boolean {
        val connectivityManager =
            app.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivityManager.activeNetworkInfo != null && connectivityManager.activeNetworkInfo.isConnected
    }

    fun isUserLoggedIn(): Boolean {
        val user = prefsManager.getObject(USER_DATA, UserData::class.java)
        user?.id?.let {
            return true
        }
        return false
    }


    fun getUser(): UserData? {
        return prefsManager.getObject(USER_DATA, UserData::class.java)
    }


    fun getUserLanguage(): String {
        return prefsManager.getString(USER_LANGUAGE, "en")
    }

    fun getPushCallData(): PushData? {
        return prefsManager.getObject(PUSH_DATA, PushData::class.java)
    }

    fun pushTokenUpdate(token: String) {
        val hashMap = HashMap<String, String>()
        hashMap["deviceToken"] = token

        /*webService.updatePushToken(getEncryptedData(hashMap))
            .enqueue(object : Callback<ApiResponse<Any>> {

                override fun onResponse(
                    call: Call<ApiResponse<Any>>,
                    response: Response<ApiResponse<Any>>
                ) {
                    if (response.isSuccessful) {
                        Log.e("fcmToken", "Success")
                    } else {
                        Log.e("fcmToken", "Faliure")
                    }
                }

                override fun onFailure(call: Call<ApiResponse<Any>>, throwable: Throwable) {
                    Log.e("fcmToken", "faliue 500")
                }
            })*/
    }

}


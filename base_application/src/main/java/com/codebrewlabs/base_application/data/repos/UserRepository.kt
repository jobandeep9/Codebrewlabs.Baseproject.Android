package com.codebrewlabs.base_application.data.repos

import android.content.Context
import android.net.ConnectivityManager
import androidx.lifecycle.MutableLiveData
import com.codebrewlabs.base_application.MyApplication
import com.codebrewlabs.base_application.data.models.responses.UserData
import com.codebrewlabs.base_application.data.apis.WebService
import com.codebrewlabs.base_application.data.models.PushData
import com.codebrewlabs.base_application.utils.*
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class UserRepository @Inject constructor(
    private val myApp: MyApplication,
    private val webService: WebService
) {

    val groupCreatedCall = MutableLiveData<String>()
    val loginGuestUser = MutableLiveData<String>()
    val groupExitResponse = MutableLiveData<Pair<Boolean, String>>()
    val pushData = MutableLiveData<PushData>()
    val isNewNotification = MutableLiveData<Boolean>()


    fun isNetworkConnected(): Boolean {
        val connectivityManager =
            myApp.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivityManager.activeNetworkInfo != null && connectivityManager.activeNetworkInfo.isConnected
    }

    fun isUserLoggedIn(): Boolean {
        val user = CurrentSession.cI.getUserData()
        user?.id?.let {
            return true
        }
        return false
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


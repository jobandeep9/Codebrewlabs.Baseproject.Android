package com.codebrewlabs.base_application.ui

import androidx.lifecycle.ViewModel
import com.codebrewlabs.base_application.data.apis.WebService
import com.codebrewlabs.base_application.data.models.responses.UserData
import com.codebrewlabs.base_application.data.network.responseUtil.ApiResponse
import com.codebrewlabs.base_application.data.network.responseUtil.ApiUtils
import com.codebrewlabs.base_application.data.network.responseUtil.Resource
import com.codebrewlabs.base_application.di.SingleLiveEvent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class EnterPhoneViewModel @Inject constructor(private val webService: WebService) : ViewModel() {

    val numberLogin by lazy { SingleLiveEvent<Resource<UserData>>() }

    val verifyOtp by lazy { SingleLiveEvent<Resource<UserData>>() }

    val resendOtp by lazy { SingleLiveEvent<Resource<UserData>>() }

    fun numberLogin(hashMap: HashMap<String, Any>) {
        numberLogin.value = Resource.loading()

        webService.numberLogin(hashMap)
                .enqueue(object : Callback<ApiResponse<UserData>> {

                    override fun onResponse(call: Call<ApiResponse<UserData>>,
                                            response: Response<ApiResponse<UserData>>) {
                        if (response.isSuccessful) {
                            numberLogin.value = Resource.success(response.body()?.data)
                        } else {
                            numberLogin.value = Resource.error(
                                    ApiUtils.getError(response.code(),
                                            response.errorBody()?.string()))
                        }
                    }

                    override fun onFailure(call: Call<ApiResponse<UserData>>, throwable: Throwable) {
                        numberLogin.value = Resource.error(ApiUtils.failure(throwable))
                    }

                })
    }


    fun verifyOtp(hashMap: HashMap<String, Any>) {
        verifyOtp.value = Resource.loading()

        webService.verifyOtp(hashMap)
                .enqueue(object : Callback<ApiResponse<UserData>> {

                    override fun onResponse(call: Call<ApiResponse<UserData>>,
                                            response: Response<ApiResponse<UserData>>) {
                        if (response.isSuccessful) {
                            verifyOtp.value = Resource.success(response.body()?.data)
                        } else {
                            verifyOtp.value = Resource.error(
                                    ApiUtils.getError(response.code(),
                                            response.errorBody()?.string()))
                        }
                    }

                    override fun onFailure(call: Call<ApiResponse<UserData>>, throwable: Throwable) {
                        verifyOtp.value = Resource.error(ApiUtils.failure(throwable))
                    }

                })
    }

    fun resendOtp(hashMap: HashMap<String, Any>) {
        resendOtp.value = Resource.loading()

        webService.resendOtp(hashMap)
                .enqueue(object : Callback<ApiResponse<UserData>> {

                    override fun onResponse(call: Call<ApiResponse<UserData>>,
                                            response: Response<ApiResponse<UserData>>) {
                        if (response.isSuccessful) {
                            resendOtp.value = Resource.success(response.body()?.data)
                        } else {
                            resendOtp.value = Resource.error(
                                    ApiUtils.getError(response.code(),
                                            response.errorBody()?.string()))
                        }
                    }

                    override fun onFailure(call: Call<ApiResponse<UserData>>, throwable: Throwable) {
                        resendOtp.value = Resource.error(ApiUtils.failure(throwable))
                    }

                })
    }
}
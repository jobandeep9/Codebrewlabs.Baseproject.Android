package com.codebrewlabs.base_application.data.apis

import com.codebrewlabs.base_application.data.models.responses.UserData
import com.codebrewlabs.base_application.data.network.responseUtil.ApiResponse
import retrofit2.Call
import retrofit2.http.*


interface WebService {
    companion object {

        private const val NUMBER_LOGIN = "/api/number-login"
        private const val VERIFY_OTP = "/api/verify-otp"
        private const val RESEND_OTP="api/resend-otp"
        private const val WORKING_HOURS = "/api/workingHours"
        private const val SPEAKOUT_LIST = "/common/listSpeakouts"

    }

    /*POST APIS*/
    @FormUrlEncoded
    @POST(NUMBER_LOGIN)
    fun numberLogin(@FieldMap hashMap: HashMap<String, Any>): Call<ApiResponse<UserData>>

    @FormUrlEncoded
    @POST(VERIFY_OTP)
    fun verifyOtp(@FieldMap hashMap: HashMap<String, Any>): Call<ApiResponse<UserData>>

    @FormUrlEncoded
    @POST(RESEND_OTP)
    fun resendOtp(@FieldMap hashMap: HashMap<String, Any>): Call<ApiResponse<UserData>>


    /*GET*/
    @GET(SPEAKOUT_LIST)
    fun getSpeakOutList(@QueryMap hashMap: Map<String, String>): Call<ApiResponse<Any>>


    /*PUT API*/
    @FormUrlEncoded
    @PUT(WORKING_HOURS)
    fun workingHours(@FieldMap hashMap: HashMap<String, String>): Call<ApiResponse<Any>>

}
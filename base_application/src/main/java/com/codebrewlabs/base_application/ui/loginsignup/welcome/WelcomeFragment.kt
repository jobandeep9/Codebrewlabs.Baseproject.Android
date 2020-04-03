package com.codebrewlabs.base_application.ui.loginsignup.welcome

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.codebrewlabs.base_application.R
import com.codebrewlabs.base_application.databinding.FragmentWelcomeBinding
import com.codebrewlabs.base_application.ui.base.BaseFragment
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.GraphRequest
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import java.util.*


class WelcomeFragment : BaseFragment<FragmentWelcomeBinding>() {

    private var callbackManager: CallbackManager? = CallbackManager.Factory.create()

    override fun initialiseItems() {

    }

    override fun setListeners() {
        binding.tvFacebook.setOnClickListener {
            loginFacebook()
        }
    }

    override fun setData() {

    }

    override fun initViewDataBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentWelcomeBinding {
        return DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)
    }

    private fun loginFacebook() {
        LoginManager.getInstance()
            .logInWithReadPermissions(this, Arrays.asList("public_profile", "email"))

        LoginManager.getInstance().registerCallback(callbackManager, object :
            FacebookCallback<LoginResult> {

            override fun onSuccess(loginResult: LoginResult) {
                val request =
                    GraphRequest.newMeRequest(loginResult.accessToken) { fbObject, response ->
                        try {
                            val fbId = fbObject.optString("id")
                            val fbName = fbObject.optString("name")

                            if (fbObject.has("email")) {
                                val fbEmail = fbObject.optString("email")
                            }

                            /*Handle Result*/

                            /* if (isConnectedToInternet(requireActivity(), true)) {

                                 val hashMap = HashMap<String, Any>()

                                 hashMap["facebookId"] = fbId
                                 hashMap["name"] = fbName
                                 hashMap["role"] = selectedType
                                 hashMap["deviceType"] = ANDROID
                                 hashMap["phone"] = ""
                                 hashMap["countryCode"] = ""

                                 viewModel.socialLogin(hashMap)
                             }*/
                        } catch (e: Exception) {
                            e.printStackTrace()
                            //      dismissDialogLogin()
                        }
                    }

                val parameters = Bundle()
                parameters.putString("fields", "name,email,id,picture.type(large)")
                request.parameters = parameters
                request.executeAsync()
            }

            override fun onCancel() {
                Log.e("FBLOGIN_FAILD", "Cancel")
            }

            override fun onError(error: FacebookException) {
                Log.e("FBLOGIN_FAILD", "ERROR", error)
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager?.onActivityResult(requestCode, resultCode, data)
    }
}

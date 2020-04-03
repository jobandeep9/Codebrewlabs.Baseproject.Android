package com.codebrewlabs.base_application.ui.loginsignup

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.codebrewlabs.base_application.R
import com.codebrewlabs.base_application.databinding.FragmentSignupBinding
import com.facebook.CallbackManager
import dagger.android.support.DaggerFragment


class SignUpFragment : DaggerFragment() {

    private lateinit var binding: FragmentSignupBinding

    private var rootView: View? = null

    private var callbackManager: CallbackManager? = CallbackManager.Factory.create()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (rootView == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_signup, container, false)
            rootView = binding.root
            initialise()
            listeners()
        }
        return rootView
    }

    private fun initialise() {
    }

    private fun listeners() {

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager?.onActivityResult(requestCode, resultCode, data)
    }
}

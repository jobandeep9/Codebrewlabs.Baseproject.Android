package com.codebrewlabs.base_application.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.codebrewlabs.base_application.R
import com.codebrewlabs.base_application.ui.loginsignup.SignUpActivity
import dagger.android.support.DaggerAppCompatActivity

class SplashActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        waitTime()
    }


    private fun waitTime() {

        Handler().postDelayed({
            startActivity(Intent(this, SignUpActivity::class.java))
            finish()

        }, 3000)
    }
}

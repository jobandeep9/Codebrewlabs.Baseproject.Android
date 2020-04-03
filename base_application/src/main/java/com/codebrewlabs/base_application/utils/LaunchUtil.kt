package com.codebrewlabs.base_application.utils

import android.content.Context
import android.content.Intent

class LaunchUtil {
    companion object {
        @JvmStatic
        fun launchBaseApp(context: Context) {
            try {
                val intent = Intent(
                    context,
                    Class.forName("com.codebrewlabs.base_application.ui.loginsignup.SignUpActivity")
                )
                context.startActivity(intent)
            } catch (e: ClassNotFoundException) {
                print(e.message)
            }
        }
    }
}
package com.codebrewlabs.base_application.utils

import android.app.Activity
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.codebrewlabs.base_application.R
import com.codebrewlabs.base_application.ui.SplashActivity
import com.google.android.material.snackbar.Snackbar
import java.util.*

fun View.gone() {
    visibility = View.GONE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}


fun View.showSnackBar(msg: String) {
    try {
        val snackBar = Snackbar.make(this, msg, Snackbar.LENGTH_LONG)
        val snackBarView = snackBar.view
        val textView =
                snackBarView.findViewById<View>(R.id.snackbar_text) as TextView
        textView.maxLines = 3
        snackBar.setAction(R.string.ok) { snackBar.dismiss() }
        snackBarView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary))
        snackBar.setActionTextColor(ContextCompat.getColor(context, R.color.colorPrimary))
        snackBar.show()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun logoutUser(activity: Activity?, prefsManager: PrefsManager) {

    Log.d("logoutCalled", "clearData")

    val notificationManager =
            activity?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    notificationManager.cancelAll()


    prefsManager.remove(USER_DATA)

    activity.startActivity(
            Intent(activity, SplashActivity::class.java)
                    .addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
    )

    activity.setResult(Activity.RESULT_CANCELED)
    ActivityCompat.finishAffinity(activity)
    activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
}


/*Digits should be 0,1,2,3*/
fun getCountFormat(digits: Int, count: Int?): String {
    when (digits) {
        1 -> return if (count ?: 0 <= 9)
            count.toString()
        else
            String.format(Locale.ENGLISH, "%d+", 9)
        2 -> return if (count ?: 0 <= 99)
            count.toString()
        else
            String.format(Locale.ENGLISH, "%d+", 99)
        3 -> return if (count ?: 0 <= 999)
            count.toString()
        else
            String.format(Locale.ENGLISH, "%d+", 999)
        else -> return if (count ?: 0 <= 9999)
            count.toString()
        else
            String.format(Locale.ENGLISH, "%d+", 9999)
    }
}


fun Context.longToast(text: CharSequence) {
    Toast.makeText(this, text, Toast.LENGTH_LONG).show()
}

fun addFragment(fragmentManager: FragmentManager?, fragment: Fragment, id: Int) {
    fragmentManager?.beginTransaction()?.setCustomAnimations(0, 0, 0, 0)
            ?.add(id, fragment)?.commit()
}

fun addFragmentAnim(fragmentManager: FragmentManager?, fragment: Fragment, id: Int) {
    fragmentManager?.beginTransaction()?.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
        ?.add(id, fragment)?.commit()
}

fun addFragmentToBackStack(fragmentManager: FragmentManager?, fragment: Fragment, id: Int) {
    fragmentManager?.beginTransaction()?.setCustomAnimations(0, 0, 0, 0)
            ?.add(id, fragment)?.addToBackStack("")?.commit()
}

fun replaceFragmentNoBackStack(fragmentManager: FragmentManager?, fragment: Fragment, id: Int) {
    fragmentManager?.beginTransaction()?.replace(id, fragment)?.commit()
}

fun replaceFragment(fragmentManager: FragmentManager?, fragment: Fragment, id: Int) {
    fragmentManager?.beginTransaction()?.replace(id, fragment)?.addToBackStack(null)?.commit()
}

fun replaceFragmentWithoutBackStack(fragmentManager: FragmentManager?, fragment: Fragment, id: Int) {
    fragmentManager?.beginTransaction()?.setCustomAnimations(
            android.R.anim.fade_in,
            android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out
    )?.replace(id, fragment)?.commit()
}


fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun View.showKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.toggleSoftInputFromWindow(applicationWindowToken,
            InputMethodManager.SHOW_FORCED, 0)
}

fun makeFullScreen(activity: Activity) {
    activity.window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    activity.window.statusBarColor = Color.TRANSPARENT
}
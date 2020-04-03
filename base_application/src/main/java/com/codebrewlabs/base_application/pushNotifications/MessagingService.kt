package com.codebrewlabs.base_application.pushNotifications

import android.annotation.TargetApi
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.codebrewlabs.base_application.data.models.PushData
import com.codebrewlabs.base_application.R
import com.codebrewlabs.base_application.data.repos.UserRepository
import com.codebrewlabs.base_application.ui.SplashActivity
import com.codebrewlabs.base_application.utils.PrefsManager
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import dagger.android.AndroidInjection
import java.util.*
import javax.inject.Inject


class MessagingService(private var userRepository: UserRepository) : FirebaseMessagingService() {

    private val channelId = "Base"

    private lateinit var notificationData: PushData


    override fun onCreate() {
        AndroidInjection.inject(this)
        super.onCreate()
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.e("fcmToken", token)

        if (userRepository.isUserLoggedIn()) {
            userRepository.pushTokenUpdate(token)
        }
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.e("remoteMessage", remoteMessage?.data.toString())

        sendNotification(remoteMessage)
    }



    @TargetApi(Build.VERSION_CODES.O)
    private fun sendNotification(message: RemoteMessage?) {

        userRepository.isNewNotification.postValue(true)

        /*val notificationData = JSONObject(message?.data)
        val notification = JSONObject(notificationData.toString())


        *//*Set up data to class *//*
        val pushData = PushData(
            msg = notificationData.optString("msg"),
            title = notificationData.optString("title"),
            sound = notificationData.optString("sound")
        )*/
        val msg = /*notification.getString("message")*/""

        val requestID = Calendar.getInstance().timeInMillis.toInt()

        /*Stack builder home activity*/
        val stackBuilder = TaskStackBuilder.create(this)

        stackBuilder.addParentStack(SplashActivity::class.java)
        val homeIntent = Intent(this, SplashActivity::class.java)
        stackBuilder.addNextIntent(homeIntent)

        Log.e("Notification", "Parent added")
        /*Final activity to open*/
        val intent: Intent


        /*val pendingIntent = PendingIntent.getActivity(this, requestID,
                intent, PendingIntent.FLAG_UPDATE_CURRENT)*/

        /*Flags*/
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        homeIntent.action = System.currentTimeMillis().toString()

        val pendingIntent =
            stackBuilder.getPendingIntent(requestID, PendingIntent.FLAG_UPDATE_CURRENT)

        val title = getString(R.string.app_name)
        val notificationBuilder = NotificationCompat.Builder(this, channelId)
            .setContentTitle(title) //Header
            .setContentText(msg) //Content
            .setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher))
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            notificationBuilder.setSmallIcon(R.drawable.ic_launcher_background)
            notificationBuilder.color = ContextCompat.getColor(this, R.color.colorAccent)
        } else {
            notificationBuilder.setSmallIcon(R.mipmap.ic_launcher)
        }

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val mChannel = NotificationChannel(
                channelId, getText(R.string.app_name),
                NotificationManager.IMPORTANCE_HIGH)

            notificationManager.createNotificationChannel(mChannel)
        }
        notificationManager.notify(requestID, notificationBuilder.build())
    }
}
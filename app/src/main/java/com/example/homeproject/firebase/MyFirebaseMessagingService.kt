package com.example.homeproject.firebase

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.example.homeproject.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class MyFirebaseMessagingService:FirebaseMessagingService() {

    override fun onMessageReceived(p0: RemoteMessage) {
       if (p0.notification !=null){
           generateNotification(p0.notification!!.title!!,p0.notification!!.body!!)

       }

    }

    fun getRetRemoteView(tittle:String,message:String):RemoteViews{
        val remoteView=RemoteViews("com.example.homeproject.firebase",R.layout.notification)
        remoteView.setTextViewText(R.id.title,tittle)
        remoteView.setTextViewText(R.id.message,message)
        remoteView.setImageViewResource(R.id.icon,R.drawable.tajmahal)
        return remoteView
    }


    fun generateNotification(tittle:String,message:String){
        val intent= Intent(this,FirebaseActivityActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        val pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT)
        var builder:NotificationCompat.Builder=NotificationCompat.Builder(applicationContext,
            channelId)
            .setSmallIcon(R.drawable.tajmahal)
            .setVibrate(longArrayOf(1000,1000,1000,1000))
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)
            .setOnlyAlertOnce(true)
        builder=builder.setContent(getRetRemoteView(tittle,message))

        val notificationManager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){
            val notificationChannel=NotificationChannel(channelId, channelName,NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChannel)

        }
        notificationManager.notify(0,builder.build())

    }

    companion object{
        const val channelId="notification Channel"
        const val channelName="com.example.homeproject.firebase"
    }
}
package com.neyamul.learning.service;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.neyamul.learning.Notification;
import com.neyamul.learning.R;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG="MyFirebaseMsgService";

    private static final String CHANNEL_ID="fcm_default_channel";

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        if (remoteMessage.getNotification()!=null){
            String title=remoteMessage.getNotification().getTitle();
            String body=remoteMessage.getNotification().getBody();

            Log.d(TAG,"onMessageReceived: "+title);
            Log.d(TAG,"onMessageReceived: "+body);
            
            sendNotification(title,body);

        }

    }

    private void sendNotification(String title, String messagebody) {
        Intent intent=new Intent(this, Notification.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent=PendingIntent.getActivity(
                this ,
                0,
                intent,
                PendingIntent.FLAG_ONE_SHOT|PendingIntent.FLAG_IMMUTABLE
        );
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(messagebody)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0,notificationBuilder.build());
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel =new NotificationChannel(
                    CHANNEL_ID,
                    "Channel for Daily Notifications",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            NotificationManager manager=getSystemService(NotificationManager.class);
            if (manager!=null) {
                manager.createNotificationChannel(channel);
            }
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
    }
}

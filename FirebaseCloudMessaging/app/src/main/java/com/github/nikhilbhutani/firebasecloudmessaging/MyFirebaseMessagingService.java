package com.github.nikhilbhutani.firebasecloudmessaging;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by Nikhil Bhutani on 10/13/2016.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String LOG_TAG = "MyFirebaseMessagingService";


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(LOG_TAG, remoteMessage.getFrom());

        //Check if the message contains notification
        if(remoteMessage.getNotification() !=null){

            Log.d(LOG_TAG, "message_data: "+remoteMessage.getNotification().getBody());
              sendNotification(remoteMessage.getNotification().getBody());
        }



     }

    private void sendNotification(String body) {

        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                                    .setSmallIcon(R.mipmap.ic_launcher)
                                    .setContentTitle("FireBase Cloud Messaging")
                                    .setContentText(body)
                                    .setPriority(1)
                                    .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                                    .setContentIntent(pendingIntent);
        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, builder.build());
    }


}

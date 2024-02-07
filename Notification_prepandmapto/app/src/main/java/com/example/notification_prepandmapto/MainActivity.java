package com.example.notification_prepandmapto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final  String Channel_id = "MyChannel";
    private static final  int Notification_id = 101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Drawable drawable  = ResourcesCompat.getDrawable(getResources(),R.drawable.cion,null);

        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Notification notification;

        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O){

            notificationManager.createNotificationChannel(new NotificationChannel(Channel_id,"NEW CHANNEL",NotificationManager.IMPORTANCE_HIGH));

            notification = new Notification.Builder(MainActivity.this,Channel_id)
                    .setLargeIcon(bitmapDrawable.getBitmap())
                    .setSmallIcon(R.drawable.cion)
                    .setContentTitle("Set up your google account")
                    .setSubText("click here")
                    .setChannelId(Channel_id)
                    .build();


        }else{
             notification = new Notification.Builder(MainActivity.this)
                    .setLargeIcon(bitmapDrawable.getBitmap())
                    .setSmallIcon(R.drawable.cion)
                    .setContentTitle("Set up your google account")
                    .setSubText("click here")
                    .build();
        }

        notificationManager.notify(Notification_id,notification);
    }
}
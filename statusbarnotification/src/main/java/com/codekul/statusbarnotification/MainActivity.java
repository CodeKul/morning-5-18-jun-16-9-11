package com.codekul.statusbarnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnNotify).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showNotification();
            }
        });
    }

    private void showNotification(){

        NotificationManager manager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);

        Intent intent =
                new Intent(this,NewActivity.class);

        PendingIntent contentIntent =
                PendingIntent.getActivity(this,
                        1234,
                        intent,
                        PendingIntent.FLAG_CANCEL_CURRENT);

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                .setTicker("Ticker")
                .setContentText("Content Text")
                .setContentTitle("Content Title")
                .setContentInfo("Content Info")
                        .setDefaults(Notification.DEFAULT_ALL)

                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(contentIntent)
                .addAction(R.mipmap.ic_launcher,"Android",contentIntent);

        Notification notification = builder.build();
        notification.flags = Notification.FLAG_ONLY_ALERT_ONCE | Notification.FLAG_AUTO_CANCEL;
        //notification.vibrate = new long[];
        //notification.sound = Uri.parse("");
        manager.notify(7854,notification);
    }
}

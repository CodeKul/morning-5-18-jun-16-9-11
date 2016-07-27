package com.melayer.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mt("onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        mt("onStartCommand");
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mt("onDestroy");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void mt(String msg){
        Toast.makeText(MyService.this, msg, Toast.LENGTH_SHORT).show();
    }
}

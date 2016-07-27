package com.melayer.services;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {
    private static final String ACTION_MUSIC = "com.codekul.services.action.MUSIC";

    public MyIntentService() {

        super("MyIntentService");

        setIntentRedelivery(true);
    }


    public static void startActionMusic(Context context) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_MUSIC);
        context.startService(intent);
    }


    @Override
    protected void onHandleIntent(Intent intent) {
       // Toast.makeText(MyIntentService.this, "OnHandleIntent", Toast.LENGTH_SHORT).show();

        //if (intent != null) {
            //final String action = intent.getAction();
            //if (ACTION_MUSIC.equals(action)) {
                handleActionMusic();
            //}
        //}
    }
    private void handleActionMusic() {

        MediaPlayer player =
                new MediaPlayer();

        File mp3File =
                new File(Environment
                        .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),"My.mp3");

        try {
            player.setDataSource(mp3File.getPath());

            player.prepare();
            player.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

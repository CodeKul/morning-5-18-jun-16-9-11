package com.codekul.intentandintentfilters;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                any();
            }
        });
    }

    private void setup() {
        Intent intent =
                new Intent();
        intent.setAction("com.codekul.action.next");
        intent.setData(Uri.parse("http://codekul.com"));

        startActivity(intent);
    }

    private void dial() {

        Intent intent =
                new Intent(Intent.ACTION_DIAL);
        startActivity(intent);
    }

    private void call() {
        Intent intent =
                new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel://9762548833"));
        if (ActivityCompat
                .checkSelfPermission(this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {


            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    1234);
        }
        else {
            startActivity(intent);
        }
    }

    private void any(){

        Intent intent =
                new Intent(Intent.ACTION_VIEW);
        //intent.setDataAndType(Uri.fromFile(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC),"a.mp3")),"audio/*");
        intent.setData(Uri.parse("http://codekul.com"));
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == 1234){

            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                call();
            }
        }
    }
}

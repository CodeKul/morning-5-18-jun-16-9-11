package com.codekul.telephony;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.CellInfo;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "@codekul";
    private static final int SMS_SENT = 100;
    private static final int SMS_DELIVERED = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter filter = new IntentFilter();
        filter.addAction("com.codekul.msg.sent");
        filter.addAction("com.codekul.msg.delivered");

        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(context,intent.getAction(),Toast.LENGTH_LONG).show();
            }
        },filter);

        final TelephonyManager manager =
                (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        findViewById(R.id.btnInfo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String imei = manager.getDeviceId();
                Log.i(TAG,"Imei = "+imei);
                String simOperator = manager.getSimOperator();
                Log.i(TAG,"Operator = "+simOperator);
                String name = manager.getSimOperatorName();
                Log.i(TAG,"Name - "+name);

                if (android.os.Build.VERSION.SDK_INT >=
                        android.os.Build.VERSION_CODES.JELLY_BEAN_MR1) {
                    List<CellInfo> cellInfos =
                            manager.getAllCellInfo();
                    for(CellInfo info : cellInfos){
                    }
                }
            }
        });

        findViewById(R.id.btnSms).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SmsManager manager = SmsManager.getDefault();
                
                manager.sendTextMessage("9175760002",null,"{code}kul;", 
                        PendingIntent.getBroadcast(MainActivity.this,SMS_SENT,new Intent("com.codekul.msg.sent"),PendingIntent.FLAG_ONE_SHOT),
                        PendingIntent.getBroadcast(MainActivity.this,SMS_DELIVERED,new Intent("com.codekul.msg.delivered"),PendingIntent.FLAG_ONE_SHOT));

            }
        });
    }
}

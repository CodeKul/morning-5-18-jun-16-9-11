package com.codekul.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_ENABLE_BT = 150;

    private BroadcastReceiver receiver =
            new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {

                    BluetoothDevice device =
                            intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

                    Log.i("@codekul","Name - "+device.getName()+" Add - "+device.getAddress());

                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();

        findViewById(R.id.btnDiscover).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.startDiscovery();
            }
        });

        BluetoothManager manager = (BluetoothManager)
                getSystemService(BLUETOOTH_SERVICE);

        IntentFilter filter =
                new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(receiver,filter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_ENABLE_BT){
            if(resultCode == RESULT_OK){
                Log.i("@codekul","Bluetooth Enabled");
            }
        }
    }

    private void findPairedDevices(BluetoothAdapter adapter){
        if(adapter != null) {

            if (adapter.isEnabled()) {

                Set<BluetoothDevice> bondedDevices = adapter.getBondedDevices();

                for (BluetoothDevice bondedDevice : bondedDevices) {

                    Log.i("@codekul", "Name" + bondedDevice.getName());
                    Log.i("@codekul", "Address" + bondedDevice.getAddress());
                }
            }
            else{
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
            }
        }
        else {
            Log.i("@codekul","Your device does not support BT");
        }
    }

    private void findRemoteDevices(BluetoothAdapter adapter){


    }
}

package com.melayer.locationservices;

import android.Manifest;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_LOCATION = 1542;
    private static final int PENDING_PROXIMITY = 4568;

    private BroadcastReceiver proximity =
            new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {

                    if(intent.getBooleanExtra(LocationManager.KEY_PROXIMITY_ENTERING,false)){
                        Log.i("@codekul","Entering pune");
                    }
                    else {
                        Log.i("@codekul","Exiting pune");
                    }
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerReceiver(proximity, new IntentFilter("com.codekul.proximity.pune"));
        final LocationManager manager =
                (LocationManager) getSystemService(LOCATION_SERVICE);

        locationListener(manager);

        findViewById(R.id.btnOkay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Geocoder coder =
                        new Geocoder(MainActivity.this);
                try {
                    List<Address> addresses =
                            //coder.getFromLocationName(getAnything(),5);
                            coder.getFromLocation(18.5204, 73.8567, 5);

                    for (Address address : addresses) {
                        assignAnything("\n Lat - " + address.getLatitude());
                        assignAnything("\n Lng - " + address.getLongitude());
                        assignAnything("\n CC - " + address.getCountryCode());
                        assignAnything("\n CN - " + address.getCountryName());
                        assignAnything("\n PC - " + address.getPostalCode());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private String getAnything() {
        return ((EditText) findViewById(R.id.edtAnything)).getText().toString();
    }

    private void assignAnything(String anything) {

        ((TextView) findViewById(R.id.textAddress))
                .append(anything);
    }

    private void locationListener(LocationManager manager) {

        List<String> providers = manager.getAllProviders();
        for (String provider : providers) {
            assignAnything("\n" + provider);
        }

        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION},
                    PERMISSION_LOCATION);
        }
        else {
            Criteria criteria =
                    new Criteria();
            criteria.setPowerRequirement(Criteria.POWER_LOW);
            criteria.setSpeedRequired(true);
            criteria.setAltitudeRequired(true);
            criteria.setCostAllowed(true);

            manager.requestLocationUpdates(manager.getBestProvider(criteria,false), 1000, 1, new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {

                    assignAnything("Lat - "+location.getLatitude()+"\n Lng - "+location.getLongitude());
                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {

                }

                @Override
                public void onProviderEnabled(String provider) {

                }

                @Override
                public void onProviderDisabled(String provider) {

                }
            });

            manager.addProximityAlert(18.5204,73.8567,50,-1,
                    PendingIntent.getBroadcast(this,PENDING_PROXIMITY,new Intent("com.codekul.proximity.pune"),PendingIntent.FLAG_UPDATE_CURRENT));
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == PERMISSION_LOCATION){

            if(grantResults.length > 0){

                if(grantResults[0] ==  PackageManager.PERMISSION_GRANTED && grantResults[1] ==  PackageManager.PERMISSION_GRANTED){

                }
            }
        }
    }
}

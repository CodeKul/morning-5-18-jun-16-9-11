package com.codekul.sensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SensorManager manager =
                (SensorManager) getSystemService(SENSOR_SERVICE);

        List<Sensor> sensors =
                manager.getSensorList(Sensor.TYPE_ALL);

        for (Sensor sensor : sensors) {
            Log.i("@codekul","Name - "+sensor.getName());
        }

        proximity(manager);
    }

    private void light(SensorManager manager){

        Sensor sensor =
                manager.getDefaultSensor(Sensor.TYPE_LIGHT);
        manager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {

                float []arr = event.values;
                ((TextView)findViewById(R.id.textInfo)).setText(""+arr[0]);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        },sensor,SensorManager.SENSOR_DELAY_UI);

    }

    private void proximity(SensorManager manager){

        Sensor sensor =
                manager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        manager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                ((TextView)findViewById(R.id.textInfo)).setText(""+event.values[0]);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        },sensor,SensorManager.SENSOR_DELAY_UI);
    }
}

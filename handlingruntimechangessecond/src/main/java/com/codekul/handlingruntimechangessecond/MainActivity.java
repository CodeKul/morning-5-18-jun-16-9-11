package com.codekul.handlingruntimechangessecond;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        TextView textInfo = (TextView) findViewById(R.id.textInfo);
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            textInfo.setBackgroundResource(R.drawable.my);
        }
        else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            textInfo.setBackgroundResource(R.drawable.circle);
        }
        else{
            textInfo.setBackgroundResource(R.drawable.analytics);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Toast.makeText(this,"onRestart'",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast.makeText(this,"onDestroy",Toast.LENGTH_SHORT).show();
    }
}

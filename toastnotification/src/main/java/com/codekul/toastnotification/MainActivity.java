package com.codekul.toastnotification;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        runFragmentTxn(R.id.frameFragment,MainFragment
                .getInstance());
    }

    public void runFragmentTxn(Integer id, Fragment fragment){

        getSupportFragmentManager()
                .beginTransaction()
                .replace(id,fragment)
                .commit();
    }
}

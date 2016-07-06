package com.codekul.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        runFragmentTransaction(R.id.frameContainer,new LoginFragment());
    }

    private void runFragmentTransaction(int id, Fragment fragment){

        FragmentManager manger = getSupportFragmentManager();
        FragmentTransaction txn = manger.beginTransaction();
        txn.add(id,fragment);
        txn.commit();
    }
}

package com.codekul.dialogs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnAlert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(MyDialog.TAG_ALERT_DIALOG);
            }
        });

        findViewById(R.id.btnDatePicker).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialog(MyDialog.TAG_DATE_PICKER);
            }
        });

        findViewById(R.id.btnTimePicker).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialog(MyDialog.TAG_TIME_PICKER);
            }
        });
    }

    private void showDialog(String tag){

        MyDialog dialog =
                new MyDialog();
        dialog.show(getSupportFragmentManager(),tag);
    }
}

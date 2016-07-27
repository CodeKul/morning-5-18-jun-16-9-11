package com.melayer.asynctask;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnStart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new MyTask().execute(/*Params*/);
            }
        });
    }

    private void firstTest(){

        final TextView textView =
                (TextView) findViewById(R.id.textCounter);

        for(int i = 0 ; i <20 ;i++){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            textView.setText(""+i);
        }
    }

    private void secondTest(){
        new Thread(new Runnable() {
            @Override
            public void run() {

                final TextView textView =
                        (TextView) findViewById(R.id.textCounter);

                for(int i = 0 ; i <20 ;i++){
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    textView.setText(""+i);// this is problem
                }
            }
        }).start();
    }

    private class MyTask extends AsyncTask</*Params*/String,/*Progress*/ Integer, /*Result*/Integer>{

        private ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(MainActivity.this,"Title","Message");

            // main thread
        }

        @Override
        protected Integer/*Result*/ doInBackground(String... params/*Params*/) {
            // worker thread

            for(int i = 0 ; i <20 ;i++){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(i /*Progress*/);
            }

            return null;
        }

        @Override
        protected void onPostExecute(Integer integer/*Result*/) {
            super.onPostExecute(integer);

            // main thread

            progressDialog.dismiss();
        }

        @Override
        protected void onProgressUpdate(Integer... values/*Progress*/) {
            super.onProgressUpdate(values);

            // main thread
            final TextView textView =
                    (TextView) findViewById(R.id.textCounter);

            textView.setText(""+values[0]);
        }
    }
}

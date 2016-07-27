package com.melayer.esp8266;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnSendA).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //new ComTask().execute("a");

                try {
                    sendUsingTcp("a");
                } catch (Exception e) {
                    e.printStackTrace();
                }

                //sendUsingVolley("http://192.168.150.9:555/key=b&time="+System.currentTimeMillis());
            }
        });

        findViewById(R.id.btnSendB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //new ComTask().execute("b");

                try {
                    sendUsingTcp("b");
                } catch (Exception e) {
                    e.printStackTrace();
                }

                //sendUsingVolley("http://192.168.150.9:555/key=a&time="+System.currentTimeMillis());
            }
        });
    }

    private void sendUsingVolley(String url){

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(request);
    }



    private void sendUsingTcp(final String msg) throws Exception{
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    Socket socket = new Socket("192.168.150.9",555);
                    socket.getOutputStream().write(msg.getBytes());
                    socket.getOutputStream().close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

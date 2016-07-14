package com.codekul.assestsandresources;

import android.content.res.AssetManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String []countries = getResources()
                .getStringArray(R.array.conutries);

        int pureWhite = getResources()
                .getColor(R.color.pureWhite);


        pureWhite = ContextCompat
                .getColor(this,R.color.pureWhite);

        AssetManager manager = getAssets();
        StringBuilder builder =
                new StringBuilder();
        try {
            InputStream is = manager.open("index.html");



            while(true){
                int ch = is.read();
                if(ch == -1) break;
                else builder.append((char)ch);
            }

            Log.i("@codekul",builder.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

        final WebView webView = (WebView) findViewById(R.id.webView);
        webView.loadData(builder.toString(),"text/html","UTF-8");
    }
}

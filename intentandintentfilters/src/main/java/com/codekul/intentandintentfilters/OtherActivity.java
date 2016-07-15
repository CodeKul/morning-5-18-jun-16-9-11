package com.codekul.intentandintentfilters;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        Intent responsibleIntent =
                getIntent();
        Uri uri = responsibleIntent.getData();

        WebView webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl(uri.toString());
    }
}

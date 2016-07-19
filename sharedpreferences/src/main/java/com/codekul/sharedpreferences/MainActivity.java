package com.codekul.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnWrite).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences =
                        getSharedPreferences("my",MODE_PRIVATE);

//                preferences =
//                        getPreferences(MODE_PRIVATE);

                SharedPreferences.Editor editor =
                        preferences.edit();
                editor.putFloat("KEY_FLOAT",45.6f);
                editor.putBoolean("KEY_BOOL",true);
                editor.putString("KEY_STRING","{code}kul;");

                editor.commit();

            }
        });

        findViewById(R.id.btnRead).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences prefs =
                        getSharedPreferences("my",MODE_PRIVATE);
                String str = prefs.getString("KEY_STRING","default");
                Boolean bool = prefs.getBoolean("KEY_BOOL",true);
                Float flt = prefs.getFloat("KEY_FLOAT",45.2f);

                Log.i("@codekul","String - "+str +" Boolean - "+bool+" Float - "+flt);
            }
        });
    }
}

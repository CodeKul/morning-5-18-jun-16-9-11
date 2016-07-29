package com.melayer.jsonparsing;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AssetManager manager =
                getAssets();
        try {
            InputStream is = manager.open("my.json");
            StringBuilder builder =
                    new StringBuilder();
            while(true){

                int ch = is.read();
                if(ch == -1) break;
                else builder.append((char)ch);
            }

            JSONObject jsonObject
                    = new JSONObject(builder.toString());
            String name =  jsonObject.getString("name");
            String course = jsonObject.getString("course");
            Integer age = jsonObject.getInt("age");

            Log.i("@codekul","Age - "+age);
            Log.i("@codekul","Course - "+course);
            Log.i("@codekul","Name - "+name);

            JSONArray array = jsonObject.getJSONArray("array");
            for(int i = 0; i < array.length() ;i++){

                String str = array.getString(i);
                Log.i("@codekul","Arr - "+str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

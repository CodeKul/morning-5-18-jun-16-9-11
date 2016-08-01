package com.melayer.webservices;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RequestQueue queue =
                Volley.newRequestQueue(this);



        findViewById(R.id.btnOkay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*final ProgressDialog pd =
                        ProgressDialog.show(MainActivity.this,"Geo Names","Fetching Geo Names");

                JsonObjectRequest request
                        = new JsonObjectRequest(
                        "http://services.groupkt.com/state/get/IND/all",
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Log.i("@codekul",response.toString());
                                pd.dismiss();
                                parseJson(response);
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pd.dismiss();
                    }
                });

                queue.add(request);*/

                postData(queue);
            }
        });
    }

    private void parseJson(JSONObject response){

        ArrayList<String> dataSet = new ArrayList<>();

        try {

            JSONObject object = response.getJSONObject("RestResponse");
            JSONArray array = object.getJSONArray("result");

            for (int i = 0; i < array.length(); i++) {

                JSONObject obj = array.getJSONObject(i);
                String country = obj.getString("country");
                String area = obj.getString("area");

                dataSet.add(country +"\n "+area);
                ArrayAdapter<String> adapter =
                        new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dataSet);

                ((ListView)findViewById(R.id.listGeoNames)).setAdapter(adapter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void postData(RequestQueue queue){

        try {

            JSONObject obj = new JSONObject();
            obj.put("userName","android");
            obj.put("password","android");

            JsonObjectRequest request =
                    new JsonObjectRequest(Request.Method.POST, "http://192.168.0.28:8080/user", obj, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Log.i("@codekul",response.toString());
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.i("@codekul",error.toString());
                        }
                    });

            queue.add(request);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

package com.codekul.adapterviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        useMyAdapter();
    }

    private void initListView(){

        ArrayList<String> dataSet =
                new ArrayList<>();
        dataSet.add("India");
        dataSet.add("China");
        dataSet.add("Japan");
        dataSet.add("Shri Lanka");
        dataSet.add("Nepal");

//        final ListView listCountries =
//                (ListView) findViewById(R.id.listCountries);

        final GridView listCountries =
                (GridView) findViewById(R.id.listCountries);

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1,
                        dataSet);

        listCountries.setAdapter(adapter);

    }

    private void useMyAdapter() {

        ArrayList<MyItem> dataSet =
                new ArrayList<>();

        MyItem item1 =
                new MyItem(R.mipmap.ic_launcher,"Android");
        dataSet.add(item1);

        MyItem item2 =
                new MyItem(R.mipmap.ic_launcher,"IOS");
        dataSet.add(item2);

        MyItem item3 =
                new MyItem(R.mipmap.ic_launcher,"Windows");
        dataSet.add(item3);

        MyItem item4 =
                new MyItem(R.mipmap.ic_launcher,"Black Berry");
        dataSet.add(item4);


//        final ListView listCountries =
//                (ListView) findViewById(R.id.listCountries);

        final GridView listCountries =
                (GridView) findViewById(R.id.listCountries);

        MyAdapter adapter =
                new MyAdapter(this,dataSet);
        listCountries.setAdapter(adapter);
    }
}

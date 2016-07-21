package com.melayer.contactapp;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readMyProvider();

    }

    private void readContact(){

        Uri uri =  ContactsContract
                .CommonDataKinds
                .Phone
                .CONTENT_URI;

        String[] projection = {ContactsContract
                .CommonDataKinds
                .Phone.DISPLAY_NAME,

                ContactsContract
                        .CommonDataKinds
                        .Phone.NUMBER};

        String selection = null;
        String[] selectionArgs = null;
        String sortOrder = null;

        ContentResolver resolver =
                getContentResolver();

        Cursor cursor = resolver.query(uri,
                projection,
                selection,
                selectionArgs,
                sortOrder);

        ArrayList<String> dataSet =
                new ArrayList<>();

        while(cursor.moveToNext()){

            String displayName =
                    cursor.getString(cursor.getColumnIndex(ContactsContract
                            .CommonDataKinds
                            .Phone.DISPLAY_NAME));

            String number = cursor.getString(cursor.getColumnIndex(ContactsContract
                    .CommonDataKinds
                    .Phone.NUMBER));

            dataSet.add(displayName +"\n"+number);
        }

        cursor.close();

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dataSet);

        ListView listView =
                (ListView) findViewById(R.id.listContact);
        listView.setAdapter(adapter);
    }

    private void readMyProvider(){

        ContentResolver resolver =
                getContentResolver();

        Cursor cursor = resolver
                .query(Uri.parse("content://com.codekul.provider.db"),
                        null,
                        null,
                        null,
                        null);

        ArrayList<String> dataSet = new ArrayList<>();
        while(cursor.moveToNext()){

            String os = cursor.getString(cursor.getColumnIndex("os"));
            int version = cursor.getInt(cursor.getColumnIndex("version"));

            dataSet.add(os +"\n"+version);
        }
        cursor.close();

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dataSet);

        ListView listView = (ListView) findViewById(R.id.listContact);
        listView.setAdapter(adapter);
    }
}

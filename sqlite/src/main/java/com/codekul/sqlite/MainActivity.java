package com.codekul.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DbHelper helper = new DbHelper(this,"mobdb",null,1);

        findViewById(R.id.btnInsert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertMobile(helper,"android",6);
            }
        });

        findViewById(R.id.btnDisplay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayAll(helper);
            }
        });

        findViewById(R.id.btnUpdate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update(helper);
            }
        });

        findViewById(R.id.btnDelete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete(helper);
            }
        });
    }

    private void insertMobile(DbHelper helper,String os, int version){

        SQLiteDatabase sqDb = helper.getWritableDatabase();

        for(int i = 0; i < 10 ; i++) {
            ContentValues values = new ContentValues();
            values.put("os", ""+os + i);
            values.put("version", ""+ version + i );

            sqDb.insert("mobileTab", null, values);
        }

        sqDb.close();
    }

    private void displayAll(DbHelper helper) {

        SQLiteDatabase sqDb = helper.getReadableDatabase();
        String table = "mobileTab";
        String[] columns = {"version"};
        String selection = "os = ? and version = ?";
        String[] selectionArgs = {"android0","60"};
        String groupBy = null;
        String having = null;
        String orderBy = null;

        Cursor cursor = sqDb.query(table,
                columns,
                selection,
                selectionArgs,
                groupBy,
                having,
                orderBy);

        while(cursor.moveToNext()){

//            /String os = cursor.getString(cursor.getColumnIndex("os"));
            int version = cursor.getInt(cursor.getColumnIndex("version"));

            //Log.i("@codekul"," OS - "+os);
            Log.i("@codekul"," VErsion - "+version);
        }

        sqDb.close();
    }

    private void update(DbHelper helper){

        SQLiteDatabase sqDb = helper.getWritableDatabase();

        String table = "mobileDb";

        ContentValues values = new ContentValues();
        values.put("os","marshmellow");

        String whereClause = "version = ?";
        String[] whereArgs = {"60"};

        sqDb.update(table,values,whereClause,whereArgs);

        sqDb.close();
    }

    private void delete(DbHelper helper){

        SQLiteDatabase sqDb = helper.getWritableDatabase();

        String table = "mobileDb";
        String whereCluase = "version = ?";
        String []whereArgs = {"61"};

        sqDb.delete(table,whereCluase,whereArgs);

        sqDb.close();
    }
}

package com.melayer.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        registerForContextMenu(findViewById(R.id.textView));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        if(checkBox.isChecked()){
            menu.removeItem(R.id.action_delete);
        }

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        if(id == R.id.action_copy){

        }
        if(id == R.id.action_delete){

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(200,100,1,"Cut");
        menu.add(200,101,2,"Copy");
        menu.add(200,102,3,"Paste");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if(item.getItemId() == 100){

            Toast.makeText(MainActivity.this, "Cut", Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId() == 101){

            Toast.makeText(MainActivity.this, "Copy", Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId() == 102){

            Toast.makeText(MainActivity.this, "Paste", Toast.LENGTH_SHORT).show();
        }
        return true;
    }


}

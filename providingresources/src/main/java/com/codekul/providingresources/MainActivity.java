package com.codekul.providingresources;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*if(savedInstanceState != null){

            TextView text =
                    (TextView) findViewById(R.id.textInfo);

            text.setText(""+savedInstanceState.getString("key_my_data"));
        }*/
        getWindow()
                .setBackgroundDrawableResource(R.drawable.my);

        findViewById(R.id.btnOkay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView text =
                        (TextView) findViewById(R.id.textInfo);

                text.setText(""+Math.random());
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"onDestroy",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        TextView text =
                (TextView) findViewById(R.id.textInfo);
        outState.putString("key_my_data",text.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if(savedInstanceState != null){

            TextView text =
                    (TextView) findViewById(R.id.textInfo);

            text.setText(""+savedInstanceState.getString("key_my_data"));
        }
    }
}

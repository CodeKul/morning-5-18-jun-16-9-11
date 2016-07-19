package com.codekul.filehandling;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // /data/data/package-name/files/private-app-files

        findViewById(R.id.btnWrite).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExternalSharedStorage();
            }
        });

        findViewById(R.id.btnRead).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        findViewById(R.id.btnInfo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void writeToInternalStorage() {

        try {

            FileOutputStream fos =
                    openFileOutput("my.txt",MODE_APPEND);
            fos.write("Hello World".getBytes());
            fos.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void readInternalStorage(){
        try {

            FileInputStream fis =
                    openFileInput("my.txt");
            StringBuilder builder = new StringBuilder();
            while(true){
                int ch = fis.read();
                if(ch == -1) break;
                else builder.append((char)ch);
            }

            ((TextView)findViewById(R.id.textFileData))
                    .setText(builder.toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void showInternalInfo(){

        TextView textInfo = (TextView) findViewById(R.id.textFileData);
        textInfo.append("getFilesDir() - "+getFilesDir().getPath());
    }

    private void writeExternalSharedStorage(){

        try {
            if(isMounted()){

                File file = new File(Environment
                        .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "muy.txt");

                FileOutputStream fos = new FileOutputStream(file);
                fos.write("Hello External".getBytes());
                fos.close();
            }
            else{
                ((TextView)findViewById(R.id.textFileData))
                        .setText("Media not mounted");
            }
        }
        catch (Exception e){
          e.printStackTrace();
        }
    }

    private Boolean isMounted(){

        return Environment
                .getExternalStorageState()
                .equals(Environment.MEDIA_MOUNTED);
    }

    private void createNewFolder(){

        if(isMounted()) {
            File file = new File(Environment
                    .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "{code}kul;");
            file.mkdir();
        }
    }
}

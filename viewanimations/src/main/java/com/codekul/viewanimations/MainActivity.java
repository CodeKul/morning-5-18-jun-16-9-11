package com.codekul.viewanimations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnMixed).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                performAnimation(R.anim.mixed_anim);
            }
        });

        findViewById(R.id.btnFade).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                performAnimation(R.anim.fade);
            }
        });

        findViewById(R.id.btnScale).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                performAnimation(R.anim.sacle);
            }
        });

        findViewById(R.id.btnRotate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performAnimation(R.anim.rotate);
            }
        });
    }

    private void performAnimation(int which){

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        Animation animation = AnimationUtils.loadAnimation(this,which);
        imageView.startAnimation(animation);
    }
}

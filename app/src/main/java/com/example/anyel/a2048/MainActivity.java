package com.example.anyel.a2048;

import java.util.Timer;
import java.util.TimerTask;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ViewSwitcher.ViewFactory;


public class MainActivity extends AppCompatActivity{


    private int[] gallery = { R.drawable.f00, R.drawable.f01,R.drawable.f02,R.drawable.f03,R.drawable.f04,
            R.drawable.f05,R.drawable.f06,R.drawable.f07,R.drawable.f08,R.drawable.f09,R.drawable.f010,R.drawable.f011,
            R.drawable.f012,R.drawable.f013,R.drawable.f014,R.drawable.f015,R.drawable.f016,R.drawable.f017,R.drawable.f018,
            R.drawable.f019,R.drawable.f020,R.drawable.f021,R.drawable.f022,R.drawable.f023};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("SALUDO: ","Hola Humano");
        goRegisterGamer();
    }

    protected void goRegisterGamer() {
        ImageView logo2048 = (ImageView) findViewById(R.id.logo_2048);
        logo2048.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RegisterGamer.class);

                ImageView logoId = (ImageView)findViewById(R.id.logo_2048);
                int ret = 100;
                Drawable drawable;
                    for (int k = 0; k < ret; k++) {
                    }
                    drawable = getResources().getDrawable(gallery[0]);
                    logoId.setImageDrawable(drawable);

                    for (int k = 0; k < ret; k++) {
                    }
                    drawable = getResources().getDrawable(gallery[1]);
                    logoId.setImageDrawable(drawable);

                    for (int k = 0; k < ret; k++) {
                    }
                    drawable = getResources().getDrawable(gallery[2]);
                    logoId.setImageDrawable(drawable);


                    for (int k = 0; k < ret; k++) {
                    }
                    drawable = getResources().getDrawable(gallery[3]);
                    logoId.setImageDrawable(drawable);

                    for (int k = 0; k < ret; k++) {
                    }
                    drawable = getResources().getDrawable(gallery[4]);
                    logoId.setImageDrawable(drawable);

                    for (int k = 0; k < ret; k++) {
                    }

                    drawable = getResources().getDrawable(gallery[5]);
                    logoId.setImageDrawable(drawable);

                    for (int k = 0; k < ret; k++) {
                    }

                    drawable = getResources().getDrawable(gallery[6]);
                    logoId.setImageDrawable(drawable);

                    for (int k = 0; k < ret; k++) {
                    }

                    drawable = getResources().getDrawable(gallery[7]);
                    logoId.setImageDrawable(drawable);

                    for (int k = 0; k < ret; k++) {
                    }

                    drawable = getResources().getDrawable(gallery[8]);
                    logoId.setImageDrawable(drawable);

                    for (int k = 0; k < ret; k++) {
                    }

                    drawable = getResources().getDrawable(gallery[9]);
                    logoId.setImageDrawable(drawable);
                    for (int k = 0; k < ret; k++) {
                    }
                    drawable = getResources().getDrawable(gallery[10]);
                    logoId.setImageDrawable(drawable);

                    for (int k = 0; k < ret; k++) {
                    }
                    drawable = getResources().getDrawable(gallery[11]);
                    logoId.setImageDrawable(drawable);

                    for (int k = 0; k < ret; k++) {
                    }
                    drawable = getResources().getDrawable(gallery[12]);
                    logoId.setImageDrawable(drawable);


                startActivity(i);
                finish();
            }
        });
    }


}

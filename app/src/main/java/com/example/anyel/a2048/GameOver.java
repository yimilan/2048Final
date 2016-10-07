package com.example.anyel.a2048;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.style.SuperscriptSpan;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class GameOver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        Bundle extras = getIntent().getExtras();
        captureBack();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        configureSubTitle();
        String name = extras.getString(getResources().getString(R.string.score));
        TextView scoreCont = (TextView)findViewById(R.id.ScoreGO);
        scoreCont.setText(name);


    }
    protected void configureSubTitle(){
        // Toast.makeText(getBaseContext(),getResources().getString(R.string.texto_prueba),Toast.LENGTH_SHORT).show();

        TypeFacePersonality typeFP = new TypeFacePersonality(this);

        TextView subtitleGame = (TextView)findViewById(R.id.GameOver);
        subtitleGame.setTypeface(typeFP.roboTitle);

        TextView scoreCont = (TextView)findViewById(R.id.ScoreGO);
        scoreCont.setTypeface(typeFP.dowlinkTitle);

        TextView scoreTtl = (TextView)findViewById(R.id.ScoreTitle);
        scoreTtl.setTypeface(typeFP.simkaiTitle);

    }
    public void captureBack() {
        ImageView Back = (ImageView) findViewById(R.id.atras);
        Back.setOnClickListener(new  View.OnClickListener(){
            // @Override
            public void onClick(View v) {
                Intent i = new Intent(GameOver.this, RegisterGamer.class);
                startActivity(i);
                finish();
            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == event.KEYCODE_BACK) {
            Intent i = new Intent(GameOver.this, RegisterGamer.class);
            startActivity(i);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

}

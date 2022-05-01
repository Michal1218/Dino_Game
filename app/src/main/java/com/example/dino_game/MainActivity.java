package com.example.dino_game;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    DisplayMetrics displayMetrics;
    @SuppressLint("StaticFieldLeak")
    public static TextView scoreText;
    public static MediaPlayer mediaPlayer;
    @SuppressLint("StaticFieldLeak")
    public static Button startButton;
    @SuppressLint("StaticFieldLeak")
    public static View view;

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayer.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        Screen.height = displayMetrics.heightPixels;
        Screen.width = displayMetrics.widthPixels;
        setContentView(R.layout.activity_main);
        scoreText = (TextView) findViewById(R.id.score);
        startButton = (Button) findViewById(R.id.startButton);
        view = (View) findViewById(R.id.gameView);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startButton.setVisibility(View.INVISIBLE);
                GameView.speed = 15;
                GameView.running = true;
            }
        });

        mediaPlayer = MediaPlayer.create(this, R.raw.picopark);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();


    }
}
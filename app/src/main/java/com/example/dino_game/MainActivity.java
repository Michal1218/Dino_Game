package com.example.dino_game;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    DisplayMetrics displayMetrics;
    @SuppressLint("StaticFieldLeak")
    public static TextView scoreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        Screen.height = displayMetrics.heightPixels;
        Screen.width = displayMetrics.widthPixels;
        setContentView(R.layout.activity_main);
    }
    }

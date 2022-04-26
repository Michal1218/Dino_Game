package com.example.dino_game;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class GameView extends View {

    Runnable runnable;
    Dino dino;
    Cactus cactus;

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        runnable = this::invalidate;
        dino = new Dino(100, Screen.height / 2, Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.dino), (int) 450, (int) 450, false));
        cactus = new Cactus(100, Screen.height - 340, Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.cactus), (int) 350, (int) 230, false));
    }

    public void draw(Canvas canvas) {
        new Handler().postDelayed(runnable, 1);
        super.draw(canvas);
        if (dino.getRect().intersect(cactus.getRect())) {
            Dino.collide = true;
            Cactus.speed = 15;
        } else {
            Dino.collide = false;
            Cactus.speed = 25;
        }
        dino.render(canvas);
        cactus.render(canvas);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (!Dino.isJumping) {
            dino.setScore(dino.getScore() + 1);
            MainActivity.scoreText.setText(String.valueOf("SCORE: " + dino.getScore()));
            dino.setGravity(-22);
        }
        return super.onTouchEvent(event);
    }
}

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

import java.util.ArrayList;

public class GameView extends View {

    Runnable runnable;
    Dino dino;
    Cactus cactus;
    ArrayList<Bitmap> dinos = new ArrayList<>();
    public int beforeSpeed = 5;
    public static int speed = 0;
    public static boolean running;

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        runnable = this::invalidate;
        dino = new Dino(100, Screen.height, Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.dino2), (int) 200 * Screen.width / 1920, (int) 250 * Screen.height / 1080, false));
        cactus = new Cactus(Screen.width, Screen.height, Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.cactus), (int) 100 * Screen.width / 1920, (int) 130 * Screen.width / 1920, false));
        cactus.setY(cactus.getY() - cactus.getHeight() - 160);
        dino.setY(dino.getY() - dino.getHeight() - 135);
        dinos.add(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.dino2), (int) 250 * Screen.width / 1920, (int) 200 * Screen.width / 1920, false));
        dinos.add(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.dino3), (int) 250 * Screen.width / 1920, (int) 200 * Screen.width / 1920, false));
        dinos.add(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.dino1), (int) 250 * Screen.width / 1920, (int) 200 * Screen.width / 1920, false));
        dino.setDinos(dinos);
        cactus.setSpeed(0);
    }

    public void draw(Canvas canvas) {
        new Handler().postDelayed(runnable, 1);
        super.draw(canvas);
        if (running) {
            cactus.setSpeed(speed);
            running = false;
        }
        if (dino.getX() >= cactus.getX() + cactus.getWidth() + 100) {
            dino.setScore(dino.getScore() + 1);
            MainActivity.scoreText.setText(String.valueOf("SCORE: " + dino.getScore()));
            Dino.collide = false;
        }
        if (dino.getRect().intersect(cactus.getRect())) {
            Dino.collide = true;
            restartGame();
        }
        if (dino.getScore() >= beforeSpeed) {
            Dino.collide = false;
            beforeSpeed += 5;
            cactus.setSpeed(cactus.getSpeed() + 3);
            System.out.println("Speed: " + cactus.getSpeed());
        }
        dino.render(canvas);
        cactus.render(canvas);
    }

    private void restartGame() {
        cactus.setX(Screen.width);
        dino.setScore(0);
        MainActivity.scoreText.setText(String.valueOf("SCORE: " + dino.getScore()));
        MainActivity.startButton.setVisibility(VISIBLE);
        MainActivity.startButton.setText("RESTART");
        cactus.setSpeed(0);
        beforeSpeed = 5;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (!dino.isJumping) {
            dino.setGravity(-20);
            dino.isJumping = true;
        }
        return super.onTouchEvent(event);
    }
}

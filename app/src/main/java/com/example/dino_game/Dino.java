package com.example.dino_game;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import java.util.ArrayList;

public class Dino {

    private float x;
    private float y;
    private float height;
    private float gravity, velocity;
    private int score, i;

    public static boolean collide = false;
    public boolean isJumping;
    public ArrayList<Bitmap> dinos = new ArrayList<>();

    public ArrayList<Bitmap> getDinos() {
        return dinos;
    }

    public void setDinos(ArrayList<Bitmap> dinos) {
        this.dinos = dinos;
    }

    private float width;
    private Bitmap bitmap;

    public Dino(float x, float y, Bitmap bitmap) {
        this.gravity = 0;
        this.velocity = 0f;
        this.x = x;
        this.y = y;
        this.bitmap = bitmap;
        this.height = bitmap.getHeight();
        this.width = bitmap.getWidth();
    }

    public void jump() {
        if (this.y + this.height > Screen.height - 135) {
            this.velocity = 0f;
            this.gravity = 0f;
            y = Screen.height - this.height - 135;
            isJumping = false;
        }
        if (isJumping) {
            this.velocity = 0.7f;
        }
        if (collide) {
            this.score = 0;
        }
        this.gravity = this.gravity + velocity;
        y = y + this.gravity + velocity;
    }

    public Bitmap animation() {
        i++;
        if (i >= 0 && i <= 5) {
            return dinos.get(0);
        }
        if (i < 14) {
            return dinos.get(2);
        }
        if (this.i > 24) {
            if (this.i == 34) {
                this.i = 0;
            }
            return dinos.get(1);
        }
        return dinos.get(0);
    }

    public float getGravity() {
        return gravity;
    }

    public void setGravity(float gravity) {
        this.gravity = gravity;
    }

    public float getVelocity() {
        return velocity;
    }

    public void setVelocity(float velocity) {
        this.velocity = velocity;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void render(Canvas canvas) {
        jump();
        canvas.drawBitmap(animation(), this.x, this.y, null);
    }

    public Rect getRect() {
        return new Rect(
                (int) this.x,
                (int) this.y,
                (int) this.x + (int) this.width,
                (int) this.y + (int) this.height
        );
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }


}

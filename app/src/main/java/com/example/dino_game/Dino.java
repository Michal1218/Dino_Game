package com.example.dino_game;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Dino {

    private float x;
    private float y;
    private float height;
    private float gravity, velocity;
    private int score;

    public static boolean collide = false;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static boolean isJumping = false;

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

    private float width;
    private Bitmap bitmap;

    public Dino(float x, float y, Bitmap bitmap) {
        this.gravity = 0;
        this.velocity = 0.6f;
        this.x = x;
        this.y = y;
        this.bitmap = bitmap;
        this.height = bitmap.getHeight();
        this.width = bitmap.getWidth();
    }

    public void jump() {
        if (this.y < 450) {
            isJumping = true;
        } else {
            isJumping = false;
        }
        if (this.y <= -300) {
            gravity = 2;
        } else if (this.y >= 500) {
            gravity = -2;
        }
        if (collide) {
            score = 0;
            MainActivity.scoreText.setText(String.valueOf("SCORE: " + score));
        }
        this.gravity = this.gravity + velocity;
        y = y + this.gravity;
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
        canvas.drawBitmap(this.bitmap, this.x, this.y, null);
    }

    public Rect getRect() {
        return new Rect(
                (int) this.x,
                (int) this.y,
                (int) this.x + (int) this.width,
                (int) this.y + (int) this.height
        );
    }

}

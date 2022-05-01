package com.example.dino_game;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Cactus {

    private int speed = 15;

    private float x, y, height, width;
    private Bitmap bitmap;

    public Cactus(float x, float y, Bitmap bitmap) {
        this.x = x;
        this.y = y;
        this.bitmap = bitmap;
        this.height = bitmap.getHeight();
        this.width = bitmap.getWidth();
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
        if (x + this.width < 0) {
            this.setX(Screen.width);
        }
        this.x = this.x - speed;
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
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

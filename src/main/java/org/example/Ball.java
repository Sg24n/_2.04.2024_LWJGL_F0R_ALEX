package org.example;

public class Ball {
    private float x, y;
    private  final float radius;
    private float velocityX, veloscityY;

    public Ball(float x, float y, float radius, float velocityX, float veloscityY){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.velocityX = velocityX;
        this.veloscityY = veloscityY;
    }
}

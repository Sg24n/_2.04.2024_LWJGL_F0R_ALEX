package org.example;
import static org.lwjgl.opengl.GL11.*;
public class Ball {
    private int width, height;
    private float r, g, b;

    public float x, y;
    public final float radius;
    public float velocityX, velocityY;

    public Ball(int width, int height, float x, float y, float radius, float velocityX, float velocityY, float r, float g, float b){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.r = r;
        this.g = g;
        this.b = b;
        this.width = width;
        this.height = height;
    }


    public void update(){
        y += velocityY;
        x += velocityX;
        //Проверка колизий x and y
        if (x<= 0 || x + radius * 2 >=width) {velocityX = -velocityX;}
        if (y <= 0 || y + radius * 2 >= height) {velocityY = -velocityY;}
        }
    public void render(){
        glColor3f(r,g,b);
        int segments = 40;
        glBegin(GL_POLYGON);
        for (int i = 0; i<segments; i++){
            //Тут математика какаято я не шарю просто переписал
            double theta = 2.0 * Math.PI * i / segments;
            double x = this.radius * Math.cos(theta);
            double y = this.radius * Math.sin(theta);
            glVertex2d(x + this.x, y + this.y);
        }
        glEnd();
    }


}

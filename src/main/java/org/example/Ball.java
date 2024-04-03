package org.example;
import static org.lwjgl.opengl.GL11.*;
public class Ball {
    private float r, g, b;

    private float x, y;
    private  final float radius;
    private float velocityX, veloscityY;

    public Ball(float x, float y, float radius, float velocityX, float veloscityY, float r, float g, float b){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.velocityX = velocityX;
        this.veloscityY = veloscityY;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public void render(){
        glColor3f(r,g,b);
        int segments = 7;
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

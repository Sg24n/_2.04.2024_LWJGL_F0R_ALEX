package org.example;

import org.lwjgl.assimp.AIVector2D;

import static org.lwjgl.opengl.GL11.*;

public class Ball {
    private int width, height;
    private float r, g, b;
    public Vector2D position, vVelocity;


    public float x, y;
    public final float radius;
    public float velocityX, velocityY;

    public Ball(int width, int height, float x, float y, float radius, float velocityX, float velocityY, float r, float g, float b) {

        this.position = new Vector2D(x, y);
        this.vVelocity = new Vector2D(velocityX, velocityY);

        this.radius = radius;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.r = r;
        this.g = g;
        this.b = b;
        this.width = width;
        this.height = height;
    }

    public void update(float deltaTime) {

        this.position = this.position.add(this.vVelocity.multiply(deltaTime));

        //Проверка колизий x and y
        if (position.x <= 0) {
            vVelocity.x = Math.abs(vVelocity.x);
            position.x = 1;
        } else if (position.x + radius * 2 >= width) {
            vVelocity.x = -Math.abs(velocityX);
            position.x = width - radius * 2 - 1;
        }

        if (position.y <= 0) {
            vVelocity.y = Math.abs(vVelocity.y);
            position.y = 1;
        } else if (position.y + radius * 2 >= height) {
            vVelocity.y = -Math.abs(vVelocity.y);
            position.y = height - radius * 2 - 1;
        }
    }

    public void render() {
        glColor3f(r, g, b);
        int segments = 40;
        glBegin(GL_POLYGON);
        for (int i = 0; i < segments; i++) {
            //Тут математика какаято я не шарю просто переписал
            double theta = 2.0 * Math.PI * i / segments;
            double x = this.radius * Math.cos(theta) + this.position.x;
            double y = this.radius * Math.sin(theta) + this.position.y;
            glVertex2d(x, y);
        }
        glEnd();
    }


}

package org.example;

import static org.lwjgl.opengl.GL11.*;

public class Ball implements BoundedObject {
    private int windowWidth, windowHeight;
    private float r, g, b;
    public Vector2D position, vVelocity;

    public final float radius;
    public float velocityX, velocityY;
    //На самом деле это ромб
    public Ball(int windowWidth, int windowHeight, float x, float y, float radius, float velocityX, float velocityY, float r, float g, float b) {

        this.position = new Vector2D(x, y);
        this.vVelocity = new Vector2D(velocityX, velocityY);

        this.radius = radius;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.r = r;
        this.g = g;
        this.b = b;
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
    }

    public void update(float deltaTime) {

        this.position = this.position.add(this.vVelocity.multiply(deltaTime));

        //Проверка колизий x and y
        if (position.x <= 0) {
            vVelocity.x = Math.abs(vVelocity.x);
            position.x = 1;
        } else if (position.x + radius * 2 >= windowWidth) {
            vVelocity.x = -Math.abs(velocityX);
            position.x = windowWidth - radius * 2 - 1;
        }

        if (position.y <= 0) {
            vVelocity.y = Math.abs(vVelocity.y);
            position.y = 1;
        } else if (position.y + radius * 2 >= windowHeight) {
            vVelocity.y = -Math.abs(vVelocity.y);
            position.y = windowHeight - radius * 2 - 1;
        }
    }

    public void render() {
        glColor3f(r, g, b);
        int segments = 4;
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

    @Override
    public float [][] getVertices(){
        float [][] positionObj = new float[4][2];
        positionObj[0][0] = position.x;
        positionObj[0][1]= position.y;

        positionObj[1][0]= position.x + windowWidth;
        positionObj[1][1]=position.y;

        positionObj[2][0]=position.y;
        positionObj[2][1]=position.x;

        positionObj[3][0]=position.x + windowWidth;
        positionObj[3][1]=position.y + windowHeight;

    return positionObj;
    }

}

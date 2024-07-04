package org.example;

import static org.lwjgl.opengl.GL11.*;

public class Ball  {
    public int windowWidth, windowHeight;
    private float r, g, b;

    public Vector2D position, vVelocity;

    public final float radius;
    //На самом деле это ромб
    public Ball(int windowWidth, int windowHeight, float x, float y, float radius, float velocityX, float velocityY, float r, float g, float b) {

        this.position = new Vector2D(x, y);
        this.vVelocity = new Vector2D(velocityX, velocityY);

        this.radius = radius;

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
            vVelocity.x = -Math.abs(vVelocity.x);
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


    int segments = 4;
    public void render() {
        glColor3f(r, g, b);
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

   // @Override
    public float [][] getVertices(){
        float [][] positionObj = new float[4][2];

        //Top
        positionObj[0][0] = position.x;
        positionObj[0][1]= position.y + radius;

        //Right
        positionObj[1][0]= position.x + radius;
        positionObj[1][1]=position.y;
        //Bottom
        positionObj[2][0]=position.x;
        positionObj[2][1]=position.y - radius;
        //Left
        positionObj[3][0]=position.x - radius;
        positionObj[3][1]=position.y;


    return positionObj;
    }


        public Point getTop(){
         Point point = new Point(position.x,position.y + radius);
         return point;
        }
        public Point getRight(){
            Point point = new Point(position.x + radius,position.y);
            return point;
        }
        public Point getBottom(){
            Point point = new Point(position.x,position.y - radius);
            return point;
        }
        public Point getLeft(){
            Point point = new Point(position.x - radius,position.y);
            return point;
        }


}

package org.example;
import static org.lwjgl.opengl.GL11.*;
public class Racket implements BoundedObject{
    private float r, g, b;

   // public float x, y;
    public final float width, height;
    private float velocityX = 0.0f;
    private float targetVelocityX = 0.0f; // Целевая скорость

    private final float speed = 400.0f;
    public Vector2D position;


    public Racket(float x, float y, float width, float height, float r, float g, float b) {

        this.position = new Vector2D(x, y);


        //  this.x = x;
        //this.y = y;
        this.width = width;
        this.height = height;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public void update(float deltaTime){

        // Плавное перемещение
        float acceleration = 100000f;
        if (velocityX < targetVelocityX) {
            velocityX = Math.min(velocityX + acceleration * deltaTime, targetVelocityX);
        } else if (velocityX > targetVelocityX) {
            velocityX = Math.max(velocityX - acceleration * deltaTime, targetVelocityX);
        }
        position.x += velocityX * deltaTime;

        //Проверка колизий x
        if (position.x<= 0.0f || position.x >=480){
            velocityX = 0.0f;
            System.out.println("R X collision. pos x = " + position.x);
        }
    }
    public void render() {
        glColor3f(r, g, b); // Установка цвета блока
        glBegin(GL_QUADS);
        glVertex2f(position.x, position.y);
        glVertex2f(position.x + width, position.y);
        glVertex2f(position.x + width, position.y + height);
        glVertex2f(position.x, position.y + height);
        glEnd();
    }

    public void moveLeft(){
        //velocityX = -speed;
        targetVelocityX = -speed;

    }
    public void moveRight(){
        //velocityX = speed;
        targetVelocityX = speed;
    }
    public void stop(){
        //velocityX= 0.0f;
        targetVelocityX = 0.0f;
    }


    @Override
    public float getLeft(){
        return position.x;
    }
    @Override
    public float getRight(){
        return position.x + width;
    }
    @Override
    public float getTop(){
        return position.y;
    }
    @Override
    public float getBottom(){
        return position.y + height;
    }

}

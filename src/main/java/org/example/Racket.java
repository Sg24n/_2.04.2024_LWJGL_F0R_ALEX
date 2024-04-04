package org.example;
import static org.lwjgl.opengl.GL11.*;
public class Racket {
    private float r, g, b;

    public float x, y;
    public final float width, height;
    private float velocityX = 0.0f;
    private final float speed = 18.0f;


    public Racket(float x, float y, float width, float height, float r, float g, float b) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public void update(){
        x += velocityX;
        //Проверка колизий x
        if (x<= 0 || x >=width){
            velocityX = 0.0f;
        }
    }
    public void render() {
        glColor3f(r, g, b); // Установка цвета блока
        glBegin(GL_QUADS);
        glVertex2f(x, y);
        glVertex2f(x + width, y);
        glVertex2f(x + width, y + height);
        glVertex2f(x, y + height);
        glEnd();
    }

    public void moveLeft(){
        velocityX = -speed;
    }
    public void moveRight(){
        velocityX = speed;
    }
    public void stop(){
        velocityX = 0.0f;
    }


}

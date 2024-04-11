package org.example;
import java.util.Iterator;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;


public class Block implements BoundedObject {
    public Vector2D position;

    public float x, y, width, height, health;
    private float r, g, b;

    public Block(float width, float height, float blockWidth, float blockHeight, float r, float g, float b, float health) {

        this.position = new Vector2D(width, height);

        this.width = blockWidth;
        this.height = blockHeight;
        this.r = r;
        this.g = g;
        this.b = b;
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
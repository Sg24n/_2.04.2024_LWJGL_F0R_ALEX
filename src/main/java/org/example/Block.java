package org.example;
import java.util.Iterator;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;
public class Block implements ObjInterface {
    public float x, y, width, height, health;
    private float r, g, b;

    public Block(float x, float y, float width, float height, float r, float g, float b, float health) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    @Override
    public void render() {
        glColor3f(r, g, b); // Установка цвета блока
        glBegin(GL_QUADS);
        glVertex2f(x, y);
        glVertex2f(x + width, y);
        glVertex2f(x + width, y + height);
        glVertex2f(x, y + height);
        glEnd();
    }

    @Override
    public void update() {


    }
}
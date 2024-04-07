package org.example;

public class Vector2D {
    public float x,y;

    //Конструктор
    public Vector2D(float x, float y){
        this.x = x;
        this.y = y;
    }
    public Vector2D add(Vector2D other){
        return new Vector2D(this.x + other.x, this.y + other.y);
    }

    public Vector2D reflect(Vector2D normal){
        float dotProduct = this.dot(normal);
        return new Vector2D(this.x - 2 *dotProduct * normal.x, this.y -2 * dotProduct * normal.y);
    }
    public float dot(Vector2D other){
        return this.x * other.x + this.y * other.y;
    }

    public Vector2D multiply(float scalar) {
        return new Vector2D(this.x * scalar, this.y * scalar);
    }

}

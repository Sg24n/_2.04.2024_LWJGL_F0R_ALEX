package org.example;

public class Point {
    private float x, y;
    float epsilon = 0.1f;

    public Point(float x,float y){
        this.x = x;
        this.y = y;
    }

    public boolean isEqual(Point other){
        return Math.abs(this.x - other.x) < epsilon && Math.abs(this.y - other.y) < epsilon;
    }
    public boolean isBetween(Point other1, Point other2){
        //На одном у И в диапазоне х. Или на одном х И в диапазоне у
        return this.x > other1.x && this.x < other2.x
                && Math.abs(this.y - other1.y) < epsilon && Math.abs(this.y - other2.y) < epsilon
                || this.y > other1.y && this.y < other2.y
                && Math.abs(this.x - other1.x) < epsilon && Math.abs(this.x - other2.x) < epsilon;
    }

    private boolean isInArea(Ball ball, BoundedObject object){
        if(ball.getTop().isBetween(object.getBL(), object.getBR())){System.out.println("Ball Top coll");return true;}
        if(ball.getRight().isBetween(object.getTL(),object.getBL())){System.out.println("Ball Right coll");return true;}
        if(ball.getBottom().isBetween(object.getTL(), object.getTR())){System.out.println("Ball Bottom coll");return true;}
        if (ball.getLeft().isBetween(object.getTR(), object.getBR())){System.out.println("Ball Left coll");return true;}
        return false;
    }
}

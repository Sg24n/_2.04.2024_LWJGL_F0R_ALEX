package org.example;

public class Point {
    private float x, y;
    float epsilon = 1f;
    private int width = 480;
   private int height = 480;
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

        //По диагонали
        /*return this.x > other1.x && this.x < other2.x
                && this.y > other1.y && this.y < other2.y;*/
                /*
                || this.y > other1.y && this.y < other2.y
                && Math.abs(this.x - other1.x) < epsilon && Math.abs(this.x - other2.x) < epsilon;*/
    }

    public boolean isBetweenDiagonal(Point other1, Point other2){

        //По диагонали
        return this.x > other1.x && this.x < other2.x
                && this.y > other1.y && this.y < other2.y;
                /*
                || this.y > other1.y && this.y < other2.y
                && Math.abs(this.x - other1.x) < epsilon && Math.abs(this.x - other2.x) < epsilon;*/
    }

    public boolean isOnScreen(){

        return !(x<0 || x > width || y < 0 || y > height);
    }

}

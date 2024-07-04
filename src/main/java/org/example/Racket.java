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

        //Остановка в отрицательную, и приём движения только в +
            position.x = Math.max(0, Math.min(480-width, position.x));



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


            targetVelocityX = -speed;


    }
    public void moveRight(){
            targetVelocityX = speed;

    }
    public void stop(){
        targetVelocityX = 0.0f;
    }


    @Override

    public float [][] getVertices(){
        float [][] positionObj = new float[4][2];
        positionObj[0][0] = position.x;
        positionObj[0][1]= position.y;

        positionObj[1][0]= position.x + width;
        positionObj[1][1]=position.y;

        positionObj[2][0]=position.x;
        positionObj[2][1]=position.y + height;

        positionObj[3][0]=position.x + width;
        positionObj[3][1]=position.y + height;


        return positionObj;}



        public Point getTL(){
            Point point = new Point(position.x,position.y);
            return point;
        }
        public Point getTR(){
            Point point = new Point(position.x + width,position.y);
            return point;
        }
        public Point getBL(){
            Point point = new Point(position.x,position.y + height);
            return point;
        }
        public Point getBR(){
            Point point = new Point(position.x + width,position.y + height);
            return point;
        }


}

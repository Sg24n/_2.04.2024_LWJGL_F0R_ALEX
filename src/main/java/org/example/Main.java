package org.example;
import org.lwjgl.opengl.*;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

public class Main {




    public void run() {
        //INIT  glfw
        if (!glfwInit()) {
            throw new IllegalStateException("GLFW INIT ERR");
        }

        //Окошка  креайтинг
        int width = 640;
        int height = 480;
        long mainWindow = glfwCreateWindow(width, height, "Basic1", NULL, NULL);
        if (mainWindow == NULL) {
            glfwTerminate();
            throw new RuntimeException("Window is broke :(");
        }

        //Настройка рендеринга окна
        glfwMakeContextCurrent(mainWindow);
        //Для использованмя opengl
        GL.createCapabilities();
        //Создание ортограф проекции Чтоб OpenGL поняла где она, и куда рендерить.
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, 640, 480, 0,-1, 1);
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();



    //Добавление блока шарика и missle
        Block block = new Block(100, 100, 50, 20, 1.0f, 1.0f, 1.0f);
        Racket racket = new Racket(320, 400, 30, 10,1.0f, 1.0f, 0.0f);
        Ball ball = new Ball(width, height, 320, 240, 15.0f, 0.6f, 0.5f, 0.5f, 0.7f,1.0f);

        //Настройка управления ракеткой
        glfwSetKeyCallback(mainWindow, (window, key, scancode, action, mods)->{
            if (action == GLFW_PRESS || action == GLFW_REPEAT){
                switch (key){
                    case GLFW_KEY_A -> racket.moveLeft();
                    case GLFW_KEY_D -> racket.moveRight();
                }
            } else if (action == GLFW_RELEASE){
                switch (key){
                    case GLFW_KEY_A, GLFW_KEY_D -> racket.stop();
                }
            }
        });



        //Main loop
        while (!glfwWindowShouldClose(mainWindow)) {
            //Цвет фона
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

            if(checkBallCollision(ball, racket, block)) {
                    if(ball.velocityY>= 2.0f){ball.velocityY = -ball.velocityY;} else {ball.velocityY = -(ball.velocityY*1.5f);}



            }

            block.render();

            ball.update();
            ball.render();

            racket.update();
            racket.render();

            
            glfwSwapBuffers(mainWindow);
            glfwPollEvents();
        }
        glfwDestroyWindow(mainWindow);
        glfwTerminate();
    }

    //Collision
    public boolean checkBallCollision(Ball ball, Racket racket, Block block){
        float ballLeft = ball.x - ball.radius;
        float ballRight = ball.x + ball.radius;
        float ballTop = ball.y - ball.radius;
        float ballBottom = ball.y + ball.radius;

        float racketLeft = racket.x;
        float racketRight = racket.x + racket.width;
        float racketTop = racket.y;
        float racketBottom = racket.y + racket.height;

        float blockLeft = block.x;
        float blockRight = block.x + block.width;
        float blockTop = block.y;
        float blockBottom= block.y + block.height;

      /*  if(ballRight < racketLeft || ballLeft > racketRight || ballBottom < racketTop || ballTop > racketBottom || ballRight < blockLeft || ballLeft > blockRight || ballBottom < blockTop || ballTop > blockBottom){
            return false;
        }*/
        boolean colissionWithRacket = !(ballRight < racketLeft || ballLeft > racketRight || ballBottom < racketTop || ballTop > racketBottom);
        boolean collisionWithBlock = !(ballRight < blockLeft || ballLeft > blockRight || ballBottom < blockTop || ballTop > blockBottom);
        return collisionWithBlock || colissionWithRacket;
    }
    public static void main(String[] args){
        new Main().run();
    }

}



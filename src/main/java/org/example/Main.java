package org.example;
import org.lwjgl.opengl.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

public class Main {
    //Добавление списка блоков для уровня
    BlockManager blockManager = new BlockManager();




    public void run() {
        //INIT  glfw
        if (!glfwInit()) {
            throw new IllegalStateException("GLFW INIT ERR");
        }

        //Окошка  креайтинг
        int width = 480;
        int height = 480;
        long mainWindow = glfwCreateWindow(width, height, "Basic1", NULL, NULL);
        if (mainWindow == NULL) {
            glfwTerminate();
            throw new RuntimeException("Window is broke :(");
        }

        glfwMakeContextCurrent(mainWindow);//Настройка рендеринга окна
        GL.createCapabilities();        //Для использованмя opengl
        //Создание ортограф проекции Чтоб OpenGL поняла где она, и куда рендерить.
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, width, height, 0,-1, 1);
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();



    //Добавление блока шарика и missile
        Racket racket = new Racket(width/2.14f, height/1.2f, 30, 10,1.0f, 1.0f, 0.0f);
        Ball ball = new Ball(width, height, width/2, height/2, 15.0f, 2.0f, 2.0f, 0.5f, 0.7f,1.0f);



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

            blockManager.addBlockForLevel(1,7);
            blockManager.render();
            blockManager.update(ball);




            //Blocks Iterator for safety deleting
           /* Iterator<Block> blockIterator = blockList.iterator();
            while (blockIterator.hasNext())
            {
                Block block = blockIterator.next();
                if(checkBlockCollision(ball,block)){
                    if (ball.velocityY<3f){ball.velocityY = -(ball.velocityY*1.5f);
                    } else {ball.velocityY = -ball.velocityY;}
                    blockIterator.remove();
                    break;
                }
            }*/

            if(checkRacketCollision(ball, racket)) {if(ball.velocityY>= 2.0f || ball.velocityY<= 2.0f ){ball.velocityY = -ball.velocityY;} else {ball.velocityY = -(ball.velocityY*1.5f);}}

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

    //Collision Racket
    public boolean checkRacketCollision(Ball ball, Racket racket){
        float ballLeft = ball.x - ball.radius;
        float ballRight = ball.x + ball.radius;
        float ballTop = ball.y - ball.radius;
        float ballBottom = ball.y + ball.radius;

        float racketLeft = racket.x;
        float racketRight = racket.x + racket.width;
        float racketTop = racket.y;
        float racketBottom = racket.y + racket.height;


        boolean colissionWithRacket = !(ballRight < racketLeft || ballLeft > racketRight || ballBottom < racketTop || ballTop > racketBottom);

        return colissionWithRacket;
    }

    //Collision Block
   /* public boolean checkBlockCollision(Ball ball, Block block){
        float ballLeft = ball.x - ball.radius;
        float ballRight = ball.x + ball.radius;
        float ballTop = ball.y - ball.radius;
        float ballBottom = ball.y + ball.radius;

        float blockLeft = block.x;
        float blockRight = block.x + block.width;
        float blockTop = block.y;
        float blockBottom= block.y + block.height;

        boolean collisionWithBlock = !(ballRight < blockLeft || ballLeft > blockRight || ballBottom < blockTop || ballTop > blockBottom);

        return collisionWithBlock;
    }*/
    public static void main(String[] args){
        new Main().run();
    }

}



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
    Physics physics = new Physics();
    LevelManager levelManager = new LevelManager(blockManager);




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
        glOrtho(0, height, width, 0,-1, 1);
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();



    //Добавление блока шарика и missile
        Racket racket = new Racket(width/2.14f, height/1.2f, 50, 10,1.0f, 1.0f, 0.0f);
        Ball ball = Factorys.BallFactory.createBall(width, height,
                width/2, height/2,
                8.0f,
                120.0f, 160.0f,
                0.5f, 0.7f,1.0f);


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

        levelManager.addBlockForLevel(1, "levels/level1.txt");

        //Main loop
        while (!glfwWindowShouldClose(mainWindow)) {
            //Цвет фона
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            float delta = physics.deltaTime();


            racket.update(delta);
            racket.render();


            ball.update(delta);
            ball.render();

            if(physics.checkCollision(ball, racket)) {physics.ReactOnCollision(ball,racket);}


            blockManager.update(ball);
            blockManager.render();








            glfwSwapBuffers(mainWindow);
            glfwPollEvents();
        }
        glfwDestroyWindow(mainWindow);
        glfwTerminate();
    }


    public static void main(String[] args){


        new Main().run();
    }

}



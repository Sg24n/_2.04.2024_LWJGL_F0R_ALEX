package org.example;

import org.lwjgl.opengl.*;

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
        glOrtho(0, height, width, 0, -1, 1);
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();


        //Добавление шарика и missile
        Racket racket = Factorys.RacketFactory.createRacket(width, height);
        Ball ball = Factorys.BallFactory.createBall(width, height);


        //Настройка управления ракеткой
        glfwSetKeyCallback(mainWindow, (window, key, scancode, action, mods) -> {
            if (action == GLFW_PRESS || action == GLFW_REPEAT) {
                switch (key) {
                    case GLFW_KEY_A -> racket.moveLeft();
                    case GLFW_KEY_D -> racket.moveRight();
                }
            } else if (action == GLFW_RELEASE) {
                switch (key) {
                    case GLFW_KEY_A, GLFW_KEY_D -> racket.stop();
                }
            }
        });

        int localI = 0;
        int megaI = 0;
        levelManager.loadLevel("level1", width, height);
        //Main loop
        while (!glfwWindowShouldClose(mainWindow)) {
            //Цвет фона
            megaI++;
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            float delta = physics.deltaTime();
          //  System.out.println(megaI + ". LocalI " + localI);
            boolean a = physics.checkCollision(ball, racket);

           /* if (physics.checkCollision(ball, racket)) {
                if(megaI - localI > 30){
               //     physics.ReactOnCollision(ball, racket);
                }
                localI = megaI;

            }*/
            racket.update(delta);
            racket.render();

            ball.update(delta);
            ball.render();



            blockManager.update(ball);
            blockManager.render();

            glfwSwapBuffers(mainWindow);
            glfwPollEvents();
        }
        glfwDestroyWindow(mainWindow);
        glfwTerminate();
    }


    public static void main(String[] args) {


        new Main().run();
    }

}



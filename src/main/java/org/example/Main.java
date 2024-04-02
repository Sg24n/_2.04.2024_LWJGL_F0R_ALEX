package org.example;
import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;
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
        long window = glfwCreateWindow(640, 480, "Basic1", NULL, NULL);
        if (window == NULL) {
            glfwTerminate();
            throw new RuntimeException("Window is broke :(");
        }

        //Настройка рендеринга окна
        glfwMakeContextCurrent(window);
        //Для использованмя opengl
        GL.createCapabilities();
        //Создание ортограф проекции Чтоб OpenGL поняла где она, и куда рендерить.
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, 640, 480, 0,-1, 1);
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();

    //Добавление блока
        Block block = new Block(100, 100, 50, 20, 1.0f, 1.0f, 1.0f); // Красный цвет
        while (!glfwWindowShouldClose(window)) {
            //Цвет фона
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

            block.render();

            glfwSwapBuffers(window);
            glfwPollEvents();
        }
        glfwDestroyWindow(window);
        glfwTerminate();
    }
    public static void main(String[] args){
        new Main().run();
    }

}


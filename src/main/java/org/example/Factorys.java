package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// ЭТОТ  ГЛУБОКО УВАЖАЕМЫЙ КЛАСС ТОЛЬКО ДЛЯ СОЗДАНИЯ!! ОБЪЕКТОВ, НО НЕ И ИЗМЕНЕНИЯ.
// НЕ ТРОЖ ЕГО СВОИМИ ГРЯЗНЫМИ РУЧОНКАМИ ДАЖЕ ЕСЛИ ОЧЕНЬ ХОЧЕТСЯ, ДМИТРИЙ
public class Factorys {

public class BlockFactory{

    //Создание единичного блока.
    public static Block createBlock(float x, float y, float width, float height, float r, float g, float b, float health) {
        return new Block(x, y, width, height, r, g, b, health);
    }

    //Создание ряда блоков, с вариацией уровня блока
    public static List<Block> createBlocksByLVL(int Level, int[][] levelData){

        float startY = 60.0f; // Начальное положение блоков по Y
        float verticalMargin = 10.0f; // Вертикальный отступ между блоками
        float blockHeight = 10.0f; // Высота блока

        List<Block> blockList = new ArrayList<>();
        for (int y = 0 ;y < levelData.length; y++) {
            for(int x = 0; x<levelData[y].length; x++) {
                if(levelData[y][x] == 1) {
                    float coordX = (480 / 9f) * x + (480 / 9f);
                    float coordY = startY + y * (blockHeight + verticalMargin);
                    blockList.add(new Block(coordX, coordY, 40, 10, 1.0f, 1.0f, 1.0f, 0.1f));
                }
            }
        }

        return blockList;
    }
}

public static class BallFactory{
    public static Ball createBall(int width, int height, float x, float y, float radius, float velocityX, float velocityY, float r, float g, float b){
        return new Ball(width,height,x,y,radius,velocityX,velocityY,r,g,b);
    }
}

}

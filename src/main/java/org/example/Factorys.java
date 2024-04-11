package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// ЭТОТ  ГЛУБОКО УВАЖАЕМЫЙ КЛАСС ТОЛЬКО ДЛЯ СОЗДАНИЯ!! ОБЪЕКТОВ, НО НЕ И ИЗМЕНЕНИЯ.
// НЕ ТРОЖ ЕГО СВОИМИ ГРЯЗНЫМИ РУЧОНКАМИ ДАЖЕ ЕСЛИ ОЧЕНЬ ХОЧЕТСЯ, ДМИТРИЙ
public class Factorys {
public class BlockFactory{


    //Создание ряда блоков, с вариацией уровня блока
    public static List<Block> createBlocksByLVL(int width, int Level, int[][] levelData){

        float startY = 60.0f; // Начальное положение блоков по Y
        float verticalMargin = 10.0f; // Вертикальный отступ между блоками
        float blockHeight = 10.0f; // Высота блока

        List<Block> blockList = new ArrayList<>();
        for (int y = 0 ;y < levelData.length; y++) {
            for(int x = 0; x<levelData[y].length; x++) {
                if(levelData[y][x] == 1) {
                    float coordX = (width / 9f) * x + (width / 9f);
                    float coordY = startY + y * (blockHeight + verticalMargin);
                    blockList.add(new Block(coordX, coordY, 40, 10, 1.0f, 1.0f, 1.0f, 0.1f));
                }
            }
        }

        return blockList;
    }
}

public static class BallFactory{
    public static Ball createBall(int width, int height){
        return new Ball(width, height,
                width/2, height/2,
                8.0f,
                120.0f, 160.0f,
                0.5f, 0.7f,1.0f);
    }
}

public static class RacketFactory{
    public static Racket createRacket(int width, int height){
        return new Racket(width/2.14f, height/1.2f, 50, 10,1.0f, 1.0f, 0.0f);
    }
}

}

package org.example;

import java.util.ArrayList;
import java.util.List;

public class Factorys {

public class BlockFactory{

    //Создание единичного блока.
    public static Block createBlock(float x, float y, float width, float height, float r, float g, float b, float health) {
        return new Block(x, y, width, height, r, g, b, health);
    }

    //Создание ряда блоков, с вариацией уровня блока
    public static List<Block> createBlocksByLVL(int Level, int quantitu){
         List<Block> blockList = new ArrayList<>();

        for (int i= 0 ;i<quantitu; i++) {
              blockList.add(new Block((480/9f) * i +(480/9f), 480/4,40, 10, 1.0f, 1.0f, 1.0f, 0.1f));
        }
        return blockList;
    }
}

}

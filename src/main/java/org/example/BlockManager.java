package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Управление блоками. Логично
public class BlockManager {
    private List<Block> blockList; // Список для управления блоками

    Physics physics = new Physics();
    public BlockManager(){
        this.blockList = new ArrayList<>(); // Инициализация пустого списка блоков

    }
    public void addBlockForLevel(int width, int LVL, int[][] levelData){
        List<Block> newBlocks = Factorys.BlockFactory.createBlocksByLVL(width, LVL,levelData);
        this.blockList.addAll(newBlocks); // Добавление новых блоков в список
    }
    public void update(Ball ball) {
        //Blocks Iterator for safety deleting
        Iterator<Block> blockIterator = blockList.iterator();
        while (blockIterator.hasNext()) {
            Block block = blockIterator.next();
            //Check collision Physics
            if (physics.checkCollision(ball, block)){
                System.out.println("UPDATE Collision is true");

               // physics.ReactOnCollision(ball, block);
                blockIterator.remove();
                break;
            }

        }

    }


    public void render(){
        for(Block block:blockList){
            //   block.update();
            block.render();
        }
    }
}

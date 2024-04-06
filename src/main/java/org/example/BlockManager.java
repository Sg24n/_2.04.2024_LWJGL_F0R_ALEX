package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Управление блоками. Логично
public class BlockManager {
    //Добавление списка блоков для уровня
    List<Block> blockList = Factorys.BlockFactory.createBlocksByLVL(1,7);
    Physics physics = new Physics();
    public BlockManager(){
        //Зачем это? кажется оно ничего не делает
       // blockList = new ArrayList<>();
    }
    public void addBlockForLevel(int LVL, int quantity){
        blockList.addAll(Factorys.BlockFactory.createBlocksByLVL(LVL,quantity));
    }
    public void update(Ball ball) {
        //Blocks Iterator for safety deleting
        Iterator<Block> blockIterator = blockList.iterator();
        while (blockIterator.hasNext()) {
            Block block = blockIterator.next();
            //Check collision Physics
            if (physics.checkBlockCollision(ball, block)){
                System.out.println("UPDATE Collision is true");

                physics.ReactOnCollision(ball);
                blockIterator.remove();
            }

            break;
        }

    }


    public void render(){
        for(Block block:blockList){
            //   block.update();
            block.render();
        }
    }
}

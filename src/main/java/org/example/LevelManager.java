package org.example;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Читает файл с параметрами и создаёт уровень.
public class LevelManager {

    private BlockManager blockManager;
    public LevelManager(BlockManager blockManager){
        this.blockManager = blockManager;
    }

    //Границы окна
    public static int width;
    public static int height;

    //Read file

    //Load level
    public void loadLevelFromFile(String filepath){
        List<String> lines = readLinesFromFile(filepath);

    }






    //Create racket


    //Create Block
    public void addBlockForLevel(int LVL, int quantity){
        List<Block> newBlocks = Factorys.BlockFactory.createBlocksByLVL(LVL, quantity);
        this.blockList.addAll(newBlocks); // Добавление новых блоков в список
    }

    //Create ball





    //Чтение срок из файла в лист
    private List<String> readLinesFromFile(String filePath) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
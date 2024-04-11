package org.example;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Читает файл с параметрами и создаёт уровень.
//Принимает имя файла

public class LevelManager {

    private static BlockManager blockManager;
    public LevelManager(BlockManager blockManager){
        this.blockManager = blockManager;
    }
    //Инфа о уровне из файла
    static int[][] levelData = {
            {1, 0, 1, 1, 0, 1, 0},
            {0, 1, 0, 0, 1, 0, 0},
            {1, 0, 1, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0}
    };


    //Границы окна
    public static int width;
    public static int height;

    //Read file

    //Load level
    public void loadLevelFromFile(String filepath){
        List<String> lines = readLinesFromFile(filepath);
        for (String line: lines){
            for (int x = 0; x<line.length(); x++){
            }
        }
    }






    //Create racket


    //Create Block
    public void addBlockForLevel(int LVL){
       blockManager.addBlockForLevel(LVL, levelData);
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
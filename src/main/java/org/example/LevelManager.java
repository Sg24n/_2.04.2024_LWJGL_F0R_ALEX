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
    private int[][] loadLevelData(String filepath){
        List<String> lines = readLinesFromFile(filepath);

        if(lines.isEmpty()){
            System.out.println("Level data is missing");
            return new int [0][0];
        }

        int rows = lines.size();
        int cols = lines.get(0).length();
        int[][] levelData = new int[rows][cols];


        // Заполнение массива данными
        for (int y = 0; y < rows; y++) {
            String line = lines.get(y);
            for (int x = 0; x < cols; x++) {
                char character = line.charAt(x);
                // Преобразование символа в число
                levelData[y][x] = Character.getNumericValue(character);
            }
        }

        return levelData;
    }







    //Create racket


    //Create Block
    public void addBlockForLevel(int LVL, String filepath){
       blockManager.addBlockForLevel(LVL, loadLevelData(filepath));
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
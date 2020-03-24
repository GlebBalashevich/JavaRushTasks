package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileReader inputReader = new FileReader(fileName);
        String string = "";
        while (inputReader.ready()){
            string = string + (char)inputReader.read();
        }
        inputReader.close();


        String[] worlds = string.split("\\W");
        int worldCount = 0;

        for(int i = 0; i < worlds.length; i++){
            if (worlds[i].equals("world")){
                worldCount++;
            }
        }

        System.out.println(worldCount);
    }
}

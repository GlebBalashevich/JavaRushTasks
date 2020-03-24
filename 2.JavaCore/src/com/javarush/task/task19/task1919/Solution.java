package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Double> mapa = new TreeMap<>();
        while(fileReader.ready()){
            String string = fileReader.readLine();
            String name = string.split(" ")[0];
            Double value = Double.parseDouble(string.split(" ")[1]);
            if (mapa.containsKey(name)){
                value = value + mapa.get(name);
            }
            mapa.put(name,value);
        }

        fileReader.close();

        for(Map.Entry<String, Double> pair : mapa.entrySet()){
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }
}

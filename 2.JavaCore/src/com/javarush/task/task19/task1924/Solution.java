package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();

        while(fileReader.ready()){
            String[] data = fileReader.readLine().split(" ");
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < data.length; i++){
                int number = -1;
                try {
                    number = Integer.parseInt(data[i]);
                } catch (NumberFormatException e){
                }
                if (number != -1 && map.containsKey(number)){
                    data[i] = map.get(number);
                }
                builder.append(data[i]);
                builder.append(" ");
            }
            System.out.println(builder.toString());
        }

        fileReader.close();
    }
}

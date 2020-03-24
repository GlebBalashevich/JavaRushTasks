package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        int id = Integer.parseInt(args[0]);

        BufferedReader inputStream = new BufferedReader(new FileReader(fileName));

        while(inputStream.ready()){
            String string = inputStream.readLine();
            String[] strings = string.split(" ");
            if (id == Integer.parseInt(strings[0])){
                System.out.println(string);
            }
        }

        inputStream.close();

    }
}

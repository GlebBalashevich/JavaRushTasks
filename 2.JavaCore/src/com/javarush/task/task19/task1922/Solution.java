package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();

        while(fileReader.ready()){
            String wordString = fileReader.readLine();
            String[] data = wordString.split(" ");
            int wordsCount = 0;
            for(int i = 0; i < data.length; i++){
                if (words.contains(data[i])){
                    wordsCount++;
                }
            }
            if (wordsCount == 2){
                System.out.println(wordString);
            }
        }
        fileReader.close();
    }
}

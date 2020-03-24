package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileInputReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileOutputReader = new BufferedWriter(new FileWriter(args[1]));
        StringBuilder builder = new StringBuilder();

        while(fileInputReader.ready()){
            String[] data = fileInputReader.readLine().split(" ");
            for(String word : data){
                if(word.length() > 6){
                    builder.append(word + " ");
                }
            }
        }

        String outputString = builder.toString();
        outputString = outputString.trim().replaceAll(" ", ",");
        fileOutputReader.write(outputString);

        fileInputReader.close();
        fileOutputReader.close();
    }
}

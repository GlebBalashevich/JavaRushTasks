package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = reader.readLine();
        String secondFileName = reader.readLine();
        reader.close();

        BufferedReader inputReader = new BufferedReader(new FileReader(firstFileName));
        BufferedWriter outputWriter = new BufferedWriter(new FileWriter(secondFileName));

        String fileString = "";
        while(inputReader.ready()){
            fileString = fileString.concat(inputReader.readLine());
        }
        inputReader.close();

        fileString = fileString.replace(".", "!");

        outputWriter.write(fileString);
        outputWriter.close();
    }
}

package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = reader.readLine();
        String secondFileName = reader.readLine();
        reader.close();

        FileReader inputReader = new FileReader(firstFileName);
        FileWriter outputWriter = new FileWriter(secondFileName);

        int evenCount = 0;
        while(inputReader.ready()){
            int result = inputReader.read();
            evenCount++;
            if (evenCount % 2 == 0){
                outputWriter.write(result);
            }
        }

        inputReader.close();
        outputWriter.close();
    }
}

package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.ArrayList;

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
            fileString = fileString + inputReader.readLine();
        }
        inputReader.close();

        String[] strings = fileString.split(" ");
        ArrayList<Integer> numbers = new ArrayList<>();
        for(String string : strings){
            try{
                int parseResult = Integer.parseInt(string);
                numbers.add(parseResult);
            }catch (NumberFormatException e){

            }
        }

        for(int i = 0; i < numbers.size(); i++){
            outputWriter.write(numbers.get(i) + " ");
        }
        outputWriter.close();
    }
}

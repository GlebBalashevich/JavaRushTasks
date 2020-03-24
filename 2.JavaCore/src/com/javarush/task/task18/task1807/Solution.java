package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = new BufferedReader(new InputStreamReader(System.in)).readLine();
        FileInputStream inputStream = new FileInputStream(fileName);
        int countChar = 0;
        while (inputStream.available() > 0){
            int result = inputStream.read();
            if (result == 44){
                countChar++;
            }
        }
        System.out.println(countChar);
        inputStream.close();
    }
}

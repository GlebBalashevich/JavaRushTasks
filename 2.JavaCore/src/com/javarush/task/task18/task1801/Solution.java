package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String filename = new BufferedReader(new InputStreamReader(System.in)).readLine();
        FileInputStream file = new FileInputStream(filename);
        int maxiByte = 0;
        while (file.available() > 0){
            int redByte = file.read();
            if (maxiByte < redByte){
                maxiByte = redByte;
            }
        }
        System.out.println(maxiByte);
        file.close();
    }
}

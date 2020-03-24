package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String filename = new BufferedReader(new InputStreamReader(System.in)).readLine();
        FileInputStream file = new FileInputStream(filename);
        int miniByte = 0;
        while (file.available() > 0) {
            int redByte = file.read();
            if (miniByte > redByte || miniByte == 0) {
                miniByte = redByte;
            }
        }
        System.out.println(miniByte);
        file.close();
    }
}

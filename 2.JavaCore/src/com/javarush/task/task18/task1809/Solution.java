package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream inputStream = new FileInputStream(reader.readLine());
        FileOutputStream outputStream = new FileOutputStream(reader.readLine());

        reader.close();

        if (inputStream.available() > 0){
            int[] ints = new int[inputStream.available()];
            for (int i = inputStream.available()-1; i >= 0; i--) {
                ints[i] = inputStream.read();
            }
            for (int i = 0; i < ints.length; i++){
                outputStream.write(ints[i]);
            }
        }

        inputStream.close();
        outputStream.close();
    }
}

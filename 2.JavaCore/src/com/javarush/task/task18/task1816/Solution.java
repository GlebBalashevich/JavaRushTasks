package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        int count = 0;

        FileInputStream inputStream = new FileInputStream(fileName);

        while (inputStream.available() > 0){
            byte byteVal = (byte)inputStream.read();
            if ((byteVal >= 65 && byteVal <= 90) || (byteVal >= 97 && byteVal <= 122)){
                count++;
            }
        }

        inputStream.close();
        System.out.println(count);
    }
}

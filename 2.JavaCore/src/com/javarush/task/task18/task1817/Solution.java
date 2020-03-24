package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);

        int countSpace = 0;
        int countChars = 0;
        double relation = 0;

        while(inputStream.available() > 0){
            if (inputStream.read() == 32){
                countSpace++;
            }
            countChars++;
        }

        inputStream.close();

        relation = countSpace*1.0 / countChars * 100;

        DecimalFormat df = new DecimalFormat("#.##");
        //df.setRoundingMode(RoundingMode.CEILING);

        System.out.println(df.format(relation));
    }
}

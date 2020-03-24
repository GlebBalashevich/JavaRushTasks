package com.javarush.task.task05.task0507;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Среднее арифметическое
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String value;
        int count = 0;
        int total = 0;
        while(true){
            value = reader.readLine();
            int number = Integer.parseInt(value);
            if (number == -1){
                break;
            }
            total += number;
            count ++;
        }
        System.out.println((double) total / count);
    }
}


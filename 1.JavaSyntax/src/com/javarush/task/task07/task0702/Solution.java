package com.javarush.task.task07.task0702;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Массив из строчек в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] stringArray = new String[10];
        for (int i = 0; i < 8; i++) {
            stringArray[i] = reader.readLine();
        }
        for (int i = stringArray.length-1; i >= 0; i--) {
            System.out.println(stringArray[i]);
        }
    }
}
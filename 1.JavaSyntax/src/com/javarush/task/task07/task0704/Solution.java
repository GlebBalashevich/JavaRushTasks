package com.javarush.task.task07.task0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Переверни массив
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbersArray = new int[10];
        for (int i = 0; i < numbersArray.length; i++) {
            numbersArray[i] = Integer.parseInt(reader.readLine());
        }
        for (int i = numbersArray.length-1; i >= 0; i--) {
            System.out.println(numbersArray[i]);
        }
    }
}


package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String[] strings = initializeStringArray();
        int[] lengths = initializeIntArray(strings);
        for (int i = 0; i < lengths.length; i++) {
            System.out.println(lengths[i]);
        }
    }

    public static String[] initializeStringArray() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = new String[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = reader.readLine();
        }
        return array;
    }

    public static int[] initializeIntArray(String[] array){
        int[] numbersArray = new int[10];
        for (int i = 0; i < array.length; i++) {
            numbersArray[i] = array[i].length();
        }
        return numbersArray;
    }
}

package com.javarush.task.task07.task0728;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

/* 
В убывающем порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x : array) {
            System.out.println(x);
        }
    }

    public static void sort(int[] array) {
        int[] sortArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            sortArray[i] = array[i];
        }
        Arrays.sort(sortArray);
        int j = array.length-1;
        for (int i = 0; i < array.length; i++) {
            array[j] = sortArray[i];
            j--;
        }
    }
}

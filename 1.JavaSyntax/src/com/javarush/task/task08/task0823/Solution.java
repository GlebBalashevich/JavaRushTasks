package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        string = string.trim();
        String[] array = string.split(" ");
        string = "";
        for (int i = 0; i < array.length; i++) {
            if (array[i].length() != 0){
                String word = array[i];
                word = word.substring(0,1).toUpperCase() + word.substring(1);
                string = string + word + " ";
            }
        }
        System.out.println(string);
    }
}

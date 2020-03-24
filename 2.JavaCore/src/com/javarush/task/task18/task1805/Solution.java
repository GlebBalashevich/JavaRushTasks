package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName = new BufferedReader(new InputStreamReader(System.in)).readLine();
        FileInputStream file = new FileInputStream(fileName);
        ArrayList<Integer> bytesList = new ArrayList<>();

        while (file.available() > 0){
            int byteValue = file.read();
            if (!bytesList.contains(byteValue)){
                bytesList.add(byteValue);
            }
        }

        file.close();
        Collections.sort(bytesList);

        for(Integer value : bytesList){
            System.out.print(value + " ");
        }
    }
}

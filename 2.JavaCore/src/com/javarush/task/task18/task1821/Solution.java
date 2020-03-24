package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);

        SortedMap<Character, Integer> map = new TreeMap<>();

        while(inputStream.available() > 0){
            char key = (char)inputStream.read();
            if (map.containsKey(key)) {
                for (Map.Entry<Character, Integer> pair : map.entrySet()) {
                    if (pair.getKey() == key) {
                        pair.setValue(pair.getValue() + 1);
                    }
                }
            }
            else{
                map.put(key, 1);
            }
        }

        inputStream.close();

        for(Map.Entry<Character, Integer> elem : map.entrySet()){
            System.out.println(elem.getKey() + " " + elem.getValue());
        }
    }
}

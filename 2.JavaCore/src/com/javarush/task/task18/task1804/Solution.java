package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName = new BufferedReader(new InputStreamReader(System.in)).readLine();
        FileInputStream file = new FileInputStream(fileName);
        Map<Integer, Integer> bytesMap = new HashMap<>();
        while (file.available() > 0){
            int byteValue = file.read();
            if (bytesMap.containsKey(byteValue)){
                bytesMap.put(byteValue,bytesMap.get(byteValue)+1);
            }
            else{
                bytesMap.put(byteValue, 1);
            }
        }

        file.close();

        int minimum = Collections.min(bytesMap.values());

        for(Map.Entry<Integer,Integer> mapa : bytesMap.entrySet()){
            if (mapa.getValue() == minimum){
                System.out.print(mapa.getKey() + " ");
            }
        }
    }
}

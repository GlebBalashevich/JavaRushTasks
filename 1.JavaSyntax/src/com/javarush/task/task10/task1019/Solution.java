package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();

        while(true){
            String sId = reader.readLine();
            if (sId.isEmpty()) break;
            String name = reader.readLine();
            map.put(name, Integer.parseInt(sId));
            if (name.isEmpty()) break;
        }

        for(Map.Entry<String,Integer> mapa: map.entrySet()) {
            System.out.println(mapa.getValue() + " " + mapa.getKey());
        }
    }
}

package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> list = new HashMap<String, String>();
        while (true) {
            String city = reader.readLine();
            if (city.equals("")) break;
            String family = reader.readLine();
            if (family.equals("")) break;
            list.put(city, family);
        }
        String value = reader.readLine();

        for(Map.Entry<String, String> x : list.entrySet()){
            String city = x.getKey();
            if (city.equals(value)){
                System.out.println(x.getValue());
                break;
            }
        }
    }
}

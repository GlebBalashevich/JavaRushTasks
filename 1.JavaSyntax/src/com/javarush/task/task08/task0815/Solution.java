package com.javarush.task.task08.task0815;

import java.security.KeyStore;
import java.util.HashMap;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();
        map.put("Ананенко","Глеб");
        map.put("Федоренко","Лиза");
        map.put("Балашевич","Софья");
        map.put("Серая","Лиза");
        map.put("Путопроводный","Лиза");
        map.put("Лаговская","Виктория");
        map.put("Порошенко","Петр");
        map.put("Александр","Глеб");
        map.put("Боярская","Софья");
        map.put("Банцевич","Софья");
        return map;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        int count = 0;
        for(Map.Entry<String, String> pair : map.entrySet()){
            if (pair.getValue().contains(name)){
                count++;
            }
        }
        return count;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        int count = 0;
        for(Map.Entry<String, String> pair : map.entrySet()){
            if (pair.getKey().equals(lastName)){
                count++;
            }
        }
        return count;

    }

    public static void main(String[] args) {
//        Map<String,String> map = createMap();
//        System.out.println(getCountTheSameFirstName(map,"Софья"));
//        System.out.println(getCountTheSameLastName(map,"Балашевич"));
    }
}

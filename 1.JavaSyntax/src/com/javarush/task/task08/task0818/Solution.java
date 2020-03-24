package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Иванов", 450);
        map.put("Петров", 700);
        map.put("Сидоров", 3700);
        map.put("Глебов", 300);
        map.put("Висюлькин", 500);
        map.put("Чумаков", 600);
        map.put("Балашевич", 44450);
        map.put("Банцевич", 34450);
        map.put("Лаговский", 200);
        map.put("Гулис", 200);
        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        Iterator<Map.Entry<String,Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> value = iterator.next();
            if (value.getValue() < 500){
                iterator.remove();
            }
        }

    }

    public static void main(String[] args) {
    }
}
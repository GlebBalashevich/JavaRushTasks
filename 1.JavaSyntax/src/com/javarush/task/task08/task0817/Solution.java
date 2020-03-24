package com.javarush.task.task08.task0817;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();
        map.put("Барбоскина", "Лиза");
        map.put("Иванова", "Ольга");
        map.put("Петрова", "Юлия");
        map.put("Сидорова", "Екатерина");
        map.put("Вертинская", "Вера");
        map.put("Лаговская", "Лиза");
        map.put("Чумакова", "Людмила");
        map.put("Чванкина", "Екатерина");
        map.put("Балашевич", "Лиза");
        map.put("Банцевич", "Елена");
        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        ArrayList<String> array = new ArrayList<>(map.values());
        for (int i = 0; i < array.size(); i++) {
            String name = array.get(i);
            for (int j = i+1; j < array.size(); j++) {
                if (name.equals(array.get(j))){
                    removeItemFromMapByValue(map, name);
                }
            }
        }

    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {

    }
}

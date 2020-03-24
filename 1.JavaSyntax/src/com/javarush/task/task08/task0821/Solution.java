package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        Map<String, String> peoples = new HashMap<>();
        peoples.put("Иванов", "Иван");
        peoples.put("Глебов", "Вася");
        peoples.put("Иванов", "Петр");
        peoples.put("Иванов", "Петр");
        peoples.put("Петров", "Сергей");
        peoples.put("Иванов", "Сярожа");
        peoples.put("Сидоров", "Алеша");
        peoples.put("Иванов", "Глею");
        peoples.put("Жоров", "Иван");
        peoples.put("Боров", "Иван");

        return peoples;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}

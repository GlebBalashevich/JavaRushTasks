package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        Map<String, Cat> cats = new HashMap<>();
        cats.put("Vaska", new Cat("Vaska"));
        cats.put("Vaska1", new Cat("Vaska1"));
        cats.put("Vaska2", new Cat("Vaska2"));
        cats.put("Vaska3", new Cat("Vaska3"));
        cats.put("Vaska4", new Cat("Vaska4"));
        cats.put("Vaska5", new Cat("Vaska5"));
        cats.put("Vaska6", new Cat("Vaska6"));
        cats.put("Vaska7", new Cat("Vaska7"));
        cats.put("Vaska8", new Cat("Vaska8"));
        cats.put("Vaska9", new Cat("Vaska9"));
        return cats;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        Set<Cat> cats = new HashSet<>();
        for(Map.Entry<String, Cat> pairs : map.entrySet()){
            cats.add(pairs.getValue());
        }
        return cats;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}

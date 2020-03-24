package com.javarush.task.task07.task0716;

import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("роза");
        strings.add("лоза");
        strings.add("лира");
        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> strings) {
        for (int i = 0; i < strings.size(); i++) {
            String check = strings.get(i);
            System.out.println(strings.get(i) + " " + i + " " + strings.get(i).contains("р") + " " + strings.get(i).contains("л"));
            if (strings.get(i).contains("р") && !strings.get(i).contains("л")){
                strings.remove(i);
                i--;
                continue;
            }
            if (!strings.get(i).contains("р") && strings.get(i).contains("л")){
                strings.add(i,check);
                i++;
                continue;
            }
        }

        return strings;
    }

}
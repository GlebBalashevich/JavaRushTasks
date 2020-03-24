package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> numbers = new ArrayList();
        for (int i = 0; i < 5; i++) {
            numbers.add(Integer.parseInt(reader.readLine()));
        }
        for (int i = 0; i < numbers.size(); i++) {
            int glass = numbers.get(i);
            for (int j = i+1; j < numbers.size(); j++) {
                if (glass > numbers.get(j)){
                    numbers.set(i,numbers.get(j));
                    numbers.set(j,glass);
                    glass = numbers.get(i);
                }
            }
            System.out.println(numbers.get(i));
        }
    }
}

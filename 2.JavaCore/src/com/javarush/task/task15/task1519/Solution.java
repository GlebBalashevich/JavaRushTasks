package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String value = reader.readLine();
            if (value.equals("exit")) break;
            prePrint(value);
        }
    }

    public static void prePrint(String value) {
        try {
            if (value.contains(".")) {
                print(Double.parseDouble(value));
            }
            else {
                int number = Integer.parseInt(value);
                if (number > 0 && number < 128) {
                    print((short) number);
                } else {
                    print(number);
                }
            }
        } catch (NumberFormatException e) {
            print(value);
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
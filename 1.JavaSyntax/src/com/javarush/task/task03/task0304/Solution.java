package com.javarush.task.task03.task0304;

/* 
Задача на проценты
*/

public class Solution {
    public static double addTenPercent(int i) {
        double result = i * 10.0 / 100.0;
        result += i;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(addTenPercent(9));
    }
}

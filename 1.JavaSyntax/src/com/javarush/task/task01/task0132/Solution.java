package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        int result = 0;
        int i = 0;
        while (i < 3){
            result = result + number % 10;
            number = number / 10;
            i++;
        }
        return result;
    }
}
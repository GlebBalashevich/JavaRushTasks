package com.javarush.task.task03.task0309;

/* 
Сумма 5 чисел
*/

public class Solution {
    public static void main(String[] args) {
        int result = 0;
        int i = 1;
        while (i <= 5){
            result = result + i;
            i++;
            System.out.println(result);
        }
    }
}

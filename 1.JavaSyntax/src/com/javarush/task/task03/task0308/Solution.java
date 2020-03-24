package com.javarush.task.task03.task0308;

/* 
Произведение 10 чисел
*/

public class Solution {
    public static void main(String[] args) {
        int result = 1;
        int i = 1;
        while (i <= 10){
            result = result * i;
            i++;
        }
        System.out.println(result);
    }
}

package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sNumber = reader.readLine();
        int number = Integer.parseInt(sNumber);
        if (number >= 1 && number <= 999){
            if (number / 10 == 0 && number %2 == 0){
                System.out.println("четное однозначное число");
            }
            if (number / 10 == 0 && number %2 != 0){
                System.out.println("нечетное однозначное число");
            }
            if (number / 100 == 0 && number / 10 != 0 && number %2 == 0){
                System.out.println("четное двузначное число");
            }
            if (number / 100 == 0 && number / 10 != 0 && number %2 != 0){
                System.out.println("нечетное двузначное число");
            }
            if (number / 1000 == 0 && number / 100 != 0 && number %2 == 0){
                System.out.println("четное трехзначное число");
            }
            if (number / 1000 == 0 && number / 100 != 0 && number %2 != 0){
                System.out.println("нечетное трехзначное число");
            }
        }
    }
}

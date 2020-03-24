package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sNumber = reader.readLine();
        int number = Integer.parseInt(sNumber);
        if (number < 0 && number %2 == 0){
            System.out.println("отрицательное четное число");
        }
        if (number < 0 && number %2 != 0){
            System.out.println("отрицательное нечетное число");
        }
        if (number == 0){
            System.out.println("ноль");
        }
        if (number > 0 && number %2 == 0){
            System.out.println("положительное четное число");
        }
        if (number > 0 && number %2 != 0){
            System.out.println("положительное нечетное число");
        }

    }
}

package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sA = reader.readLine();
        String sB = reader.readLine();
        String sC = reader.readLine();
        int a = Integer.parseInt(sA);
        int b = Integer.parseInt(sB);
        int c = Integer.parseInt(sC);
        int positiveCount = 0;
        int negativeCount = 0;
        if (a > 0)
            positiveCount++;
        if (b > 0)
            positiveCount ++;
        if (c > 0)
            positiveCount ++;
        if (a < 0)
            negativeCount++;
        if (b < 0)
            negativeCount ++;
        if (c < 0)
            negativeCount ++;
        System.out.println("количество отрицательных чисел: " + negativeCount + "\nколичество положительных чисел: " + positiveCount);

    }
}

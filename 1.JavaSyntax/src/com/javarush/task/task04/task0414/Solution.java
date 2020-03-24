package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sYear = reader.readLine();
        int year = Integer.parseInt(sYear);
        checkYear(year);
    }

    public static void checkYear(int year) {
        int nDays = 365;
        if (year % 400 == 0){
            nDays = 366;
        }
        if (year % 4 == 0 && (year % 400 == 0 || year % 100 != 0)){
            nDays = 366;
        }
        System.out.println("количество дней в году: " + nDays);
    }
}
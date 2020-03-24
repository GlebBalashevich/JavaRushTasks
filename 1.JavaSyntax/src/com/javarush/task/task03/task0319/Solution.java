package com.javarush.task.task03.task0319;

/* 
Предсказание на будущее
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        String sValue = reader.readLine();
        String sYears = reader.readLine();
        int iValue = Integer.parseInt(sValue);
        int iYears = Integer.parseInt(sYears);
        System.out.println(name + " получает " + iValue + " через " + iYears + " лет.");

    }
}

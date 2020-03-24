package com.javarush.task.task04.task0442;

/* 
Суммирование
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = 0;
        String sNumber;
        int count = 0;
        while (number != -1){
            sNumber = reader.readLine();
            number = Integer.parseInt(sNumber);
            count += number;
        }
        System.out.println(count);
    }
}

package com.javarush.task.task04.task0418;

/* 
Минимум двух чисел
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sA = reader.readLine();
        String sB = reader.readLine();
        int a = Integer.parseInt(sA);
        int b = Integer.parseInt(sB);
        if (a <= b){
            System.out.println(a);
        }
        else{
            System.out.println(b);
        }

    }
}
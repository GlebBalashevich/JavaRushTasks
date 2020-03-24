package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
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
        int max = findMax(a,b,c);
        int min = findMin(a,b,c);
        int middle = findMid(min,max,a,b,c);
        System.out.println(max + " " + middle + " " + min);
    }

    public static int findMax(int a, int b, int c){
        if (a >= b && a >= c){
            return a;
        }
        if (b >= a && b >= c){
            return b;
        }
        if (c >=a && c >= b){
            return c;
        }
        return  0;
    }
    public static int findMin(int a, int b, int c){
        if (a <= b && a <= c){
            return a;
        }
        if (b <= a && b <= c){
            return b;
        }
        if (c <=a && c <= b){
            return c;
        }
        return 0;
    }
    public static int findMid(int min, int max, int a, int b, int c){
        if ((min == a && max == b) || (max == a && min == b)){
            return c;
        }
        if ((min == a && max == c) || (max == a && min == c)){
            return b;
        }
        if ((min == b && max == c) || (max == b && min == c)){
            return a;
        }
        return 0;
    }

}

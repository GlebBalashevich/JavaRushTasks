package com.javarush.task.task04.task0441;

/* 
Как-то средненько
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
        int result = 0;
        if ((a <= b && a >= c) || (a >= b && a <= c)){
            result = a;
        }
        if ((b <= a && b >= c) || (b >= a && b <= c)){
            result = b;
        }
        if ((c <= a && c >= b) || (c >= a && c <= b)){
            result = c;
        }
        System.out.println(result);
    }
}

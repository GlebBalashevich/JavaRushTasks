package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
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
        if (a == b && b == c){
            System.out.println(a + " " + b + " " + c);
        }
        else {
            if (a == b) {
                System.out.println(a + " " + b);
            }
            if (a == c) {
                System.out.println(a + " " + c);
            }
            if (b == c) {
                System.out.println(b + " " + c);
            }
        }
    }
}
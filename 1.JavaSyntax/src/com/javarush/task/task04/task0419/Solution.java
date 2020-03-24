package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sA = reader.readLine();
        String sB = reader.readLine();
        String sC = reader.readLine();
        String sD = reader.readLine();
        int a = Integer.parseInt(sA);
        int b = Integer.parseInt(sB);
        int c = Integer.parseInt(sC);
        int d = Integer.parseInt(sD);
        if (maximumTwo(a,b) > maximumTwo(c,d)){
            System.out.println(maximumTwo(a,b));
        }
        else{
            System.out.println(maximumTwo(c,d));
        }

    }
    public static int maximumTwo(int aMax, int bMax){
        if (aMax > bMax){
            return aMax;
        }
        else{
            return bMax;
        }
    }
}

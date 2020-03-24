package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sNumber = reader.readLine();
        int iNumber = Integer.parseInt(sNumber);
        if (iNumber > 0){
            iNumber *= 2;
        }
        if (iNumber < 0){
            iNumber += 1;
        }
        if (iNumber == 0){
            iNumber = 0;
        }
        System.out.println(iNumber);
    }

}
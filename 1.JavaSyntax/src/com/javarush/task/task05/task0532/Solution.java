package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n =  Integer.parseInt(reader.readLine());
        int maximum = 0;
        for (int i = 0; i < n; i++) {
            int checkNum = Integer.parseInt(reader.readLine());
            maximum = i == 0 ? checkNum : maximum;
            maximum = maximum > checkNum ? maximum : checkNum;
        }

        System.out.println(maximum);
    }
}

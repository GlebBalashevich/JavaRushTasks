package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a, b;
            a = Integer.parseInt(reader.readLine());
            b = Integer.parseInt(reader.readLine());
            if (a <= 0 || b <= 0) throw new Exception();
            findNOD(a,b);
    }

    public static void findNOD(int a, int b){
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        for (int i = min; i > 0; i--) {
            if (max % i == 0 && min % i == 0){
                System.out.println(i);
                break;
            }
        }
    }

}

package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] bigArray = new int[20];
        int[] firstSmallArray = new int[10];
        int[] secondSmallArray = new int[10];

        for (int i = 0; i < bigArray.length; i++) {
            bigArray[i] = Integer.parseInt(reader.readLine());
        }

        for (int i = 0; i < bigArray.length; i++) {
            if (i < 10){
                firstSmallArray[i] = bigArray[i];
            }
            else{
                secondSmallArray[i-10] = bigArray[i];
            }
        }

        for (int i = 0; i < secondSmallArray.length; i++) {
            System.out.println(secondSmallArray[i]);

        }
    }
}

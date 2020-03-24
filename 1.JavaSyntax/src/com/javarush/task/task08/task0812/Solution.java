package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            arrayList.add(i, Integer.parseInt(reader.readLine()));
        }

        longerSequence(arrayList);

    }

    public static void longerSequence (List<Integer> list){
        int longerCount = 0;
        int count = 0;
        int currentValue = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if (currentValue == list.get(i)){
                count++;
            }
            else{
                currentValue = list.get(i);
                count = 0;
            }
            longerCount = Math.max(longerCount, count);
        }
        System.out.println(longerCount+1);
    }
}
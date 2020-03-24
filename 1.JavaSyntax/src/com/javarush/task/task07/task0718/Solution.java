package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            strings.add(reader.readLine());
        }

        int checkString = checkStringsSize(strings);

        if (checkString >= 0){
            System.out.println(checkString);
        }

    }

    public static int checkStringsSize(ArrayList<String> list){
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i).length()+1 != list.get(i+1).length()){
                return i+2;
            }
        }
        return -1;
    }
}


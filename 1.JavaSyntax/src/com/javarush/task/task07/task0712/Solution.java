package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.BufferOverflowException;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> strings = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            strings.add(reader.readLine());
        }

        int maxLength = strings.get(0).length();
        int minLength = strings.get(0).length();
        for (int i = 0; i < strings.size(); i++) {
            if (minLength > strings.get(i).length()){
                minLength = strings.get(i).length();
            }
            if (maxLength < strings.get(i).length()){
                maxLength = strings.get(i).length();
            }
        }

        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).length() <= minLength){
                System.out.println(strings.get(i));
                break;
            }
            if (strings.get(i).length() >= maxLength){
                System.out.println(strings.get(i));
                break;
            }
        }
    }
}

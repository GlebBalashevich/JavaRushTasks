package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sMinutes = reader.readLine();
        double minutes = Double.parseDouble(sMinutes);
        minutes *= 10;
        while (minutes > 50){
            minutes -= 50;
        }
        if ((minutes >= 0 && minutes < 30) || minutes == 50){
            System.out.println("зеленый");
        }
        if (minutes >= 30 && minutes < 40){
            System.out.println("желтый");
        }
        if (minutes >= 40 && minutes < 50){
            System.out.println("красный");
        }
    }
}
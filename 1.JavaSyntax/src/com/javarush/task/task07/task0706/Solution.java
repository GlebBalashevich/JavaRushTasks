package com.javarush.task.task07.task0706;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] houses = new int[15];
        int evenHousesPeople = 0;
        int oddHousesPeople = 0;

        for (int i = 0; i < houses.length; i++) {
            houses[i] = Integer.parseInt(reader.readLine());
        }

        for (int i = 0; i < houses.length; i++) {
            if (i % 2 == 0){
                evenHousesPeople += houses[i];
            }
            else{
                oddHousesPeople += houses[i];
            }
        }

        if (evenHousesPeople > oddHousesPeople){
            System.out.println("В домах с четными номерами проживает больше жителей.");
        }
        else{
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        }
    }
}

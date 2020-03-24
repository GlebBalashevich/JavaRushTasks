package com.javarush.task.task09.task0926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<int[]> list = createList();
        fillList(list);
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[5]);
        list.add(new int[2]);
        list.add(new int[4]);
        list.add(new int[7]);
        list.add(new int[0]);
        return list;
    }

    public static void fillList(ArrayList<int[]> list) throws IOException {
        for(int[]array : list){
            for(int i = 0; i < array.length; i++){
                array[i] = i;
            }
        }
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}

package com.javarush.task.task14.task1421;

/*
Singleton
*/
public class Solution {
    public static void main(String[] args) {
        Singleton sing1 = Singleton.getInstance();
        System.out.println(sing1.toString());
        Singleton sing2 = Singleton.getInstance();
        System.out.println(sing2.toString());
    }
}

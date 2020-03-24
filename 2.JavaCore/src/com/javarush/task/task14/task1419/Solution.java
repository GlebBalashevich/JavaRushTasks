package com.javarush.task.task14.task1419;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int[] array = new int[5];
            array[5] = 5;
        } catch (ArrayIndexOutOfBoundsException e){
            exceptions.add(e);
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("sdfdsf")));
        } catch (FileNotFoundException e){
            exceptions.add(e);
        }

        try{
            String s = null;
            String k = "k";
            if (s.equals(k)){
                s = k;
            }
        } catch (NullPointerException e){
            exceptions.add(e);
        }

        try{
            int[] array = new int[-5];
            array[0] = 1;
        }catch (NegativeArraySizeException e){
            exceptions.add(e);
        }

        try{
            Animal animal = new Animal();
            Pet pet = (Pet)animal;
        } catch (ClassCastException e){
            exceptions.add(e);
        }

        try{
            String a = "abc";
            int number = Integer.parseInt(a);
        } catch(NumberFormatException e){
            exceptions.add(e);
        }

        try {
            wedding(new Man(), new Man());
        } catch (GayLesboException e){
            exceptions.add(e);
        }

        try{
            calculate(120);
        } catch(TooOldException e){
            exceptions.add(e);
        }

        try{
            square(-1,5);
        } catch(NegativeSquareException e){
            exceptions.add(e);
        }

    }

    public static void calculate(int age) throws TooOldException {
        if (age > 100){
            throw new TooOldException();
        }
    }

    public static void square (int a, int b) throws NegativeSquareException {
        if (a*b < 0){
            throw new NegativeSquareException();
        }
    }

    public static void wedding (Human fiance, Human bride) throws GayLesboException {
        if (!(fiance instanceof Man) || !(bride instanceof Woman)){
            throw new GayLesboException();
        }
    }

    static class TooOldException extends Exception{

    }

    static class NegativeSquareException extends Exception{

    }

    static class GayLesboException extends Exception{

    }
}

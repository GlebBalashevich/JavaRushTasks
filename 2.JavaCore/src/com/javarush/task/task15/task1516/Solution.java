package com.javarush.task.task15.task1516;

/* 
Значения по умолчанию
*/

public class Solution {
    public int intVar;
    public double doubleVar;
    public Double DoubleVar;
    public boolean booleanVar;
    public Object ObjectVar;
    public Exception ExceptionVar;
    public String StringVar;

    public static void main(String[] args) {

        Solution vars = new Solution();
        System.out.println(vars.intVar);
        System.out.println(vars.doubleVar);
        System.out.println(vars.DoubleVar);
        System.out.println(vars.booleanVar);
        System.out.println(vars.ObjectVar);
        System.out.println(vars.ExceptionVar);
        System.out.println(vars.StringVar);
    }
}

package com.javarush.task.task09.task0902;

/* 
И снова StackTrace
*/

public class Solution {
    StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();

    public static void main(String[] args) {
        method1();
    }

    public static String method1() {
        method2();
        StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
        return stackTraceElement[2].getMethodName();
    }

    public static String method2() {
        method3();
        StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
        return stackTraceElement[2].getMethodName();
    }

    public static String method3() {
        method4();
        StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();System.out.println(stackTraceElement[stackTraceElement.length-1].getMethodName());
        return stackTraceElement[2].getMethodName();
    }

    public static String method4() {
        method5();
        StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
        return stackTraceElement[2].getMethodName();

    }

    public static String method5() {
        StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
        return stackTraceElement[2].getMethodName();
    }
}

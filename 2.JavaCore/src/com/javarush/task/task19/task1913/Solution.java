package com.javarush.task.task19.task1913;

/* 
Выводим только цифры
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleOut = System.out;

        ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
        PrintStream newOut = new PrintStream(byteArrayOut);
        System.setOut(newOut);

        testString.printSomething();

        String outResult = byteArrayOut.toString();
        String numbers = outResult.replaceAll("[^0-9]","");

        System.setOut(consoleOut);

        System.out.println(numbers);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}

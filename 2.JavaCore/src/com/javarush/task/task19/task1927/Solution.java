package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleOut = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream arrayOut = new PrintStream(outputStream);
        System.setOut(arrayOut);

        testString.printSomething();

        String advertise = "JavaRush - курсы Java онлайн";
        StringBuilder builder = new StringBuilder();
        String[] strings = outputStream.toString().split("\n");

        for(int i = 0; i < strings.length; i++){
            if (i> 0 && i % 2 == 0){
                builder.append(advertise + "\n");
            }
            builder.append(strings[i] + "\n");
        }

        System.setOut(consoleOut);
        System.out.println(builder.toString());

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}

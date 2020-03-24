package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream consoleOut = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream arrayOut = new PrintStream(byteArrayOutputStream);
        System.setOut(arrayOut);

        testString.printSomething();

        String result = byteArrayOutputStream.toString();
        byteArrayOutputStream.close();
        String operationString = result.replaceAll("[=\\s\\n]", "");
        int a = Integer.parseInt(operationString.split("[+\\-*]")[0]);
        int b = Integer.parseInt(operationString.split("[+\\-*]")[1]);
        int c = 0;
        if (operationString.contains("-")){
            c = a - b;
        } else if (operationString.contains("*")){
            c = a * b;
        } else if (operationString.contains("+")){
            c = a + b;
        }
        result = result.replace("\r\n","");

        System.setOut(consoleOut);
        System.out.println(result+c);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}


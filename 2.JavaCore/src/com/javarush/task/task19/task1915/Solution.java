package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        PrintStream consoleOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream newOut = new PrintStream(outputStream);

        //testString.printSomething();

        System.setOut(newOut);

        testString.printSomething();
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        fileOutputStream.write(outputStream.toByteArray());

        System.setOut(consoleOut);

        System.out.println(outputStream.toString());

        outputStream.close();
        reader.close();
        fileOutputStream.close();


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}


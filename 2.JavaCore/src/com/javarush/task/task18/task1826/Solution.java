package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        String mode = args[0];

        FileInputStream inputStream = new FileInputStream(args[1]);
        FileOutputStream outputStream = new FileOutputStream(args[2]);


        if (mode.equals("-e")){
            byte[] startFile = readFile(inputStream);
            writeFile(outputStream, CodeFile(startFile));
        }
        if (mode.equals("-d")){
            byte[] startFile = readFile(inputStream);
            writeFile(outputStream, deCodeFile(startFile));
        }

        inputStream.close();
        outputStream.close();
    }

    public static byte[] CodeFile(byte[] sourceFile){
        byte[] resultFile = new byte[sourceFile.length];
        for (int i = 0; i < sourceFile.length; i++){
            int value = sourceFile[i];
            value--;
            resultFile[resultFile.length-1-i] = (byte) value;
        }
        return resultFile;
    }

    public static byte[] deCodeFile(byte[] sourceFile){
        byte[] resultFile = new byte[sourceFile.length];
        for (int i = 0; i < sourceFile.length; i++){
            int value = sourceFile[i];
            value++;
            resultFile[resultFile.length-1-i] = (byte) value;
        }
        return resultFile;
    }

    public static byte[] readFile(FileInputStream readStream) throws IOException {
        byte[] bytes = new byte[readStream.available()];
        readStream.read(bytes);
        return bytes;
    }

    public static void writeFile(FileOutputStream writeStream, byte[] bytes) throws IOException {
        writeStream.write(bytes);
    }

}

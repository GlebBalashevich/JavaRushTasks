package com.javarush.task.task13.task1318;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        InputStream inputStream = new FileInputStream(fileName);
        BufferedInputStream buffer = new BufferedInputStream(inputStream);

        while(buffer.available() > 0){
            System.out.print((char)buffer.read());
        }

        buffer.close();
        reader.close();
        inputStream.close();
    }
}
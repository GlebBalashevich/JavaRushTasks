package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine());
        FileInputStream file1InputStream = new FileInputStream(reader.readLine());
        FileInputStream file2InputStream = new FileInputStream(reader.readLine());


        reader.close();

        byte[] bytes = new byte[200];
        while (file1InputStream.available() > 0){
            int count = file1InputStream.read(bytes);
            fileOutputStream.write (bytes, 0, count);
        }

        while (file2InputStream.available() > 0){
            int count = file2InputStream.read(bytes);
            fileOutputStream.write (bytes, 0 , count);
        }

        file1InputStream.close();
        file2InputStream.close();
        fileOutputStream.close();

    }
}

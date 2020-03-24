package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileNamesreader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream inputStream = new FileInputStream(fileNamesreader.readLine());
        FileOutputStream firstOutputStream = new FileOutputStream(fileNamesreader.readLine());
        FileOutputStream secondOutputStream = new FileOutputStream(fileNamesreader.readLine());

        fileNamesreader.close();

        if(inputStream.available() > 0){
            int firstLength = inputStream.available() / 2 + inputStream.available() % 2;
            int secondLength = inputStream.available() / 2;

            byte[] firstBytes = new byte[firstLength];
            byte[] secondBytes = new byte[secondLength];

            int count = inputStream.read(firstBytes);
            firstOutputStream.write(firstBytes,0,count);

            count = inputStream.read(secondBytes);
            secondOutputStream.write(secondBytes,0,count);
        }

        inputStream.close();
        firstOutputStream.close();
        secondOutputStream.close();

    }
}

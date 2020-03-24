package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String firstFileName = reader.readLine();
        String secondFileName = reader.readLine();
        reader.close();

        FileInputStream firstFileInputStream = new FileInputStream(firstFileName);
        FileOutputStream secondOutputStream = new FileOutputStream(secondFileName);

        StringBuilder buffer = new StringBuilder();

        while (firstFileInputStream.available() > 0) {
            int value = firstFileInputStream.read();
            if (value != 32) {
                buffer.append((char) value);
            }
            if (value == 32 || firstFileInputStream.available() == 0) {
                String sNumber = buffer.substring(0);
                Integer iNumber = (int) Math.round(Double.valueOf(sNumber));
                sNumber = iNumber + " ";
                secondOutputStream.write(sNumber.getBytes());

                buffer.delete(0, buffer.length());
            }
        }

        firstFileInputStream.close();
        secondOutputStream.close();
    }
}


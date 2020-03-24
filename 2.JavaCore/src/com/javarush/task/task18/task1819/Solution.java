package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String firstFileName = reader.readLine();
        String secondFileName = reader.readLine();

        FileInputStream firstFileInputStream = new FileInputStream(firstFileName);

        byte[] bytes = new byte[200];
        ArrayList<byte[]> bytesArray = new ArrayList<>();

        while(true){
            if (firstFileInputStream.available() >= 200) {
                firstFileInputStream.read(bytes);
                bytesArray.add(bytes);
            }
            else if (firstFileInputStream.available() > 0){
                byte[] lastBytes = new byte[firstFileInputStream.available()];
                firstFileInputStream.read(lastBytes);
                bytesArray.add(lastBytes);
            }
            else{
                break;
            }
        }

        FileOutputStream firstFileOutputStream = new FileOutputStream(firstFileName);
        FileInputStream secondInputStream = new FileInputStream(secondFileName);

        while(secondInputStream.available() > 0){
            int count = secondInputStream.read(bytes);
            firstFileOutputStream.write(bytes, 0 , count);
        }

        for( byte[] firstFileBytes : bytesArray){
            firstFileOutputStream.write(firstFileBytes, 0, firstFileBytes.length);
        }

        firstFileInputStream.close();
        firstFileOutputStream.close();
        secondInputStream.close();
    }
}

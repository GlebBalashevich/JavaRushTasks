package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String firstFilename = args[0];
        String secondFilename = args[1];

        InputStream reader = new FileInputStream(firstFilename);
        OutputStream writer = new FileOutputStream(secondFilename);

        Charset win = Charset.forName("windows-1251");
        Charset utf = Charset.forName("UTF-8");

        while(reader.available() > 0){
            byte[] byteArray = new byte[reader.available()];
            reader.read(byteArray);
            String s = new String(byteArray, win);
            writer.write(s.getBytes(utf));
        }

        reader.close();
        writer.close();


    }
}

package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "";
        String outputFileName = "";
        TreeMap<Integer,String> map = new TreeMap<>();

        while(!(fileName = reader.readLine()).equals("end")){
            outputFileName = (outputFileName.equals("")) ? fileName : outputFileName;
            String[] fileNamePeaces = fileName.split("\\.");
            String lastPart = fileNamePeaces[fileNamePeaces.length-1];
            int numberPart = Integer.parseInt(lastPart.substring(4));
            map.put(numberPart, fileName);
        }

        reader.close();
        String[] outputFileNamePeace = outputFileName.split(".part");
        outputFileName = outputFileNamePeace[0];
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(outputFileName), 200);

        for(Map.Entry<Integer,String > elem : map.entrySet()){
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(elem.getValue()), 200);
            while(inputStream.available() > 0){
                byte[] bytes = new byte[200];
                int count = inputStream.read(bytes);
                outputStream.write(bytes,0, count);
            }
            inputStream.close();
        }

        outputStream.close();
    }
}

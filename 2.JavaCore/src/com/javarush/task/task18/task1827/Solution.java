package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        int newId = 0;
        String id;
        String productName;
        String price;
        String quantity;

        if (args.length > 0) {
            if (args[0].equals("-c")) {
                BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
                while (fileReader.ready()) {
                    int currentId = Integer.parseInt(fileReader.readLine().substring(0, 8).trim());
                    newId = (currentId > newId) ? currentId : newId;
                }
                newId++;
                fileReader.close();

                id = formatParameter(String.valueOf(newId), 8);
                productName = formatParameter(args[1], 30);
                price = formatParameter(args[2], 8);
                quantity = formatParameter(args[3], 4);

                String result = id + productName + price + quantity;

                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
                writer.newLine();
                writer.write(result);
                writer.close();
            }
        }
    }

    public static String formatParameter(String string, int size){
        while (string.length() < size){
            string = string.concat(" ");
        }
        if (string.length() > size){
            string = string.substring(0, size);
        }
        return string;
    }

}

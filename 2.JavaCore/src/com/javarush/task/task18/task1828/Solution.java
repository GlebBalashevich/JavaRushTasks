package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        String id;
        String productName;
        String price;
        String quantity;

        if (args.length > 0) {
            if (args[0].equals("-u")) {
                BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
                ArrayList<String> fileRows = new ArrayList<>();

                while (fileReader.ready()) {
                    String row = fileReader.readLine();
                    if (row.substring(0, 8).trim().equals(args[1])){
                        id = row.substring(0, 8);
                        productName = formatParameter(args[2], 30);
                        price = formatParameter(args[3], 8);
                        quantity = formatParameter(args[4], 4);
                        row = id + productName + price + quantity;
                    }
                    fileRows.add(row);
                }
                fileReader.close();

                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                for (int i = 0; i < fileRows.size(); i++){
                    writer.write(fileRows.get(i));
                    writer.newLine();
                }
                writer.close();
            }
            if (args[0].equals("-d")){
                BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
                ArrayList<String> fileRows = new ArrayList<>();

                while (fileReader.ready()) {
                    String row = fileReader.readLine();
                    System.out.println(args[1]);
                    if (!row.substring(0, 8).trim().equals(args[1])){
                        fileRows.add(row);
                    }
                }
                fileReader.close();

                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                for (int i = 0; i < fileRows.size(); i++){
                    writer.write(fileRows.get(i));
                    writer.newLine();
                }
                writer.close();

            }
        }
    }

    public static String formatParameter(String string, int size) {
        while (string.length() < size) {
            string = string.concat(" ");
        }
        if (string.length() > size) {
            string = string.substring(0, size);
        }
        return string;
    }
}


package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String firstFileName = reader.readLine();
            String secondFileName = reader.readLine();
            reader.close();

            BufferedReader firstFileReader = new BufferedReader(new InputStreamReader(new FileInputStream(firstFileName)));
            BufferedReader secondFileReader = new BufferedReader(new InputStreamReader(new FileInputStream(secondFileName)));

            while (firstFileReader.ready()) {
                allLines.add(firstFileReader.readLine());
            }
            while (secondFileReader.ready()) {
                forRemoveLines.add(secondFileReader.readLine());
            }

            firstFileReader.close();
            secondFileReader.close();


            Solution solution = new Solution();
            solution.joinData();

        } catch (CorruptedDataException e) {
            System.out.println("Corrupted exception catched");
        } catch (IOException e) {
            System.out.println("IO exception catched");
        }
        //System.out.println(allLines);
        //System.out.println(forRemoveLines);
    }

    public void joinData() throws CorruptedDataException, IOException {
        if (allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
        }
        else{
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}

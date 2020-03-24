package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = reader.readLine();
        String secondFileName = reader.readLine();
        reader.close();

        BufferedReader firstFileReader = new BufferedReader(new FileReader(firstFileName));
        BufferedReader secondFileReader = new BufferedReader(new FileReader(secondFileName));

        ArrayList<String> firstFile = ReadFile(firstFileReader);
        ArrayList<String> secondFile = ReadFile(secondFileReader);

        firstFileReader.close();
        secondFileReader.close();

        int j = 0;
        int i = 0;
        while(i < firstFile.size() && j < secondFile.size()){
            if (firstFile.get(i).equals(secondFile.get(j))){
                LineItem item = new LineItem(Type.SAME, firstFile.get(i));
                lines.add(item);
                j++;
            } else if (firstFile.get(i).equals((secondFile.get(j+1)))){
                LineItem item = new LineItem(Type.ADDED, secondFile.get(j));
                lines.add(item);
                LineItem itemOneMore = new LineItem(Type.SAME, firstFile.get(i));
                lines.add(itemOneMore);
                j++;
                j++;
            } else{
                LineItem item = new LineItem(Type.REMOVED, firstFile.get(i));
                lines.add(item);
            }
            i++;
        }

        if (i < firstFile.size()){
            LineItem item = new LineItem(Type.REMOVED, firstFile.get(i));
            lines.add(item);
        }

        if (j < secondFile.size()){
            LineItem item = new LineItem(Type.ADDED, secondFile.get(j));
            lines.add(item);
        }

        for(LineItem item : lines){
            System.out.println(item.type + " " + item.line);
        }


    }

    public static ArrayList<String> ReadFile (BufferedReader fileReader) throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        while(fileReader.ready()){
            arrayList.add(fileReader.readLine());
        }
        return arrayList;
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}

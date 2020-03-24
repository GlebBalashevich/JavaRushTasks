package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        //C:\\JavaRushTasks\\Files\\Test.txt
        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = fileNameReader.readLine();

        //InputStream inputStream = new FileInputStream(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader (new FileInputStream(fileName)));
        //HashMap<Integer, String> strings = new HashMap<>();
        ArrayList<Integer> numbers = new ArrayList<>();

        while(reader.ready()){
            numbers.add(Integer.parseInt(reader.readLine()));
        }



//        int i = 0;
//        String val = "";
//        while(reader.available() > 0){
//            Character res = (char) reader.read();
//            if(Character.getType(res)!= 15) {
//                val += res;
//            }
//            else{
//                if (!val.equals("")) {
//                    strings.put(i,val);
//                    i++;
//                    val = "";
//                }
//            }
//            if (reader.available() <= 0){
//                strings.put(i,val);
//            }
//        }
//
//        reader.close();
//        inputStream.close();
//
//        for(Map.Entry<Integer,String> pair : strings.entrySet()){
//            int number = Integer.parseInt(pair.getValue());
//            if (number % 2 == 0){
//                numbers.add(number);
//            }
//        }
//
      Collections.sort(numbers);

        for(Integer x : numbers){
            System.out.println(x);
        }
    }
}

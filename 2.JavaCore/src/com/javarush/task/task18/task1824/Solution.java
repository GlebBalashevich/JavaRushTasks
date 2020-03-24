package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        try{
            while(true) {
                fileName = reader.readLine();
                FileInputStream inputStreamReader = new FileInputStream(fileName);
                inputStreamReader.close();
            }
        } catch (FileNotFoundException e){
            System.out.println(fileName);
            return;
        } catch(IOException e){

        }
    }
}

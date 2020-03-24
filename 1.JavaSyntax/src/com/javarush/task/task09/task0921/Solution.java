package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        try{
            while(true) {
                numbers.add(Integer.parseInt(reader.readLine()));
            }
        }
        catch(NumberFormatException e){
            for(Integer x : numbers){
                System.out.println(x);
            }
        }
        catch(IOException e){

        }
    }
}

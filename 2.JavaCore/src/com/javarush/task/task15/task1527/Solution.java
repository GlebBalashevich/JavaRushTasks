package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String urlAdress = new BufferedReader(new InputStreamReader(System.in)).readLine();

        int index = urlAdress.indexOf("?");
        String paramLine = urlAdress.substring(index+1);
        String[] params = paramLine.split("&");

        printParams(params);

    }

    public static void printParams(String[] params){
        String objVal = "";
        for(int i = 0; i < params.length; i++){
            String value = "";
            if (params[i].contains("=")){
                int ind = params[i].indexOf("=");
                value = params[i].substring(0,ind);
                if (value.equals("obj")){
                    objVal = params[i].substring(ind+1);;
                }
            }
            else{
                value = params[i];
            }
            System.out.print(value + " ");
        }
        if (!objVal.equals("")){
            System.out.println("");
            try{
                alert(Double.parseDouble(objVal));
            }
            catch(NumberFormatException e){
                alert(objVal);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}

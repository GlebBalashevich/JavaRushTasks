package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month = reader.readLine();
        Map <String,Integer> monthNumber = new HashMap<>(12);
        SimpleDateFormat date = new SimpleDateFormat("MMMM", Locale.ENGLISH);
        Calendar calendar = new GregorianCalendar();
        for (Integer i = 0; i < 12; i++) {
            calendar.set(Calendar.MONTH, i);
            monthNumber.put(date.format(calendar.getTime()), i+1);
        }
        for(Map.Entry<String, Integer> x : monthNumber.entrySet()){
            String key = x.getKey();
            if (key.equals(month)){
                System.out.println(key + " is the " + x.getValue() + " month");
                break;
            }
        }
    }
}

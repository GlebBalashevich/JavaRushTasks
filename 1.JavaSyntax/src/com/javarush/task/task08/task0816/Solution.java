package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));
        map.put("Шварц", dateFormat.parse("JUNE 1 2011"));
        map.put("Рембо", dateFormat.parse("SEPTEMBER 1 2004"));
        map.put("Ванни", dateFormat.parse("JULY 1 2003"));
        map.put("Джеки", dateFormat.parse("DECEMBER 1 2001"));
        map.put("Статхем", dateFormat.parse("JANUARY 1 2000"));
        map.put("Дизель", dateFormat.parse("MARCH 1 2008"));
        map.put("Микки", dateFormat.parse("AUGUST 1 2010"));
        map.put("Джимми", dateFormat.parse("APRIL 1 2012"));
        map.put("Питти", dateFormat.parse("AUGUST 1 2009"));

        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map){
        Iterator<Map.Entry<String, Date>> kidsIterator = map.entrySet().iterator();
        while (kidsIterator.hasNext()){
            Map.Entry<String, Date> kid = kidsIterator.next();
            int month = kid.getValue().getMonth();
            if (month == 5 || month == 6 || month == 7){
                kidsIterator.remove();
            }
        }
    }

    public static void main(String[] args) throws ParseException {
        Map<String, Date> map = createMap();
        removeAllSummerPeople(map);
    }
}

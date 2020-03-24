package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new TreeMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Belarus");
        map.put("city", "Minsk");
        map.put("age", null);

        System.out.println(getQuery(map));
    }
    public static String getQuery(Map<String, String> params) {
        String result = "";
        StringBuilder sb = new StringBuilder();

        if(params != null) {
            for (Map.Entry<String, String> pair : params.entrySet()) {
                if (pair.getValue() != null) {
                    sb.append(pair.getKey());
                    sb.append(" = '");
                    sb.append(pair.getValue());
                    sb.append("' and ");
                }
            }
        }

        if(sb.length() != 0){
            result = sb.toString();
            result = result.substring(0, result.lastIndexOf("and")).trim();
        }

        return result;
    }
}

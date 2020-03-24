package com.javarush.task.task22.task2209;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

/*
Составить цепочку слов
*/
public class Solution {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader = new BufferedReader(new FileReader(fileName));


        StringBuilder sb = new StringBuilder();
        while (reader.ready()) {
            sb.append(reader.readLine());
        }

        String[] stringArray = sb.toString().split(" ");

        StringBuilder result = getLine(stringArray);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        List<String> list = new ArrayList<>(Arrays.asList(words));
        StringBuilder sb = new StringBuilder();

        if (words.length == 0) return sb;

        while (true) {
            Collections.shuffle(list);
            Map<Integer, String> mapa = getWordsChain(list);
            if (mapa != null) {
                for (Map.Entry<Integer, String> pair : mapa.entrySet()) {
                    sb.append(pair.getValue() + " ");
                }
                break;
            }
        }

        return sb;
    }

    public static Map<Integer, String> getWordsChain(List<String> list) {
        Map<Integer, String> map = new TreeMap<>();
        int index = 0;
        map.put(index, list.get(index));

        while (index < list.size()-1) {
            for (int i = 0; i < list.size(); i++) {
                String checkingVal = list.get(i);
                if (CompareLetters(map.get(index), checkingVal)) {
                    if (!map.containsValue(checkingVal)) {
                        index++;
                        map.put(index, checkingVal);
                        break;
                    }
                }
                if (i == list.size() - 1) {
                    return null;
                }
            }

        }

        return map;
    }

    public static boolean CompareLetters(String base, String comparing) {
        base = base.toLowerCase();
        comparing = comparing.toLowerCase();
        if (base.charAt(base.length() - 1) == comparing.charAt(0)) {
            return true;
        }
        return false;
    }
}


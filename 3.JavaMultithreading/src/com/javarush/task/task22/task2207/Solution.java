package com.javarush.task.task22.task2207;

import java.io.*;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();

        while(reader.ready()){
            sb.append(reader.readLine()+" ");
        }
        String[] text = sb.toString().split(" ");
        reader.close();

        for(int j = 0; j < text.length; j++){
            String checkText = new StringBuilder(text[j]).reverse().toString();
            for(int i = j+1; i < text.length; i++){
                if (checkText.equals(text[i])){
                    Pair p = new Pair(text[j], text[i]);
                    if (!result.contains(p)) {
                        result.add(p);
                    }
                }
            }
        }


    }

    public static class Pair {
        String first;
        String second;

        public Pair(){

        }

        public Pair(String first, String second){
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                        first == null ? second :
                            second == null ? first :
                                first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}

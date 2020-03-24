package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        char[] chars = string.toCharArray();
        String vowelsSymbols = "";
        String unvowelsSymbols = "";
        char d = " ".charAt(0);
        for (int i = 0; i < chars.length; i++){
            if (chars[i] != d){
                if (isVowel(chars[i])){
                    vowelsSymbols += chars[i] + " ";
                }
                else{
                    unvowelsSymbols += chars[i] + " ";
                }
            }
        }
        System.out.println(vowelsSymbols);
        System.out.println(unvowelsSymbols);

    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}
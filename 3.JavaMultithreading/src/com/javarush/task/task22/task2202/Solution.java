package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string == null || string.split("\\s").length <= 4){
            throw new TooShortStringException();
        }

        String[] spaceArray = string.split("\\s");
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= 4; i++){
            sb.append(spaceArray[i] + " ");
        }
        String result = sb.toString().trim();
        return result;
    }

    public static class TooShortStringException extends RuntimeException{
    }
}

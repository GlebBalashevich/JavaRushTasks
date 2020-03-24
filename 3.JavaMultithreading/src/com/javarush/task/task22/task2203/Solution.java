package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null || string.indexOf("\t") == string.lastIndexOf("\t")){
            throw new TooShortStringException();
        }
        int firstTab = string.indexOf("\t");
        int secondTab = string.indexOf("\t", firstTab+1);
        String result = string.substring(firstTab+1, secondTab);
        return result;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}

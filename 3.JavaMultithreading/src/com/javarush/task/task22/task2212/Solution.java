package com.javarush.task.task22.task2212;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null) return false;
        if (!checkSymbols(telNumber)) return false;
        if (!calculateDigits(telNumber)) return false;
        if (!checkDash(telNumber)) return false;
        if (!checkParenthesis(telNumber)) return false;
        return true;

    }

    public static boolean checkSymbols(String telNumber){
        Pattern p = Pattern.compile("[^\\d\\(\\)\\-\\+]");
        Matcher m = p.matcher(telNumber);
        if (m.find()){
            return false;
        }
        return true;
    }

    public static boolean calculateDigits(String telNumber) {

        int count = 0;
        Pattern p = Pattern.compile("\\d");
        Matcher m = p.matcher(telNumber);
        while (m.find()) {
            count++;
        }

        p = Pattern.compile("^\\+");
        m = p.matcher(telNumber);
        if (m.find() && count == 12) {
            return true;
        }

        p = Pattern.compile("^[\\d\\(]");
        m = p.matcher(telNumber);
        if (m.find() && count == 10) {
            return true;
        }

        return false;
    }

    public static boolean checkDash(String telNumber){
        Pattern p = Pattern.compile("-");
        Matcher m = p.matcher(telNumber);
        int count = 0;
        while (m.find()){
            count++;
            if (count > 2){
                return false;
            }
        }

        p = Pattern.compile("-{2,}");
        m = p.matcher(telNumber);
        if (m.find()){
            return  false;
        }

        return true;
    }

    public static boolean checkParenthesis(String telNumber){
        Pattern p = Pattern.compile("\\(");
        Matcher m = p.matcher(telNumber);
        int leftCount = 0;
        while(m.find()){
            leftCount ++;
        }
        if (leftCount > 1) return false;

        p = Pattern.compile("\\)");
        m = p.matcher(telNumber);
        int rightCount = 0;
        while(m.find()){
            rightCount++;
        }
        if (rightCount > 1) return false;

        if (rightCount != leftCount) return false;
        if (rightCount == 1 && leftCount == 1){
            p = Pattern.compile("\\d\\(\\d{3}\\)[\\d\\-]");
            m = p.matcher(telNumber);
            if (!m.find()){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber("+380501234567"));
        System.out.println(checkTelNumber("+38(050)1234567"));
        System.out.println(checkTelNumber("+38050123-45-67"));
        System.out.println(checkTelNumber("050123-4567"));
        System.out.println(checkTelNumber("+38)050(1234567"));
        System.out.println(checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println(checkTelNumber("050ххх4567"));
        System.out.println(checkTelNumber("050123456"));
        System.out.println(checkTelNumber("(0)501234567"));
    }
}



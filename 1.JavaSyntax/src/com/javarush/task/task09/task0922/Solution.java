package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        String strDate = getDate();
        System.out.println(formatDate(strDate));
    }

    public static String getDate() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    public static String formatDate (String incorrectDate) throws ParseException {
        SimpleDateFormat incorrectDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date incDate = incorrectDateFormat.parse(incorrectDate);

        SimpleDateFormat correctDateFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        String corDate = correctDateFormat.format(incDate).toUpperCase();

        return corDate;
    }
}

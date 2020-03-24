package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private final Scanner fileScanner;
        public PersonScannerAdapter(Scanner fileScanner){
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            String person = fileScanner.nextLine();
            String[] personItems = person.split(" ");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM y");
            Date birthDay = dateFormat.parse(personItems[3] + " " + personItems[4] + " " + personItems[5]);

            return new Person(personItems[1], personItems[2], personItems[0], birthDay);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}

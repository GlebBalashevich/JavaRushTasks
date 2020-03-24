package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        while (fileReader.ready()){
            String data = fileReader.readLine();
            String name = data.replaceAll("[\\d]", "").trim();
            String[] date = data.replaceAll("[а-яА-Я\\-]", "").trim().split(" ");
            Calendar birthDate = new GregorianCalendar();
            birthDate.set(Integer.parseInt(date[2]), Integer.parseInt(date[1])-1, Integer.parseInt(date[0]));
            PEOPLE.add(new Person(name, birthDate.getTime()));
        }

        fileReader.close();

        for(Person people: PEOPLE){
            System.out.println(people.getName() + people.getBirthDate());
        }
    }
}

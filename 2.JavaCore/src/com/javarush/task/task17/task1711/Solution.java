package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        switch (args[0]){
            case("-c"):{
                synchronized (allPeople){
                    for (int i = 0; i < args.length-3; i += 3){
                        if (args[i+2].equals("м")){
                            allPeople.add(Person.createMale(args[i+1],new SimpleDateFormat("d/MM/y").parse(args[i+3])));
                            System.out.println(allPeople.size()-1);
                        }
                        if (args[i+2].equals("ж")){
                            allPeople.add(Person.createFemale(args[i+1],new SimpleDateFormat("d/MM/y").parse(args[i+3])));
                            System.out.println(allPeople.size()-1);
                        }
                    }
                }
                break;
            }
            case("-u"):{
                synchronized (allPeople){
                    for (int i = 0; i < args.length-4; i += 4){
                        if (args[i+3].equals("м")){
                            allPeople.set(Integer.parseInt(args[i+1]),Person.createMale(args[i+2],new SimpleDateFormat("d/MM/y").parse(args[i+4])));
                        }
                        if (args[i+3].equals("ж")){
                            allPeople.add(Integer.parseInt(args[i+1]),Person.createFemale(args[i+2],new SimpleDateFormat("d/MM/y").parse(args[i+4])));
                        }
                    }
                }
                break;
            }
            case("-d"):{
                synchronized (allPeople){
                    for(int i = 0; i < args.length-1; i++){
                        int index = Integer.parseInt(args[i+1]);
                        allPeople.get(index).setBirthDate(null);
                        allPeople.get(index).setName(null);
                        allPeople.get(index).setSex(null);
                    }
                }
                break;
            }
            case("-i"):{
                synchronized (allPeople){
                    for (int i = 0; i < args.length - 1; i++) {
                        int index = Integer.parseInt(args[i+1]);
                        Person person = allPeople.get(index);
                        char sex = (person.getSex() == Sex.MALE) ? 'м' : 'ж';
                        String bd = new SimpleDateFormat("dd-MMM-y", Locale.ENGLISH).format(person.getBirthDate());
                        System.out.println(person.getName() + " " + sex + " " + bd);
                    }
                }
                break;
            }
        }
    }
}

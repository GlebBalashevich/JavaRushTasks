package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    public String mode;
    public String name;
    public char sex;
    public Date bd;
    int id;

    public Solution(String mode, String name, String sex, String bd) throws ParseException {
        this.mode = mode;
        this.name = name;
        this.sex = sex.charAt(0);
        this.bd = new SimpleDateFormat("d/MM/y").parse(bd);
    }

    public Solution(String mode, String id, String name, String sex, String bd) throws ParseException {
        this.mode = mode;
        this.id = Integer.parseInt(id);
        this.name = name;
        this.sex = sex.charAt(0);
        this.bd = new SimpleDateFormat("d/MM/y").parse(bd);
    }

    public Solution(String mode, String id) {
        this.mode = mode;
        this.id = Integer.parseInt(id);
    }

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        if (args.length == 4){
            Solution solution = new Solution(args[0],args[1],args[2],args[3]);
            CRUD(solution);
        }
        if (args.length == 5){
            Solution solution = new Solution(args[0],args[1],args[2],args[3],args[4]);
            CRUD(solution);
        }
        if (args.length == 2){
            Solution solution = new Solution(args[0],args[1]);
            CRUD(solution);
        }
        //Solution solution = new Solution("-c", "Миронов", 'м', "15/04/2019");
        //Solution solution = new Solution("-i", 0);
    }

    public static void CRUD(Solution solution){
        if (solution.mode.equals("-c")) {
            if (solution.sex == 'м') {
                allPeople.add(Person.createMale(solution.name, solution.bd));
                System.out.println(allPeople.size()-1);
            }
            if (solution.sex == 'ж') {
                allPeople.add(Person.createFemale(solution.name, solution.bd));
                System.out.println(allPeople.size()-1);
            }
        }
        if (solution.mode.equals("-u")){
            if (solution.sex == 'м') {
                allPeople.set(solution.id,Person.createMale(solution.name, solution.bd));
            }
            if (solution.sex == 'ж') {
                allPeople.set(solution.id,Person.createFemale(solution.name, solution.bd));
            }
        }
        if (solution.mode.equals("-d")){
            allPeople.get(solution.id).setBirthDate(null);
            allPeople.get(solution.id).setName(null);
            allPeople.get(solution.id).setSex(null);
        }
        if (solution.mode.equals("-i")){
            Person person = allPeople.get(solution.id);
            char sex = (person.getSex() == Sex.MALE) ? 'м' : 'ж';
            String bd = new SimpleDateFormat("dd-MMM-y",Locale.ENGLISH).format(person.getBirthDate());
            System.out.println(person.getName() + " " + sex + " " + bd);
        }
    }
}

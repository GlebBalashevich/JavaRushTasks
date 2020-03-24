package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;
        String[] keys = {"user", "loser", "coder", "proger"};
        while (true)
        {
            key = reader.readLine();
            int index = keyValidation(key, keys);
            if (index < 0) break;
            person = getPerson(key, keys);
            doWork(person);

        }
    }

    public static void doWork(Person person) {
        if (person instanceof Person.User){
            ((Person.User) person).live();
        }
        if (person instanceof Person.Loser){
            ((Person.Loser) person).doNothing();
        }
        if (person instanceof Person.Coder){
            ((Person.Coder) person).writeCode();
        }
        if (person instanceof Person.Proger){
            ((Person.Proger) person).enjoy();
        }
    }

    public static Person getPerson (String key, String[] keys){
        if (key.equals(keys[0])){
            return new Person.User();
        }
        if (key.equals(keys[1])){
            return new Person.Loser();
        }
        if (key.equals(keys[2])){
            return new Person.Coder();
        }
        if (key.equals(keys[3])){
            return new Person.Proger();
        }
        return null;
    }


    public static int keyValidation (String key, String[] keys){
        for (int i = 0; i < keys.length; i++) {
            if (keys[i].equals(key)){
                return i;
            }
        }
        return -1;
    }
}

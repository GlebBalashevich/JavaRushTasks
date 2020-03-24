package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Human> family = new ArrayList<>();
        family.add(new Human("дед Вася", true, 58));
        family.add(new Human("дед Епистафий", true, 60));
        family.add(new Human("бабушка галина", false, 62));
        family.add(new Human("бабушка Инна", false, 59));
        family.add(new Human("папа Глеб", true, 29, family.get(0), family.get(2)));
        family.add(new Human("мама Лиза", false, 28, family.get(1), family.get(3)));
        family.add(new Human("Соня", false, 4, family.get(4), family.get(5)));
        family.add(new Human("Вероника", false, 2, family.get(4), family.get(5)));
        family.add(new Human("Оливия", false, 7, family.get(4), family.get(5)));

        for (int i = 0; i < family.size(); i++) {
            System.out.println(family.get(i));
        }
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}
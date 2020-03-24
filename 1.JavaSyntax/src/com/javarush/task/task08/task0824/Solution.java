package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<Human> family = new ArrayList<Human>();
        family.add(new Human("Kolia", true, 10));
        family.add(new Human("Dima", true, 15));
        family.add(new Human("Vitia", true, 20));
        ArrayList<Human> childrens = new ArrayList<Human>();
        childrens.addAll(family);
        Human father = new Human("Sashka", true, 50,childrens);
        Human mother = new Human("Tetka", false, 48,childrens);
        family.add(father);
        family.add(mother);
        childrens = null;
        family.add(new Human("Ded Sashki", true, 78, father));
        family.add(new Human("Babka Sashki", false, 70,father));
        family.add(new Human("Ded Tetki", true, 76,mother));
        family.add(new Human("Babka Tetki", false, 68,mother));
        for(Human x : family){
            System.out.println(x);
        }
    }

    public static class Human {
        String name = "";
        boolean sex = false;
        int age = 0;
        ArrayList<Human> children = new ArrayList<Human>();

        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, ArrayList<Human> children){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public Human(String name, boolean sex, int age, Human children){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children.add(children);

        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}

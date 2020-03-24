package com.javarush.task.task10.task1004;

/* 
Задача №4 на преобразование целых типов
*/

public class Solution {
    public static void main(String[] args) {

        int x = 7;
        incrementNumber(x);
        System.out.println(x);

        Cat cat = new Cat(7);
        catLevelUp(cat);
        System.out.println(cat.getAge());

    }

    public static void catLevelUp(Cat cat) {

        cat.setAge(cat.getAge()+1);
    }

    public static void incrementNumber(int x) {
        x++;
    }

    public static class Cat{
        int age = 0;
        public Cat(int age){
            this.age = age;
        }

        public int getAge(){
            return this.age;
        }

        public void setAge(int age){
            this.age = age;
        }

    }
}

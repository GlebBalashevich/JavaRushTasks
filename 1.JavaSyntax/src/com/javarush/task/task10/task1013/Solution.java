package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String name = "";
        private int age = 0;
        private boolean sex = true;
        private int height = 1;
        private int weight = 50;
        private String address = "";

        public Human(String name, int age, boolean sex, int height, int weight, String address){
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.height = height;
            this.weight = weight;
            this.address = address;
        }
        public Human(String name, int age, boolean sex, int height, int weight){
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.height = height;
            this.weight = weight;
        }
        public Human(String name, int age, boolean sex,String address){
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.address = address;
        }
        public Human(int age, boolean sex, int height, int weight){
            this.age = age;
            this.sex = sex;
            this.height = height;
            this.weight = weight;
        }
        public Human(String name, boolean sex, String address){
            this.name = name;
            this.sex = sex;
            this.address = address;
        }
        public Human(boolean sex, int height, int weight){
            this.sex = sex;
            this.height = height;
            this.weight = weight;
        }
        public Human(String name, String address){
            this.name = name;
            this.address = address;
        }
        public Human(String name, boolean sex){
            this.name = name;
            this.sex = sex;
        }
        public Human(int height, int weight){
            this.height = height;
            this.weight = weight;
        }
        public Human(boolean sex){
            this.sex = sex;
        }
    }
}

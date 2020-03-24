package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        Man man1 = new Man("Vasia",30,"Minsk");
        Man man2 = new Man("Petia",32,"Minsk");
        Woman woman1 = new Woman("Adel", 28, "Kaliningrad");
        Woman woman2 = new Woman("Doroteia", 29, "Minsk");
        System.out.println(man1);
        System.out.println(man2);
        System.out.println(woman1);
        System.out.println(woman2);
    }

    public static class Man{
        private String name;
        private int age;
        private String address;

        public Man(){}
        public Man(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public String getName(){
            return this.name;
        }
        public void setName(String name){
            this.name = name;
        }
        public int getAge(){
            return  this.age;
        }
        public void setAge(int age){
            this.age = age;
        }
        public String getAddress(){
            return this.address;
        }
        public void setAddress(){
            this.address = address;
        }
        public String toString() {
            return this.name + " " + this.age + " " + this.address;
        }
    }

    public static class Woman{
        private String name;
        private int age;
        private String address;

        public Woman(){}
        public Woman(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public String getName(){
            return this.name;
        }
        public void setName(String name){
            this.name = name;
        }
        public int getAge(){
            return  this.age;
        }
        public void setAge(int age){
            this.age = age;
        }
        public String getAddress(){
            return this.address;
        }
        public void setAddress(){
            this.address = address;
        }
        public String toString() {
            return this.name + " " + this.age + " " + this.address;
        }
    }
}

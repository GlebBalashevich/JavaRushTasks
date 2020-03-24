package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        int thisCount = 0;
        int anotherCount = 0;
        if (this.age > anotherCat.age)
            thisCount++;
        if (this.strength > anotherCat.strength)
            thisCount++;
        if (this.weight > anotherCat.weight)
            thisCount++;
        if (this.age < anotherCat.age)
            anotherCount++;
        if (this.strength < anotherCat.strength)
            anotherCount++;
        if (this.weight < anotherCat.weight)
            anotherCount++;
        return (thisCount > anotherCount);
    }

    public static void main(String[] args) {
        Cat catVaska = new Cat();
        catVaska.age = 5;
        catVaska.weight = 10;
        catVaska.strength = 15;
        Cat catMurzik = new Cat();
        catMurzik.age = 3;
        catMurzik.weight = 7;
        catMurzik.strength = 10;
        System.out.println(catVaska.fight(catMurzik));
    }
}

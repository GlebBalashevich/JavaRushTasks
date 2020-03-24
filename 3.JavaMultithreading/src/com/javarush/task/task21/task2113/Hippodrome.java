package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;

    public Hippodrome (List<Horse> horses){
        this.horses = horses;
    }

    public List<Horse> getHorses(){
        return horses;
    }

    public void move(){
        for(Horse horse : horses){
            horse.move();
        }
    }

    public void run() throws InterruptedException {
        for(int i = 0; i < 100; i++){
            move();
            print();
            Thread.sleep(200);
        }

    }

    public void print(){
        for(Horse horse : horses){
            horse.print();
        }
        for(int i = 0; i < 10; i++){
            System.out.println("");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(new ArrayList<>());
        game.getHorses().add(new Horse("Plotva", 3, 0));
        game.getHorses().add(new Horse("Vasilek", 3, 0));
        game.getHorses().add(new Horse("Brusnichka", 3, 0));

        game.run();
        game.printWinner();
    }

    public Horse getWinner(){
        Horse winnerHorse = null;
        for(Horse horse : horses){
            if (winnerHorse == null || horse.getDistance() > winnerHorse.getDistance()){
                winnerHorse = horse;
            }
        }
        return winnerHorse;
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

}

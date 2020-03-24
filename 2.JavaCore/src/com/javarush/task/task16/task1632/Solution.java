package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        Thread thread1 = new InfinitelyThread();
        Thread thread2 = new InterruptedThread();
        Thread thread3 = new UraThread();
        Thread thread4 = new MessageThread();
        Thread thread5 = new NThread();
        threads.add(thread1);
        threads.add(thread2);
        threads.add(thread3);
        threads.add(thread4);
        threads.add(thread5);
    }


    public static void main(String[] args) {
    }

    public static class InfinitelyThread extends Thread {
        @Override
        public void run() {
            while (true) {

            }
        }
    }

    public static class InterruptedThread extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                }
            }
        }
    }

    public static class UraThread extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {

                }
            }
        }
    }

    public static class MessageThread extends Thread implements Message {
        public boolean stopFlag = false;

        @Override
        public void run() {
            while (true) {
                if (stopFlag) {
                    break;
                }
            }
        }

        @Override
        public void showWarning() {
            stopFlag = true;
        }
    }

    public static class NThread extends Thread {
        String number;
        int amount;

        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                try {
                    number = reader.readLine();
                    if (number.equals("N")) {
                        System.out.println(amount);
                        break;
                    }
                    amount += Integer.parseInt(number);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
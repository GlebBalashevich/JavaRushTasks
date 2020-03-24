package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    Thread currentThread;

    @Override
    public void run() {
        while(!currentThread.isInterrupted()){
            System.out.println(currentThread.getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
        }

    }

    @Override
    public void start(String threadName) {
        currentThread = new Thread(this);
        currentThread.setName(threadName);
        currentThread.start();
    }

    @Override
    public void stop() {
        currentThread.interrupt();
    }
}

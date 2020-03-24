package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread{
    public Thread target;

    public LoggingStateThread (Thread target){
        this.target = target;
        setDaemon(true);
    }

    @Override
    public void run() {
        Thread.State state = null;
        while(target.getState() != State.TERMINATED) {
            if (state != target.getState()) {
                state = target.getState();
                System.out.println(state.name());
            }
        }
    }
}

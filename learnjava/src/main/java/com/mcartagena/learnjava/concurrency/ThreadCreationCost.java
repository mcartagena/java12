package com.mcartagena.learnjava.concurrency;

import java.util.Timer;
import java.util.TimerTask;

public class ThreadCreationCost {
    private static volatile boolean running = true;

    private static  Object object;

    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer(true);
        timer.schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        running = false;
                    }
                }
        , 1000);

        Runnable task = ()->{
//            System.out.println("Hello Safari students...");
        };

        long count = 0;

        while (running){
//            Thread thread = new Thread(task);
//            thread.start();
//            thread.join();
//            object = new Object();
            object = new byte[500 * 1024];
            count++;
        }

        System.out.println("count " + count);
    }
}

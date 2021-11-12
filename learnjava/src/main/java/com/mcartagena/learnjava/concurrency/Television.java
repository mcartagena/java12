package com.mcartagena.learnjava.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Television {
    private static Lock myTurn = new ReentrantLock();

    public void watch() {
        try {
//            if (myTurn.lock(5, TimeUnit.SECONDS)) { doesn't compile
            if (myTurn.tryLock(5, TimeUnit.SECONDS)) {
                System.out.println("TV Time");
                myTurn.unlock();
            }
        } catch (InterruptedException e) {
        }
    }

    public static void main(String[] t) throws Exception {
        var newTv = new Television();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> newTv.watch()).start();
            Thread.sleep(10 * 1000);
        }
    }

}

package com.mcartagena.learnjava.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PadLock {
    private Lock lock = new ReentrantLock();

    public void lockUp() {
        if (lock.tryLock()) {  // this lock has to be realeased as well
            lock.lock();
            System.out.println("Locked!");
            lock.unlock();
        }
    }

    public static void main(String[] args) throws Exception {
        var gate = new PadLock();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> gate.lockUp()).start();
            Thread.sleep(100);
        }
    }

}

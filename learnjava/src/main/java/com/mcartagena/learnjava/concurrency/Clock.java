package com.mcartagena.learnjava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class Clock {
    private AtomicLong bigHand = new AtomicLong(0);

    void incrementBy10() {
        bigHand.getAndSet(bigHand.get() + 10);
    }

    public static void main(String[] c) throws Exception {
        var smartWatch = new Clock();
        ExecutorService s = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
//            s.submit(() -> smartWatch.incrementBy10()).get();
//            the get method do to wait for the thread. then will print 1000
//            otherwise the value is indeterminated
            s.submit(() -> smartWatch.incrementBy10());
        }
        s.shutdown();
        s.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(smartWatch.bigHand.get());
    }
}


package com.mcartagena.learnjava.concurrency.locking;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Boat {
    private void waitTillFinished(CyclicBarrier c, int index) {
        try {
            c.await();
            System.out.print("W" + index);
        } catch (Exception e) {
        }
    }

    public void row(ExecutorService s) {
        var cb = new CyclicBarrier(5);
        IntStream.iterate(1, i -> i + 1)
                .limit(12)
                .forEach(i -> s.submit(() -> waitTillFinished(cb, i)));
    }

    public static void main(String[] oars) {
        ExecutorService service = null;
        try {
            service = Executors.newCachedThreadPool();
            new Boat().row(service);
        } finally {
            service.isShutdown();
        }

        service.shutdown();
//        System.out.println("service is shutdown: " + service.isShutdown());
//        System.out.println("service is terminated: " + service.isTerminated());
    }

}

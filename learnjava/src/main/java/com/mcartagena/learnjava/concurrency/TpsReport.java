package com.mcartagena.learnjava.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TpsReport {
    public void submitReports() throws ExecutionException, InterruptedException {
        var s = Executors.newCachedThreadPool();
        Future bosses = s.submit(() -> System.out.print("1"));
        s.shutdown();
        System.out.print(bosses.get());
    }

    public static void main(String[] memo) throws ExecutionException, InterruptedException {
        new TpsReport().submitReports();
    }

}

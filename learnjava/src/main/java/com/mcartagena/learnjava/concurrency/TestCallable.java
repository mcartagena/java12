package com.mcartagena.learnjava.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable c = new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.print("X");
                return 10;
            }
        };

        var s = Executors.newScheduledThreadPool(1);

        for(int i=0; i<10; i++) {
            Future f = s.submit(c);
            System.out.println(f.get());
        }

        s.shutdown();

        System.out.print("Done!");

    }
}

package com.mcartagena.learnjava.concurrency;

import java.util.concurrent.Executors;
import java.util.stream.DoubleStream;

public class PrintConstants {
    public static void main(String[] args) {
        var s = Executors.newScheduledThreadPool(10);
        DoubleStream.of(3.14159, 2.71828)
                .forEach(c -> s.submit(
                        () -> {
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println(10 * c);
                        }
                ));

        System.out.println("The execute comes...");


        s.execute(() -> System.out.println("Printed"));
    }
}

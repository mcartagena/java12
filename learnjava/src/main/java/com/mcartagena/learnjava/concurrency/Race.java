package com.mcartagena.learnjava.concurrency;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Race {
    ExecutorService service = Executors.newFixedThreadPool(8);

    public static int sleep() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        return 1;
    }

    public void hare() {
        try {
            Callable<Integer> c = () -> sleep();
            final var r = List.of(c, c, c);
            var results = service.invokeAll(r);
            System.out.println("Hare won the race!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void tortoise() {
        try {
            Callable<Integer> c = () -> sleep();
            final var r = List.of(c, c, c);
            Integer result = service.invokeAny(r);
            System.out.println("Tortoise won the race!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] p) throws Exception {
        var race = new Race();
        race.service.execute(() -> race.hare());
        race.service.execute(() -> race.tortoise());
    }
}


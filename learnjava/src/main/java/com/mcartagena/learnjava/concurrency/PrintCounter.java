package com.mcartagena.learnjava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class PrintCounter {
    static int count = 0;

    private AtomicInteger s1 = new AtomicInteger(0); // w1
    private int s2 = 0;

    private void countSheep() throws InterruptedException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor(); // w2
            for (int i = 0; i < 100; i++)
                service.execute(() -> {
                    s1.getAndIncrement();
                    s2++;
                }); // w3
            Thread.sleep(100);
            System.out.println(s1 + " " + s2);
        } finally {
            if (service != null) service.shutdown();
        }
    }

    public static void main(String[] args) {

/*        // ExecutorService service = null;
        try {
            ExecutorService service = Executors.newSingleThreadExecutor();
            var r = new ArrayList<Future<?>>();
            IntStream.iterate(0, i-> i+1).limit(5).forEach(
                    i-> r.add(service.submit(
                            () -> {
                                count++;
                                return i;
                            }
                    ))
            );
            for(Future<?> result : r)
                System.out.print(result.get() + " "); // n2
            System.out.println("Count final " + count);

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // if(service != null) service.shutdown();
        }*/

/*        var data = List.of(List.of(1,2),
                List.of(3,4),
                List.of(5,6));

        System.out.println("stream and findFirst");

        data.stream() // p1
                .flatMap(s -> s.stream())
                .findFirst() // p2
                .ifPresent(System.out::print);

        System.out.println("stream and findAny");

        data.stream() // p1
                .flatMap(s -> s.stream())
                .findAny() // p2
                .ifPresent(System.out::print);

        System.out.println("parallelStream and findFirst");

        data.parallelStream() // p1
                .flatMap(s -> s.stream())
                .findFirst() // p2
                .ifPresent(System.out::print);

        System.out.println("parallelStream and findAny");

        data.parallelStream() // p1
                .flatMap(s -> s.stream())
                .findAny() // p2
                .ifPresent(System.out::print);*/

        PrintCounter printCounter = new PrintCounter();
        try {
            printCounter.countSheep();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

package com.mcartagena.learnjava.concurrency;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Bank {
    private Lock vault = new ReentrantLock();
    private int total = 0;

    public void deposit(int value) {
        try {
            this.vault.tryLock();
            total += value;
        } finally {
            this.vault.unlock();
        }
    }

    public static void main(String[] args) {
//        var bank = new Bank();
//        IntStream.range(1,10)
//                .parallel()
//                .forEach(s -> bank.deposit(s));
//
//        System.out.println(bank.total);

//        var value1 = new AtomicLong(0);
//        final long[] value2 = {0};
//        IntStream.iterate(1, i -> 1).limit(100).parallel()
//                .forEach(i -> value1.incrementAndGet());
//        IntStream.iterate(1, i -> 1).limit(100).parallel()
//                .forEach(i -> ++value2[0]);
//        System.out.println(value1+" "+value2[0]);

//        var data = List.of(2,5,1,9,8);
//        data.stream().parallel()
//                .mapToInt(s -> s)
//                .peek(System.out::println)
//                .forEachOrdered(System.out::println);

        /*
        // countIceCreamFlavors();
        long start = System.nanoTime();
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Invocation returned after " + invocationTime
                + " msecs");

        try {
            // takingANap();
            twoPrints();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Execution returned after " + retrievalTime + " msecs");

        */

        // testingParallelStream();

        BlockingQueue<Integer> parameter = new ArrayBlockingQueue<Integer>(10);

        try {
            addAndPrintItems(parameter);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static int counter;

    public static void countIceCreamFlavors() {
        counter = 0;
        Runnable task = () -> counter++;
        LongStream.range(1, 500)
                .forEach(m -> new Thread(task).run());
        System.out.println(counter);
    }

    public static void takingANap() throws InterruptedException {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(4);
            service.execute(() -> {
                try {
                    takeNap();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            service.execute(() -> {
                try {
                    takeNap();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            service.execute(() -> {
                try {
                    takeNap();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        } finally {
            if (service != null) service.shutdown();
        }
        service.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println("DONE!");

    }

    public static void takeNap() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("Finished the nap...");
    }

    public static void twoPrints() throws ExecutionException, InterruptedException {
        Object o1 = new Object();
        Object o2 = new Object();
        var service = Executors.newFixedThreadPool(2);
        var f1 = service.submit(() -> {
            synchronized (o1) {
                synchronized (o2) {
                    System.out.print("Tortoise");
                }
            }
        });
        var f2 = service.submit(() -> {
            synchronized (o2) {
                synchronized (o1) {
                    System.out.print("Hare");
                }
            }
        });
        f1.get();
        f2.get();

    }

    public static void testingParallelStream() {
        var cats = Stream.of("leopard", "lynx", "ocelot", "puma")
                .parallel();
        var bears = Stream.of("panda", "grizzly", "polar").parallel();
        var data = Stream.of(cats, bears).flatMap(s -> s)
                .collect(Collectors.groupingByConcurrent(
                        s -> !s.startsWith("p")));
        System.out.println(data.get(false).size() + " " + data.get(true).size());

    }

    public static void addAndPrintItems(BlockingQueue<Integer> queue) throws InterruptedException {
        queue.offer(103);
        queue.offer(20, 1, TimeUnit.SECONDS);
        queue.offer(85, 7, TimeUnit.HOURS);
        System.out.print(queue.poll(200, TimeUnit.NANOSECONDS));
        System.out.print(" " + queue.poll(1, TimeUnit.MINUTES));
    }

}

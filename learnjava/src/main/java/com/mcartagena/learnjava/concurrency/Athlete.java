package com.mcartagena.learnjava.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Athlete {
    int stroke = 0;

    private List<Integer> data = new ArrayList<>();

    public synchronized void addValue(int value) {
        data.add(value);
    }

    public int getValue(int index) {
        return data.get(index);
    }

    public int size() {
        synchronized (Athlete.class) {
            return data.size();
        }
    }

    public synchronized void swimming() {
        stroke++;
    }

    private int getStroke() {
        synchronized (this) {
            return stroke;
        }
    }

    public static void main(String... laps) throws InterruptedException, ExecutionException {
        ExecutorService s = Executors.newFixedThreadPool(10);
        Athlete a = new Athlete();
        for (int i = 0; i < 10; i++) {
//            s.execute(() -> a.swimming());
            s.execute(() -> a.addValue(1));
            Future<Integer> value = s.submit(() -> a.getValue(0));
            Future<Integer> size = s.submit(() -> a.size());
            System.out.println(value.get());
            System.out.println(size.get());
        }
        s.shutdown();
        s.awaitTermination(10, TimeUnit.SECONDS);
//        System.out.print(a.getStroke());

    }

}

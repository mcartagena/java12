package com.mcartagena.learnjava.concurrency;

import java.util.List;

public class ParallelStreamExample {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        List.of(1,2,3,4,5)
                // .stream()  // Time: 25 seconds
                .parallelStream()   // Time: 5 seconds
                .map(w -> doWork(w))
                .forEach(s-> System.out.println(s + " "));

        System.out.println();
        var timeTaken = (System.currentTimeMillis() -  start)/1000;
        System.out.println("Time: " + timeTaken + " seconds");

    }

    private static int doWork(int input){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException...");
        }
        return  input;
    }
}

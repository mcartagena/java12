package com.mcartagena.learnjava.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class CopyAndWriteExample {
    public static void main(String[] args) {

        /*
        //List<Integer> favNumbers = new CopyOnWriteArrayList<>(List.of(4, 3, 42));
        //List<Integer> favNumbers = List.of(4, 3, 42);  // java.lang.UnsupportedOperationException
        List<Integer> favNumbers = new ArrayList<> (List.of(4, 3, 42));  // java.util.ConcurrentModificationException

        for(var n: favNumbers) {
            System.out.println(n + " ");
            favNumbers.add(9);
        }
        System.out.println();
        System.out.println("Size: " + favNumbers.size());

         */

        /*
        // Set<Character> favLetters = new CopyOnWriteArraySet<>(List.of('a','t'));
        // Set<Character> favLetters = Set.of('a','t');  // java.lang.UnsupportedOperationException
        Set<Character> favLetters = new HashSet<>(); // java.util.ConcurrentModificationException
        favLetters.add('a');
        favLetters.add('t');
        for(char c: favLetters) {
            System.out.print(c+" ");
            favLetters.add('s');
        }
        System.out.println();
        System.out.println("Size: "+ favLetters.size());

         */

//        List<String> birds = new CopyOnWriteArrayList<>();
//        birds.add("hawk");
//        birds.add("hawk");
//        birds.add("hawk");

//        for (String bird : birds)
//            birds.remove(bird);
//        System.out.print(birds.size()); // 0

        List<String> birds = new ArrayList<>();
        birds.add("hawk");
        birds.add("hawk");
        birds.add("hawk");

        var iterator = birds.iterator();
        while(iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }

        System.out.println(birds.size());

        try {
            var blockingQueue = new LinkedBlockingQueue<Integer>();
            blockingQueue.offer(39);
            blockingQueue.offer(3, 4, TimeUnit.SECONDS);
            System.out.println(blockingQueue.poll());
            System.out.println(blockingQueue.poll(10, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            // Handle interruption
        }

    }
}

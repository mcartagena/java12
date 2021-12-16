package com.mcartagena.learnjava.streams;

import java.util.*;
import java.util.stream.Stream;

public class CombiningStreams {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("tire-");
        List<String> list = new LinkedList<>();
        Deque<String> queue = new ArrayDeque<>();
        queue.push("wheel-");
        Stream.of(set, list, queue)
                .flatMap(x -> x.stream())  // DON'T COMPILE if x es alone it has to be stream
                .forEach(System.out::print);

        System.out.println("-----------------------");

        var list2 = List.of('c', 'b', 'a');

        list2.stream()
                .sorted()
                .findAny()
                .ifPresent(System.out::println);

        System.out.println(list2.stream().sorted().findFirst());

        System.out.println("-----------------------");

        var list1 = new LinkedList<>();
        list1.add("Archie");
        list1.add("X-Men");
        Stream s = list1.stream();  // line w
        s.forEach(System.out::println);
        s.forEach(System.out::println);  // this line will throw an IllegalStateExceptio due that the stream was comsumed


    }
}

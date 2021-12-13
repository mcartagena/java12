package com.mcartagena.learnjava.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Bull {
    void charge() {

        ToIntFunction<Integer> transformer = x -> x;

        var prime = List.of(3, 1, 4, 1, 5, 9)
                .stream()
                .limit(1)
                .peek(s -> {
                })
                .mapToInt(transformer)
                .peek(s -> {
                })
                .sum();

        System.out.println(prime);

        var stream = Stream.of(1, 2, 3);
        System.out.println(stream.min(Integer::compareTo));

        IntStream.range(1, 6)
                .parallel()
                .forEachOrdered(System.out::print);


        var list = new ArrayList<String>();
        list.add("Monday");
        list.add(new String());
        list.add("Tuesday");
        list.remove(0);
        System.out.println("list.get(0)" + list.get(0));

    }

    public static void main(String[] args) {
        var b = new Bull();
        b.charge();
    }
}


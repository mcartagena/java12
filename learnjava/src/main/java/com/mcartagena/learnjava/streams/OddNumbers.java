package com.mcartagena.learnjava.streams;

import java.util.stream.Stream;

public class OddNumbers {
    public static void main(String[] args) {
        Stream<Integer> oddNumberUnder100 = Stream.iterate(
                1,
                n -> n < 100,
                n -> n + 2
        );

        // convert to pair
        oddNumberUnder100
                .map(x-> x-1)
                .forEach(System.out::println);

        System.out.println(oddNumberUnder100);
    }
}

package com.mcartagena.learnjava.streams;

import java.util.ArrayList;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class TestIntStream {
    public static void main(String[] args) {
        IntStream count = IntStream.iterate(1, n -> n + 1)
                .limit(5);

        count.forEach(System.out::print);
        System.out.println();

        IntStream range = IntStream.range(1, 6);

        range.forEach(System.out::print);
        System.out.println();

        IntStream rangeClosed = IntStream.rangeClosed(1, 5);

        rangeClosed.forEach(System.out::print);

        Stream<String> objStream = Stream.of("penguin", "fish");
        IntStream intStream = objStream.mapToInt(s -> s.length());

        var integerList = new ArrayList<Integer>();

        IntStream ints = integerList.stream()
                .flatMapToInt(x -> IntStream.of(x));

        DoubleStream doubles = integerList.stream()
                .flatMapToDouble(x -> DoubleStream.of(x));

        LongStream longs = integerList.stream()
                .flatMapToLong(x -> LongStream.of(x));
        System.out.println();

        var stream = IntStream.rangeClosed(1, 10);
        OptionalDouble optional = stream.average();

        optional.ifPresent(System.out::println);
        System.out.println(optional.getAsDouble());
        System.out.println(optional.orElseGet(() -> Double.NaN));

    }
}

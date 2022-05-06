package com.mcartagena.learnjava.streams;

import java.util.ArrayList;
import java.util.OptionalDouble;
import java.util.stream.*;

public class TestIntStream {
    public static void main(String[] args) {
//        creatingIntStream();
        collectingResults();
    }

    private static void creatingIntStream() {
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

    private static void collectingResults() {
        IntStream count = IntStream.iterate(1, n -> n + 1)
                .limit(5);

        System.out.println(count.count());

//        System.out.println(count.summaryStatistics().getAverage());

        Stream<String> str = Stream.of("1", "2", "3", "4", "5");

//        System.out.println(str.collect(Collectors.averagingInt(num -> Integer.parseInt(num))));

//        System.out.println(str.collect(Collectors.averagingLong(num -> Long.parseLong(num))));

        System.out.println(str.collect(Collectors.counting()));
    }
}

package com.mcartagena.learnjava.streams;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.*;

public class TestStreams {
    public static void main(String[] args) {
        var stream = Stream.iterate("", (s) -> s + 1);
        System.out.println(
                stream
                        .limit(2)
                        .map(x -> x + "2")
        );

/*        Predicate<String> predicate = s -> s.length()> 3;
        var stream1 = Stream.iterate("-",
                s -> ! s.isEmpty(), (s) -> s + s);
        var b1 = stream1.noneMatch(predicate);
        var b2 = stream1.anyMatch(predicate);  // throws runtime exception
        System.out.println(b1 + " " + b2);*/

        double result = LongStream.of(6L, 8L, 10L)
                .mapToInt(x -> (int) x)
                .boxed()
                .collect(Collectors.groupingBy(x -> x))
                .keySet()
                .stream()
                .collect(Collectors.averagingInt(x -> x));

        System.out.println(result);

        IntStream intStream = IntStream.range(1, 10000);
        AtomicInteger ai = intStream.filter(i -> i % 2 == 0)
                .parallel()
                .collect(AtomicInteger::new,
                        (a, b) -> a.set(a.get() + b),
                        (a, b) -> a.set(a.get() + b.get())
                );

        System.out.println(ai);

        double result1 = LongStream.of(6L, 8L, 10L)
                .mapToInt(x -> (int) x)
                .boxed()
                .collect(Collectors.groupingBy(x -> x, Collectors.toSet()))
                .keySet()
                .stream()
                .collect(Collectors.averagingInt(x -> x));

        System.out.println(result1);

        var stream2 = LongStream.of(1, 2, 3);
        var opt = stream2.map(n -> n * 10)
                .filter(n -> n < 5).findFirst();

        opt.ifPresent(System.out::println);

        System.out.println("Print 10 lines");
        Stream.generate(() -> "1")
                .limit(10)  // N:
                .peek(System.out::println) //O:
                .filter(x -> x.length() > 1)  //L:
                .forEach(System.out::println) //M:
        ;

        System.out.print(
                Stream.iterate(1, x -> ++x)
                        .limit(5).map(x -> "" + x)
                        .collect(Collectors.joining())
        );

        System.out.println();

        List<Integer> x1 = List.of(1, 2, 3);
        List<Integer> x2 = List.of(4, 5, 6);
        List<Integer> x3 = List.of();

        Stream.of(x1, x2, x3)
                .map(x -> x)
                .flatMap(x -> x.stream())
                .forEach(System.out::print);

        Predicate<String> empty = String::isEmpty;
        Predicate<String> notEmpty = empty.negate();

        var result3 = Stream.generate(() -> "")
                .limit(10)
                .filter(notEmpty)
                .collect(Collectors.groupingBy(k -> k))
                .entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .flatMap(Collection::stream)
                //.collect(Collectors.partitioningBy(notEmpty));
                .collect(Collectors.groupingBy(n -> n));

        System.out.println(result3);

        var s = DoubleStream.of(1.2, 2.4);
        long count = s
                .peek(System.out::println)
                .filter(x -> x > 2)
                .count();

        System.out.println(count);

        System.out.println("Function compose...");

        Function<Integer, Integer> s1 = a -> a + 4;
        Function<Integer, Integer> t = a -> a * 3;
        Function<Integer, Integer> c = s1.compose(t);
        System.out.println(c.apply(1));

        List<Integer> x = IntStream.range(1, 6)
                .mapToObj(i -> i)
                .collect(Collectors.toList());
        x.forEach(System.out::println);

        IntStream.range(1,6).forEach(System.out::println);

    }
}

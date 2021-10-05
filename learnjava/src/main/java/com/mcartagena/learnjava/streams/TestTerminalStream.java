package com.mcartagena.learnjava.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class TestTerminalStream {
    public static void main(String[] args) {
        createExamples();

        terminateExamples();

        intermediateExamples();

    }

    private static void intermediateExamples() {
        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        s.filter(x -> x.startsWith("m"))
                .forEach(System.out::println); // monkey

        Stream<String> s2 = Stream.of("duck", "duck", "duck", "goose");
        s2.distinct()
                .forEach(System.out::println); // duckgoose

        Stream<Integer> s3 = Stream.iterate(1, n -> n + 1);
        s3.skip(5)
                .limit(2)
                .forEach(System.out::print); // 67

        System.out.println();

        Stream<String> s4 = Stream.of("monkey", "gorilla", "bonobo");
        s4.map(String::length)
                .forEach(System.out::print); // 676

        System.out.println();

        List<String> zero = List.of();
        var one = List.of("Bonobo");
        var two = List.of("Mama Gorilla", "Baby Gorilla");
        Stream<List<String>> animals = Stream.of(zero, one, two);

        animals.flatMap(m -> m.stream())
                .forEach(System.out::println);

        Stream<String> s5 = Stream.of("brown-", "bear-");
        s5.sorted()
                .forEach(System.out::print); // bear-brown-

        System.out.println();

        Stream<String> s6 = Stream.of("brown bear-", "grizzly-");
        s6.sorted(Comparator.reverseOrder())
                .forEach(System.out::print); // grizzly-brown bear-

        System.out.println();

        var stream = Stream.of("black bear", "brown bear", "grizzly");
        long count = stream.filter(a -> a.startsWith("g"))
                .peek(System.out::println).count();              // grizzly

        System.out.println(count);                          // 1
    }

    private static void createExamples() {
        Stream<String> s = Stream.of("Monkey", "Gorilla", "Bonobo");
        System.out.println(s.count());
    }

    private static void terminateExamples() {
        Stream<String> strm = Stream.of("Monkey", "Gorilla", "Bonobo");
        Optional<String> min = strm.min((s1, s2) -> s1.length() - s2.length());

        min.ifPresent(System.out::println);

        Optional<?> minEmpty = Stream.empty().min((s1, s2) -> 0);

        System.out.println(minEmpty.isPresent());

        Stream<String> strm1 = Stream.of("monkey", "gorilla", "bonobo");
        Stream<String> infinite = Stream.generate(() -> "chimp");

        strm1.findAny().ifPresent(System.out::println);
        infinite.findAny().ifPresent(System.out::println);

        var list = List.of("monkey", "2", "chimp");
        Stream<String> infinite2 = Stream.generate(() -> "chimp");

        Predicate<String> pred = x -> Character.isLetter(x.charAt(0));

        System.out.println(list.stream().anyMatch(pred));
        System.out.println(list.stream().allMatch(pred));
        System.out.println(list.stream().noneMatch(pred));
        System.out.println(infinite2.anyMatch(pred));

        Stream<String> strConcat = Stream.of("w", "o", "l", "f");
        String word = strConcat.reduce("", (s3, c) -> s3 + c);
        System.out.println(word);

        Stream<Integer> strInt = Stream.of(3, 5, 6);
        System.out.println(strInt.reduce(1, (a, b) -> a * b));

        BinaryOperator<Integer> op = (a, b) -> a * b;

        Stream<Integer> empty = Stream.empty();
        Stream<Integer> oneElement = Stream.of(3);
        Stream<Integer> threeElement = Stream.of(3, 5, 6);

        empty.reduce(op).ifPresent(System.out::println);
        oneElement.reduce(op).ifPresent(System.out::println);
        threeElement.reduce(op).ifPresent(System.out::println);

        Stream<String> stream = Stream.of("w", "o", "l", "f!");
        int length = stream.reduce(0, (i, sInter) -> i + sInter.length(), (a, b) -> a + b);
        System.out.println(length); // 5

        Stream<String> stream1 = Stream.of("w", "o", "l", "f");

        StringBuilder word1 = stream1.collect(
                StringBuilder::new,
                StringBuilder::append,
                StringBuilder::append);

        System.out.println(word1); // wolf

        Stream<String> stream2 = Stream.of("w", "o", "l", "f");

        TreeSet<String> set = stream2.collect(
                TreeSet::new,
                TreeSet::add,
                TreeSet::addAll);

        System.out.println(set); // [f, l, o, w]
    }
}

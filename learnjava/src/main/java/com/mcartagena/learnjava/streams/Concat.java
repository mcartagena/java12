package com.mcartagena.learnjava.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Concat {
    public String concat1(List<String> values) {
        return values.parallelStream()
                .reduce("a",
                        (x, y) -> x + y,
                        String::concat);
    }

    public String concat2(List<String> values) {
        return values.parallelStream()
                .reduce((w, z) -> z + w).get();
    }

    public static void main(String... questions) {
        Concat c = new Concat();
        var list = List.of("Cat", "Hat");
        String x = c.concat1(list);
        String y = c.concat2(list);
        System.out.print(x + " " + y);

        System.out.println("----------------------------");

        var list2 = new ArrayList<String>();
        list2.add("Atlanta");
        list2.add("Chicago");
        list2.add("New York");
        list2.stream()
                .filter(str -> !str.isEmpty())
                .forEach(System.out::println);

        System.out.println("----------------------------");

        var chars = Stream.generate(() -> 'a').limit(3);
        chars.filter(chr -> chr < 'b')
                .sorted()
                .findFirst()
                .ifPresent(System.out::print);

        System.out.println("----------------------------");

        Stream.iterate(1, x1 -> x1 + 1)
                .limit(5)
                .skip(2)
                .peek(System.out::println)
                .collect(Collectors.toList())
                .forEach(System.out::print);


    }

}

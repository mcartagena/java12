package com.mcartagena.learnjava.streams;

import java.util.stream.DoubleStream;

public class TestDoubleStream {
    public static void main(String[] args) {
        DoubleStream empty = DoubleStream.empty();
        empty.forEach(System.out::println);

        DoubleStream oneValue = DoubleStream.of(3.14);
        oneValue.forEach(System.out::println);

        DoubleStream varargs = DoubleStream.of(1.0, 1.1, 1.2);
        varargs.forEach(System.out::println);

        System.out.println("Infinite Streams");

        var random = DoubleStream.generate(Math::random);
        var fractions = DoubleStream.iterate(.5, d-> d/2);

        random.limit(3).forEach(System.out::println);
        fractions.limit(3).forEach(System.out::println);

    }
}

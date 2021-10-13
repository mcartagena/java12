package com.mcartagena.learnjava.streams;

import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;

public class TestPrimitiveStream {
    public static void main(String[] args) {
        LongStream longs = LongStream.of(5, 10);
        //long sum = longs.sum();

        System.out.println(longs.summaryStatistics());

//        System.out.println(sum);

        DoubleStream doubles = DoubleStream.generate(() -> Math.PI)
                .limit(10);
        OptionalDouble min = doubles.min();
        System.out.println(min);
    }
}

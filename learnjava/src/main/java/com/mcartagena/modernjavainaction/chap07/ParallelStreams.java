package com.mcartagena.modernjavainaction.chap07;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStreams {

    public static long iterativeSum(long n){
        long sum = 0;

        for(long num = 0; num <= n; num++){
            sum += num;
        }

        return sum;

    }

    public static long sequentialSum(long n){
        return Stream.iterate(1L,num -> num + 1).limit(n).reduce(Long::sum).get();
    }

    public static long parallelSum(long n){
        return Stream.iterate(1L,num->num+1).limit(n).parallel().reduce(Long::sum).get();
    }

    public static long rangeSum(long n){
        return LongStream.rangeClosed(1,n).reduce(0L,Long::sum);
    }

    public static long parallelRangeSum(long n){
        return LongStream.rangeClosed(1,n).parallel().reduce(0L,Long::sum);
    }

    public static long sideEffectSum(long n){
        Accumulator accumulator = new Accumulator(0);

        LongStream.rangeClosed(1,n).forEach(accumulator::add);

        return accumulator.getTotal();
    }

    public static long sideEffectParallelSum(long n){
        Accumulator accumulator = new Accumulator(0);
        LongStream.rangeClosed(1,n).parallel().forEach(accumulator::add);
        return accumulator.getTotal();
    }
}

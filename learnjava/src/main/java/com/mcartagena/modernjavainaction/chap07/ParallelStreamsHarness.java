package com.mcartagena.modernjavainaction.chap07;

import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;

public class ParallelStreamsHarness {

    public static final ForkJoinPool FORK_JOIN_POOL = new ForkJoinPool();

    public static void main(String[] args) {
        System.out.println("Iterative Sum done in: " + measurePerformance(ParallelStreams::iterativeSum, 10_000_000L) + " msecs");
        System.out.println("Sequential Sum done in: " + measurePerformance(ParallelStreams::sequentialSum, 10_000_000L) + " msecs");
        System.out.println("Parallel forkJoinSum done in: " + measurePerformance(ParallelStreams::parallelSum, 10_000_000L) + " msecs");
        System.out.println("Range forkJoinSum done in: " + measurePerformance(ParallelStreams::rangeSum, 10_000_000L) + " msecs");
        System.out.println("Parallel range forkJoinSum done in: " +  measurePerformance(ParallelStreams::parallelRangeSum, 10_000_000L) + " msecs");
        System.out.println("SideEffect sum done in: " + measurePerformance(ParallelStreams::sideEffectSum, 10_000_000L) + " msecs");
        System.out.println("SideEffect parallel sum done in: " + measurePerformance(ParallelStreams::sideEffectParallelSum, 10_000_000L) + " msecs");
        System.out.println("ForkJoin sum done in: " + measurePerformance(ForkJoinSumCalculator::forkJoinSum, 10_000_000L) + " msecs" );
    }

    public static <T, R> long measurePerformance(Function<T,R> func, T input){
        long fastest = Long.MAX_VALUE;
        for(int i = 0; i<10;i++){
            long start = System.nanoTime();
            R result = func.apply(input);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + result);
            if(duration < fastest){
                fastest = duration;
            }
        }
        return fastest;
    }

}

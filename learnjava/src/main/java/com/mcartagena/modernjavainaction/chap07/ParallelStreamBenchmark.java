package com.mcartagena.modernjavainaction.chap07;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 2,jvmArgs = {"-Xms4G", "-Xmx4G"})
@State(Scope.Thread)
@Measurement(iterations = 2)
@Warmup(iterations = 3)
public class ParallelStreamBenchmark {
    private static final long N = 10_000_000L;

    @Benchmark
    public long iteractiveSum(){
        return ParallelStreams.iterativeSum(N);
    }

    @Benchmark
    public long sequentialSum(){
        return ParallelStreams.sequentialSum(N);
    }

    @Benchmark
    public long parallelSum(){
        return ParallelStreams.parallelSum(N);
    }

    @Benchmark
    public long rangeSum(){
        return ParallelStreams.rangeSum(N);
    }

    @Benchmark
    public long parallelRangeSum(){
        return ParallelStreams.parallelRangeSum(N);
    }

    @TearDown(Level.Invocation)
    public void tearDown(){
        System.gc();
    }

}

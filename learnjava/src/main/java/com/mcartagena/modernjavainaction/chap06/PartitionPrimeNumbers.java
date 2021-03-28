package com.mcartagena.modernjavainaction.chap06;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.partitioningBy;

public class PartitionPrimeNumbers {
    public static void main(String[] args) {
        // Numbers partitioned in prime and non-prime:
        System.out.println("Numbers partitioned in prime and non-prime: " + numbersPartitionedInPrimeAndNonPrime(100));
        // Numbers partitioned in prime and non-prime with custom collector:
        System.out.println("Numbers partitioned in prime and non-prime with custom collector:" + numbersPartitionedInPrimeAndNonPrimeWithCustomCollector(100));
    }

    public static Map<Boolean, List<Integer>>  numbersPartitionedInPrimeAndNonPrimeWithCustomCollector(int n) {
        return IntStream.rangeClosed(2,n).boxed().collect(new PrimeNumbersCollector());
    }

    public static Map<Boolean, List<Integer>> numbersPartitionedInPrimeAndNonPrime(int n) {
        return IntStream.rangeClosed(2,n).boxed().collect(partitioningBy(PartitionPrimeNumbers::isPrime));
    }

    public static boolean isPrime(int candidate){
        int candidateRoot = (int) Math.sqrt(candidate);
        return IntStream.range(2,candidate-1)
                .limit((long) Math.floor(Math.sqrt(candidate)) - 1)
                .noneMatch(i -> candidate % i == 0);
    }

}

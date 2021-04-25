package com.mcartagena.modernjavainaction.chap10;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class PrintNumbers {
    public static void main(String[] args) {
        List<String> numbers = Arrays.asList("one","two","three");

        // syntactic noise that provides no additional benefit and
        // (even better) is no longer necessary in Java 8
        numbers.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        // using lambdas extensively results in a DSL with a more acceptable
        // signal/noise ratio by reducing the verbosity that you get with
        // anonymous inner classes
        System.out.println("Lambda expression:");
        numbers.forEach(s -> System.out.println(s));

        // even more concisely by a method reference
        System.out.println("Method reference:");
        numbers.forEach(System.out::println);

    }
}

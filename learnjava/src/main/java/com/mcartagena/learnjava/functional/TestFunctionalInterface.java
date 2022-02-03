package com.mcartagena.learnjava.functional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.*;

public class TestFunctionalInterface {
    public static void main(String[] args) {
        supplierExample();

//        consumerExamples();
//
//        predicateExamples();
//
//        functionExamples();

    }

    private static void functionExamples() {
        Function<String, Integer> f1 = String::length;
        Function<String, Integer> f2 = t -> t.length();

        System.out.println(f1.apply("cluck"));
        System.out.println(f2.apply("cluck"));

        BiFunction<String, String, String> b1 = String::concat;
        BiFunction<String, String, String> b2 = (t, v) -> t.concat(v);

        System.out.println(b1.apply("baby", "chick"));
        System.out.println(b2.apply("baby", "chick"));

        UnaryOperator<String> u1 = String::toUpperCase;
        UnaryOperator<String> u2 = t -> t.toUpperCase();

        System.out.println(u1.apply("hello"));
        System.out.println(u2.apply("hello"));

        BinaryOperator<String> b3 = String::concat;
        BinaryOperator<String> b4 = (t, v) -> t.concat(v);

        System.out.println(b3.apply("baby", "chick"));
        System.out.println(b4.apply("baby", "chick"));
    }

    private static void predicateExamples() {
        Predicate<String> p1 = String::isEmpty;
        Predicate<String> p2 = a -> a.isEmpty();

        System.out.println(p1.test(""));
        System.out.println(p2.test(""));

        BiPredicate<String, String> b1 = String::startsWith;
        BiPredicate<String, String> b2 = (str, prefix) -> str.startsWith(prefix);

        System.out.println(b1.test("chicken", "chick"));
        System.out.println(b2.test("chicken", "chick"));
    }

    private static void consumerExamples() {
        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = a -> System.out.println(a);

        c1.accept("testing consumer 1");
        c2.accept("testing consumer 2");

        var map = new HashMap<String, Integer>();
        BiConsumer<String, Integer> biConsumer = map::put;
        BiConsumer<String, Integer> biConsumer1 = (t, u) -> map.put(t, u);

        biConsumer.accept("chicken", 7);
        biConsumer1.accept("chick", 1);

        System.out.println(map);

        var map1 = new HashMap<String, String>();
        BiConsumer<String, String> biConsumer2 = map1::put;
        BiConsumer<String, String> biConsumer3 = (t, u) -> map1.put(t, u);

        biConsumer2.accept("chicken", "Cluck");
        biConsumer3.accept("chick", "Tweep");

        System.out.println(map1);
    }

    private static void supplierExample() {
        Supplier<LocalDate> s1 = LocalDate::now;
        Supplier<LocalDate> s2 = () -> LocalDate.now();

        LocalDate d1 = s1.get();
        LocalDate d2 = s2.get();

        System.out.println("Date1 " + d1 + " Date2 " + d2);

        Supplier<StringBuilder> sb1 = StringBuilder::new;
        Supplier<StringBuilder> sb2 = () -> new StringBuilder();

        System.out.println("sb1 " + sb1 + " sb2 " + sb2);

        Supplier<ArrayList<String>> s3 = ArrayList<String>::new;

        ArrayList<String> a1 = s3.get();

        System.out.println(a1);
    }
}

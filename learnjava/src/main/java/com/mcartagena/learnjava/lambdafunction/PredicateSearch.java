package com.mcartagena.learnjava.lambdafunction;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PredicateSearch {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("fish", false, true));

        print(animals, Animal::canHop);

        Consumer<String> consumer = System.out::println;

        print(consumer, "Hello World");

        Supplier<Integer> number = () -> 42;

        System.out.println(returnNumber(number));

        List<String> bunnies = new ArrayList<>();

        bunnies.add("long ear");
        bunnies.add("floppy");
        bunnies.add("hoppy");

        System.out.println(bunnies);

        bunnies.sort(Comparator.naturalOrder());

        System.out.println(bunnies);

        bunnies.removeIf(s -> s.charAt(0) != 'h');

        System.out.println(bunnies);



    }

    private static void print(List<Animal> animals,
                              Predicate<Animal> checker) {

        animals.forEach(animal -> {
            if (checker.test(animal))
                System.out.println(animal + " ");
        });

        System.out.println();
    }

    private static void print(Consumer<String> consumer, String value) {
        consumer.accept(value);
    }

    private static int returnNumber(Supplier<Integer> supplier) {
        return supplier.get();
    }
}

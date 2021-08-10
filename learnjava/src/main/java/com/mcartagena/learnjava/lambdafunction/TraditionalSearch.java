package com.mcartagena.learnjava.lambdafunction;

import java.util.ArrayList;
import java.util.List;

public class TraditionalSearch {
    public static void main(String[] args) {

        // list of animals
        List<Animal> animals = new ArrayList<>();

        animals.add(new Animal("fish", false, true));
        animals.add(new Animal("kangaroo", true, false));
        animals.add(new Animal("rabbit", true, false));

        // pass class that does check
        print(animals, new CheckIfHopper());

        System.out.println("Using lambda functions...");
        System.out.println();

        System.out.println("Can Hop...");
        animals.forEach(a ->
                System.out.println(
                        a.canHop() ? a + " " : ""
                )
        );

        System.out.println("\nCan Swin...");
        animals.forEach(animal ->
                System.out.println(
                        animal.canSwim() ? animal + " " : ""
                ));

        System.out.println("Can't Swin...");
        animals.forEach(animal ->
                System.out.println(
                        !animal.canSwim() ? animal + " " : ""
                ));

    }

    private static void print(List<Animal> animals,
                              CheckIfHopper checker) {
        for (var animal : animals) {
            // the general check
            if (checker.test(animal))
                System.out.println(animal + " ");
        }
        System.out.println();
    }
}

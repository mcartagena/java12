package com.mcartagena.learnjava.general;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class TraditionalSearch {
    public static void main(String[] args) {
        // list of animals
        var animals = new ArrayList<Animal>();
        animals.add(new Animal("fish", false, true));
        animals.add(new Animal("kangaroo", true, true));
        animals.add(new Animal("rabbit", true, false));
        animals.add(new Animal("turtle", false, true));

        // Pass lambda that does check
        System.out.println("Animals that can hop...");
        print(animals, animal -> animal.isCanHop());

        System.out.println("Animals that can swim...");
        print(animals, animal -> animal.isCanSwim());

        System.out.println("Animals that can't swim...");
        print(animals, animal -> !animal.isCanSwim());
    }

    private static void print(List<Animal> animals, Predicate<Animal> checker ){
        for (Animal animal: animals){
            if(checker.test(animal)){
                System.out.println(animal + " ");
            }
        }
    }
}
